package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
	private int x;
	private int y;
	private int xp;
	private int yp;
	private int xm;
	private int ym;
	private IMobile mobile;
	public int compt = 0;
	private IProjectile projectile;
	private IMonstre monstre;
	private String map;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		setMap();
		setMonstre();
		setHero();
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
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		afficheMap(map, graphics);
		if(mobile != null){
			setX();
			setY();
			setProjectile();
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/lorann_r.png"));
				graphics.drawImage(img, x, y, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
		
		if(this.projectile != null){
			compt += 1;
			this.projectile.deplacement();
			setXP();
			setYP();
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/fireball_1.png"));
				graphics.drawImage(img, xp, yp, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			if(compt == 10){
				this.projectile.changeDirection();
				compt = 0;
			}
			collision = this.mobile.Collision(xp,yp);
			if(collision == 1){
				collision =0;
				this.mobile.mortProjectile();
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				afficheMap(map, graphics);
				try {
					Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/lorann_r.png"));
					graphics.drawImage(img, x, y, this);
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(monstre != null){
			setMonstre();
			this.monstre.patternCarre(xm,ym);
			setXM();
			setYM();
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_1.png"));
				graphics.drawImage(img, xm, ym, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			collision = this.monstre.Collision(x,y);
			if(collision == 1){
				collision =0;
				this.mobile = null;
				this.viewFrame.getModel().deadHero();
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				afficheMap(map, graphics);
				graphics.drawString("dead", x, y);
				try {
					Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_1.png"));
					graphics.drawImage(img, xm, ym, this);
				} catch (final IOException e) {
					e.printStackTrace();
				}
				
			}
			collision = this.monstre.Collision(xp,yp);
			if(collision == 1){
				collision =0;
				this.mobile.mortProjectile();
				this.viewFrame.getModel().deadMonstre();
				this.monstre = null;
				this.ym = 0;
				this.xm = 0;
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				afficheMap(map, graphics);
				try {
					Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/lorann_r.png"));
					graphics.drawImage(img, x, y, this);
				} catch (final IOException e) {
					e.printStackTrace();
				}
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
		this.xp = this.projectile.getX();
	}
	public void setYP(){
		this.yp = this.projectile.getY();
	}
	public void setMonstre(){
		this.monstre = this.viewFrame.getModel().getMonstre();
	}
	public void setXM(){
		this.xm = this.monstre.getX();
	}
	public void setYM(){
		this.ym = this.monstre.getY();
	}
	public void setMap(){
		this.map = this.viewFrame.getModel().getMap();
	}

	public void afficheMap(String map, final Graphics graphics){
		int k = 0;
		char[] map1 = map.toCharArray();
		String affiche;
		for(int i = 1; i <=12; i++){
			for(int j = 0; j< 20; j++){
				affiche = Character.toString(map1[k]);
				if(affiche.equals(" ")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/case.jpg"));
						graphics.drawImage(img, j*32, i*32, this);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("o")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/bone.png"));
						graphics.drawImage(img, j*32, i*32, this);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("-")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/horizontal_bone.png"));
						graphics.drawImage(img, j*32, i*32, this);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("|")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/vertical_bone.png"));
						graphics.drawImage(img, j*32, i*32, this);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("S")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/gate_closed.png"));
						graphics.drawImage(img, j*32, i*32, this);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("G")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/purse.png"));
						graphics.drawImage(img, j*32, i*32, this);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("B")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/crystal_ball.png"));
						graphics.drawImage(img, j*32, i*32, this);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				//graphics.drawString(affiche, j*32, i*32);
				
				k++;
			}
		}
	}
}
