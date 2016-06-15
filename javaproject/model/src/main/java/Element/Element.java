package Element;
import java.awt.Image;

import contract.IModel;
import contract.ISprite;
import contract.Permeability;

public class Element {
	protected  ISprite				sprite;
	private Permeability	permeability;
	private IModel	model;

	public Element(final ISprite sprite, final Permeability permeability){
	}
	
	public ISprite getSprite() {
	return this.sprite;
	}

	private void setSprite(final ISprite sprite) {
	this.sprite = sprite;
	}

	public Permeability getPermeability() {
	return this.permeability;
	}

	private void setPermeability(final Permeability permeability) {
	this.permeability = permeability;
	}

	protected IModel getModel() {
	return this.model;
	}

	public void setModel(final IModel model) {
	this.model = model;
	}

	public Image getImage(){
	return this.getSprite().getImage();
	}
}
