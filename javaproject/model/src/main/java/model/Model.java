package model;

import java.sql.SQLException;
import java.util.Observable;

import mobile.Hero;
import contract.IMobile;
import contract.IModel;



/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */

public class Model extends Observable implements IModel {
	//private int width;
	//int height;
	//public MotionLessElement							elements[][];
	//public final ArrayList<Mobile>						mobiles;
	private Hero										hero;
	private IMobile										mobile;
//	private ObjetRecuperable							objetRecuperable;
	private String message;

	

	/**
	 * Instantiates a new model.
	 */

	public Model() {
		this.message = "";
		initHero();
	}



	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	public String getMessage() {
		return this.message;
	}
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}
	
/*
	public int getWidth(){
		return width;
		
	}
	public int getHeight(){
		return height;
	}*/
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void initHero(){
		final Hero hero = new Hero(20,20);
		this.mobile = hero;
	}
	
	public IMobile getHero(){
		return mobile;
	}
	
	public Observable getObservable() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	/*
	@Override
	public MotionLessElement getElements(final int x, final int y) {
		return this.elements[x][y];
	}

	@Override
	public Hero getHero() {
		return this.hero;
	}
	public ObjetRecuperable getObjetRecuperable(){
		return this.objetRecuperable;
	}

	private void addElement(final MotionLessElement element, final int x, final int y) {

	}

	@Override
	public void addMobile(final Mobile mobile, final int x, final int y) {
		
	}

	@Override
	public void addMobile(final Hero hero, final int x, final int y) {
		
	}
	@Override
	public void addMobile(final ObjetRecuperable objetRecuperable, final int x, final int y) {
		
	}

	private void loadFile(final String fileName) throws IOException {
		
	}

	private void setHero(final Hero hero) {
		this.hero = hero;
	
	}
	
	// ObjetRecuperable
	private void setObjetRecuperable(final ObjetRecuperable objetRecuperable) {
		this.objetRecuperable = objetRecuperable;
		
	}

	@Override
	public void setMobileHasChanged() {
		this.setChanged();
	}

	@Override
	public void notifyObservers() {
		super.notifyObservers();
	}

	@Override
	public Element[][] getElements() {
		return this.elements;
	}

	@Override
	public ArrayList<Mobile> getMobiles() {
		return this.mobiles;
	}
	*/

	
}
