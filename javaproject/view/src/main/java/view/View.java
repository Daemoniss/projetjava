package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.Action;
import contract.IController;
import contract.IModel;
import contract.IView;
/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;
	//private IModel model;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		//this.model = model;
		//this.mobile.setViewPanel(viewFrame);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static Action keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
		
			case KeyEvent.VK_Z:
				return Action.Up;
			case KeyEvent.VK_S:
				return Action.Down;
			case KeyEvent.VK_Q:
				return Action.Left;
			case KeyEvent.VK_D:
				return Action.Right;
			case KeyEvent.VK_A:
				return Action.LeftUp;
			case KeyEvent.VK_E:
				return Action.RightUp;
			case KeyEvent.VK_W:
				return Action.LeftDown;
			case KeyEvent.VK_C:
				return Action.RightDown;
			case KeyEvent.VK_SPACE:
				return Action.Shoot;
			default:
				return Action.No;
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
