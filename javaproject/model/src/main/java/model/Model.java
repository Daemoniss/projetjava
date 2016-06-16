package model;

import java.sql.SQLException;

import java.util.Observable;

import contract.IModel;
import Mobile.*;
import contract.IMobile;


/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message;
	private IMobile mobile;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		//this.message = "";
		loadMap(5);
		
		//initMonstre();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMap() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMap(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMap(final int mapid) {
		try {
			final DAOLorannWorld daoLorannWorld = new DAOLorannWorld(DBConnection.getInstance().getConnection());
			this.setMap(daoLorannWorld.find(mapid).getMaptxt());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	public void initHero(){
		final hero hero = new hero(20,20);
		this.mobile = hero;
	}
	/*public void initMonstre(){
		Monstre monstre = new Monstre(, 10, 10);
		this.mobile = monstre;
	}*/

	public IMobile getHero() {
		
		return null;
	}

	public void refresh() {
		
		
	}
}
