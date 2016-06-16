package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IMobile;
import contract.IProjectile;


/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame	viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	private int x = 20;
	private int y = 20;
	private IMobile mobile;
	public int compt = 0;
	private IProjectile projectile;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	/*private ViewFrame getViewFrame() {
		return this.viewFrame;
	}*/

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		/*this.x = this.viewFrame.getX();
		this.y = this.viewFrame.getY();*/
		setHero();
		setX();
		setY();
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.drawString("hero", x, y);
		setProjectile();
		if(this.projectile != null){
			compt += 1;
			this.projectile.deplacement();
			setXP();
			setYP();
			graphics.drawString("projectile", x, y);
			if(compt == 10){
				this.projectile.changeDirection();
				System.out.println("test");
				compt = 0;
			}
		}
		
		
		
	}
	public void setX(){
		this.x = this.mobile.getX();
	}
	public void setY(){
		this.y = this.mobile.getY();
	}
	public void setHero(){
		this.mobile = this.viewFrame.getModel().getHero();
	}
	public void setProjectile(){
		this.projectile = this.mobile.getProjectile();
	}
	public void setXP(){
		this.x = this.projectile.getX();
	}
	public void setYP(){
		this.y = this.projectile.getY();
	}
}
