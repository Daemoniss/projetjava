package model;

/*import java.sql.SQLException;*/
import java.sql.SQLException;
import java.util.Observable;

import motionLess.Crystal;
import Mobile.hero;
import Mobile.monstre;
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
	private String map;
	private ICrystal crystal;
	private int Crystalrecup;
	private String map3 = null;
	private char[] map2;
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		/*this.message = "";*/
		initCrystal();
		loadMessage(changeMap.L1);
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
	public void changeMap(int x,int y){
		int pos = (x/32)+(((y-1)/32)*20);
		this.map2 = this.map.toCharArray();
		map2[pos] = ' ';
		map3 = Character.toString(map2[0]);
		for(int j = 1; j <=239; j++){
			map3 = map3 + map2[j];
		}
		this.map = map3;
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
	public ICrystal getCrystal(){
		return crystal;
	}
	public void initCrystal(){
		this.crystal = new Crystal(0,0, null);
	}
	public void setCrystalRecup(int Crystalrecup ){
		this.Crystalrecup = Crystalrecup;
		this.element.setCrystalRecup(this.Crystalrecup);
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
	public void initHero(int x, int y){
		this.mobile = new hero(x,y);

	}
	
	public IMobile getHero(){
		return mobile;
	}
	
	public void initMonstre(int x, int y){
		this.monstre = new monstre(x, y);
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
}
