package controller;

import contract.Action;
import contract.IController;
import contract.IModel;
import contract.IView;
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
		this.view.printMessage("Welcome to the great caverns of Nova-Ann, Lorann ! You must pass through the 5 crypts and free them from Nekron's evil. But watch out ! You only have 3 chances !");
	}
	
	public void messageEnd(int score, int life) {
		this.view.printMessage("You have win\nScore : " + score + "\n life : " + life);
	}
	
	public void messageDeath(int score) {
		this.view.printMessage("You are dead\nScore : " + score);
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
	public void orderPerform(final Action direction) {
		switch (direction) {
			case Up:
				/*this.model.loadMessage("GB");*/
				this.model.refresh();
				this.dire = 1;
				this.mobile.setDirection(dire);
				break;
			case Down:
				/*this.model.loadMessage("FR");*/
				this.model.refresh();
				this.dire = 2;
				this.mobile.setDirection(dire);
				break;
			case Left:
				/*this.model.loadMessage("DE");*/
				this.model.refresh();
				this.dire = 3;
				this.mobile.setDirection(dire);
				break;
			case Right:
				/*this.model.loadMessage("ID");*/
				this.model.refresh();
				this.dire = 4;
				this.mobile.setDirection(dire);
				break;
			case RightDown:
				this.model.refresh();
				this.dire = 5;
				this.mobile.setDirection(dire);
				break;
			case RightUp:
				this.model.refresh();
				this.dire = 6;
				this.mobile.setDirection(dire);
				break;
			case LeftDown:
				this.model.refresh();
				this.dire = 7;
				this.mobile.setDirection(dire);
				break;
			case LeftUp:
				this.model.refresh();
				this.dire = 8;
				this.mobile.setDirection(dire);
				break;
			case Shoot:
				this.model.refresh();
				this.mobile.shoot();
				break;

			default:
				this.model.refresh();
				this.dire = 0;
				this.mobile.setDirection(dire);
				break;
		}
	}

}
