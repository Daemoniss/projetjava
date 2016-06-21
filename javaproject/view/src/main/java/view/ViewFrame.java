package view;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import contract.IController;
import contract.IModel;
import contract.IViewFrame;
/*import contract.IMobile;*/

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */

/**
 * @author toto
 *
 */
/**
 * @author toto
 *
 */
/**
 * @author toto
 *
 */
/**
 * @author toto
 *
 */
/**
 * @author toto
 *
 */
/**
 * @author toto
 *
 */
/**
 * @author toto
 *
 */
/**
 * @author toto
 *
 */
class ViewFrame extends JFrame implements KeyListener, IViewFrame{
	/** The model. */
	private IModel						model;

	/** The controller. */
	private IController				controller;
	private int score, Life;
	/** The Constant serialVersionUID. */
	/*private IMobile mobile;*/
	private static final long	serialVersionUID	= -697358409737458175L;
	/*public int x = 20;
	public int y = 20;*/

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
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

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(700 + this.getInsets().left + this.getInsets().right, 600 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		setScore(score);
		afficherScore();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}
	/** affiche the Score
	 * 
	 */
	 
	void afficherScore(){
		JPanel panel = new JPanel();
		setScore(score);
		JLabel label = new JLabel("Votre score est de : " + score + ". Il vous reste : " + Life + ".");
		panel.add(label);
		this.getContentPane().removeAll();
		this.getContentPane().add((label), BorderLayout.SOUTH);
		this.getContentPane().revalidate();
		
	}
	public void setScore(int score){
		this.score = score;

	}

	public int getScore(int score) {
		return score;
	}
	
	public void setLife(int Life){
		this.Life = Life;

	}

	public int getVie(int Life) {
		return Life;
	}
	public void EndWindows(){
		dispose();
	}

	/*public void setY(int coordonney) {
		// TODO Auto-generated method stub
		this.y = coordonney;
		
	}

	public void setX(int coordonnex) {
		// TODO Auto-generated method stub
		this.x = coordonnex;
		
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}*/
}
