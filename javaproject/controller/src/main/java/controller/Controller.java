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
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.setMobile();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Bienvenue dans les grandes cavernes de Nova-Ann, Lorann ! \nTu dois traverser les 5 cryptes et les libérer du mal de Nekron le Maléfique. Mais attention, tu n'as le droit qu'à 3 chances !");
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
	
	private void setMobile(){
		this.mobile = this.model.getHero();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final direction direction) {
		switch (direction) {
			case Haut:
				/*this.model.loadMessage("GB");*/
				this.dire = 1;
				this.mobile.setDirection(dire);
				break;
			case Bas:
				/*this.model.loadMessage("FR");*/
				this.dire = 2;
				this.mobile.setDirection(dire);
				break;
			case Gauche:
				/*this.model.loadMessage("DE");*/
				this.dire = 3;
				this.mobile.setDirection(dire);
				break;
			case Droite:
				/*this.model.loadMessage("ID");*/
				this.dire = 4;
				this.mobile.setDirection(dire);
				break;
			case DroiteBas:
				this.dire = 5;
				this.mobile.setDirection(dire);
				break;
			case DroiteHaut:
				this.dire = 6;
				this.mobile.setDirection(dire);
				break;
			case GaucheBas:
				this.dire = 7;
				this.mobile.setDirection(dire);
				break;
			case GaucheHaut:
				this.dire = 8;
				this.mobile.setDirection(dire);
				break;
			case Espace:
				this.mobile.tire();
				break;

			default:
				this.dire = 0;
				this.mobile.setDirection(dire);
				break;
		}
	}

}
