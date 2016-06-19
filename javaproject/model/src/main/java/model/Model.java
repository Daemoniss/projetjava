package model;

/*import java.sql.SQLException;*/
import java.sql.SQLException;
import java.util.Observable;

import Mobile.Crystal;
import Mobile.Hero;
import Mobile.Monstre;
import contract.IBourse;
import contract.ICrystal;
import contract.IElement;
import contract.IModel;
import contract.IMobile;
import contract.IMonstre;
import contract.changeMap;
import element.element;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	/*private String message;*/

	private IMobile mobile;
	private IMonstre monstre;
	private IElement element;
	private ICrystal crystal;
	private String map;
	private int Crystalrecup;
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		/*this.message = "";*/
		initHero();
		initMonstre();
		initCrystal();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	/*public String getMessage() {
		return this.message;
	}*/

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	public void refresh() {
		/*this.message = message;*/
		this.setChanged();
		this.notifyObservers();
	}
	public void setMap(String map){
		this.map = map;
		initElementMap(map);
		
	}
	public String getMap(){
		return map;
	}
	public void initElementMap(String map){
		this.element = new element(map);
	}
	
	public int verifPos(int x, int y){
		int collision;
		collision = this.element.VerifPosition(y,x);
		return collision;
		
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final changeMap l1) {
		String Map = null;
		switch(l1){
		case L1:
			Map = "L1";
			break;
		case L2:
			Map = "L2";
			break;
		case L3:
			Map = "L3";
			break;
		case L4:
			Map = "L4";
			break;
		case L5:
			Map = "L5";
			break;
		default:
			break;
		}
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMap(daoHelloWorld.find(Map).getMaptxt());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void initHero(){
		this.mobile = new Hero(14*32,6*32);
		loadMessage(changeMap.L2);

	}
	
	public IMobile getHero(){
		return mobile;
	}
	public ICrystal getCrystal(){
		return crystal;
	}
	public void initCrystal(){
		this.crystal = new Crystal();
	}
	
	public void initMonstre(){
		this.monstre = new Monstre(160, 192);
	}
	public IMonstre getMonstre(){
		return monstre;
	}
	public void deadHero(){
		this.mobile = null;
	}
	public void deadMonstre(){
		this.monstre = null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	
	public Observable getObservable() {
		return this;
	}

	public int CrystalRecup() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setCrystalRecup(int Crystalrecup ){
		this.Crystalrecup = Crystalrecup;
		this.element.setCrystalRecup(this.Crystalrecup);
		}

	@Override
	public IBourse getBourse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
