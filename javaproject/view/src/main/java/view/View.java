package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.IMobile;
import contract.direction;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;
	private IModel model;
	private IMobile mobile;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		this.model = model;
		getMobile();
		this.mobile.setViewPanel(viewFrame);
		SwingUtilities.invokeLater(this);
	}

	
	
	
	
	
	
	
	protected static direction keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_Z:
				return direction.HAUT;
			case KeyEvent.VK_S:
				return direction.BAS;
			case KeyEvent.VK_Q:
				return direction.GAUCHE;
			case KeyEvent.VK_D:
				return direction.DROIT;
			default:
				return direction.HAUT;
		}
		
	
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
	public void getMobile(){
		this.mobile = this.model.getHero();
	}
}
