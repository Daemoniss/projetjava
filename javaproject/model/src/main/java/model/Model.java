package model;

/*import java.sql.SQLException;*/
import java.util.Observable;

import Mobile.hero;
import Mobile.monstre;
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
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		/*this.message = "";*/
		initHero();
		initMonstre();
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
		this.mobile = new hero(32,32);

	}
	
	public IMobile getHero(){
		return mobile;
	}
	
	public void initMonstre(){
		this.monstre = new monstre(64, 96);
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
