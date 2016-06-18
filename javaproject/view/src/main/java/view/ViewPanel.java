package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.ICrystal;
import contract.IMobile;
import contract.IMonstre;
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
	private int x=20;
	private int y=20;
	private int xc;
	private int yc;
	private int xp;
	private int yp;
	private int xm;
	private int ym;
	private IMobile mobile;
	private ICrystal crystal;
	public int compt = 0;
	private IProjectile projectile;
	private IMonstre monstre;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		setMonstre();
		setHero();
		setCrystal();
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
		
		int collision;
		int recup = 0;
		if(mobile != null){
			setX();
			setY();
			graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
			graphics.drawString("H", x, y);
			
		}
		
		
		setProjectile();
		
		
		if(this.projectile != null){
			compt += 1;
			this.projectile.deplacement();
			setXP();
			setYP();
			graphics.drawString("P", xp, yp);
			if(compt == 10){
				this.projectile.changeDirection();
				compt = 0;
			}
			
			
			
			
			collision = this.mobile.Collision(xp,yp);
			
			
			
			if(collision == 1){
				this.mobile.mortProjectile();
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				graphics.drawString("H", x, y);
			}
		}
		
		
		
		if(crystal != null){
			setCrystal();
			setXC();
			setYC();
			graphics.drawString("C", xc, yc);
			if(xc==x &&yc==y ){
			 recup = 1;
			}
			//collision = this.crystal.Collision(xc,yc);
			if(recup == 1){
				this.crystal = null;
				this.viewFrame.getModel().deadCrystal();
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				graphics.drawString("H", x, y);	
			}
		}
			
		
		
		
		
		if(monstre != null){
			setMonstre();
			this.monstre.patternCarre(xm,ym);
			setXM();
			setYM();
			graphics.drawString("M", xm, ym);
			collision = this.monstre.Collision(x,y);
			if(collision == 1){
				this.mobile = null;
				this.viewFrame.getModel().deadHero();
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				graphics.drawString("D", x, y);
				graphics.drawString("M", xm, ym);
				
			}
			
			
			collision = this.monstre.Collision(xp,yp);
			
			
			if(collision == 1){
				this.mobile.mortProjectile();
				this.viewFrame.getModel().deadMonstre();
				this.monstre = null;
				this.ym = 0;
				this.xm = 0;
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				graphics.drawString("H", x, y);
			}
		}		
		
	}
	
	public void setMonstre(){
		this.monstre = this.viewFrame.getModel().getMonstre();
	}
	public void setCrystal(){
		this.crystal = this.viewFrame.getModel().getCrystal();
	}
	public void setHero(){
		this.mobile = this.viewFrame.getModel().getHero();
	}
	public void setProjectile(){
		this.projectile = this.mobile.getProjectile();
	}
	
	
	public void setX(){
		this.x = this.mobile.getX();
	}
	public void setY(){
		this.y = this.mobile.getY();
	}
	
	public void setXP(){
		this.xp = this.projectile.getX();
	}
	public void setYP(){
		this.yp = this.projectile.getY();
	}

	public void setXM(){
		this.xm = this.monstre.getX();
	}
	public void setYM(){
		this.ym = this.monstre.getY();
	}
	
	public void setXC(){
		this.xc = this.crystal.getX();
	}
	public void setYC(){
		this.yc = this.crystal.getY();
	}
}
