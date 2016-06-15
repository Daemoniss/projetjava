package model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import mobile.Hero;
import mobile.Mobile;
import Element.Element;
import MotionLessElement.MotionLessElement;
import contract.IModel;



/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */

public class Model extends Observable implements IModel {
	private int width;
	int height;
	public MotionLessElement				elements[][];
	public final ArrayList<Mobile>	mobiles;
	private Hero										hero;
//	private ObjetRecuperable							objetRecuperable;

	

	/**
	 * Instantiates a new model.
	 */

	public Model() {
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Model( int width,int height) {
		
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */

	public int getWidth(){
		return width;
		
	}
	public int getHeight(){
		return height;
	}
	
	
	

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	
	@Override
	public MotionlessElement getElements(final int x, final int y) {
		return this.elements[x][y];
	}

	@Override
	public Hero getHero() {
		return this.hero;
	}
	public ObjetRecuperable getObjetRecuperable(){
		return this.objetRecuperable;
	}

	private void addElement(final MotionlessElement element, final int x, final int y) {

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
	

	public Observable getObservable() {
		return this;
	}
}
