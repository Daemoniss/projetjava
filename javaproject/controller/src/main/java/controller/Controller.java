package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.direction;
import contract.IMobile;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;
	
	private IMobile mobile;
	public int dire ;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model, final IMobile mobile) {
		this.setView(view);
		this.setModel(model);
		this.setmobile(mobile);
	}

	/* d
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	private void setmobile(final IMobile mobile){
		this.mobile = mobile;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final direction direction) {
		switch (direction) {
			case Haut:
				this.model.loadMessage("GB");
				this.dire = 1;
				this.mobile.setdirection(dire);
				break;
			case Bas:
				this.model.loadMessage("FR");
				this.dire = 2;
				this.mobile.setdirection(dire);
				break;
			case Gauche:
				this.model.loadMessage("DE");
				this.dire = 3;
				this.mobile.setdirection(dire);
				break;
			case Droite:
				this.model.loadMessage("ID");
				this.dire = 4;
				this.mobile.setdirection(dire);
				break;

			default:
				break;
		}
	}

}
