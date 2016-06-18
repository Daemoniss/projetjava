package model;

/*import java.sql.SQLException;*/
import java.util.Observable;

import Mobile.Crystal;
import Mobile.Hero;
import Mobile.Monstre;
import contract.ICrystal;
import contract.IModel;
import contract.IMobile;
import contract.IMonstre;

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
	private ICrystal crystal;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	/*public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}*/
	public void initHero(){
		this.mobile = new Hero(32,32);

	}
	public void initCrystal(){
		this.crystal = new Crystal(128,128);

	}
	
	public IMobile getHero(){
		return mobile;
	}
	public ICrystal getCrystal(){
		return crystal;
	}
	
	public void initMonstre(){
		this.monstre = new Monstre(64, 96);
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
	/*public void deadCrystal(){
		this.crystal = null;
	}*/

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	
	public Observable getObservable() {
		return this;
	}

	public void deadCrystal() {
		// TODO Auto-generated method stub
		
	}
}
