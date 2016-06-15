package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.direction;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.IMobile;
/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;
	private IMobile mobile;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model, IMobile mobile) {
		this.viewFrame = new ViewFrame(model);
		this.mobile = mobile;
		this.mobile.setViewPanel(viewFrame);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static direction keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_Z:
				return direction.Haut;
			case KeyEvent.VK_S:
				return direction.Bas;
			case KeyEvent.VK_Q:
				return direction.Gauche;
			case KeyEvent.VK_D:
				return direction.Droite;
			default:
				return direction.Haut;
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
}
