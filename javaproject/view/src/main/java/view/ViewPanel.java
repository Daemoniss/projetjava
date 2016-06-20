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
import contract.changeMap;


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
	private int x = 18*32;
	private int y = 8 *32;
	private int xp;
	private int yp;
	private int xm = 32 * 8;
	private int ym = 32 * 6;
	private IMobile mobile;
	private IProjectile projectile;
	private IMonstre monstre;
	private String map;
	private int xc;
	private int yc;
	private int xd;
	private int yd;
	private ICrystal crystal;
	public int CrystalRecup =0;
	public int map1 = 1;

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
		this.viewFrame.getModel().initHero( x, y);
		this.viewFrame.getModel().initMonstre( xm, ym);
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
		int detection;
		int correction = 0;
		int recup = 0;
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		afficheMap(map, graphics);
		if(mobile != null){
			setX();
			setY();
			setProjectile();
			detection = this.viewFrame.getModel().verifPos(x,y);
			if(detection == 1){
				this.mobile.ResetMove();
				setX();
				setY();
			}
			else if(detection == 2){
				this.viewFrame.getModel().changeMap(x,y);
				setMap();
			}
			else if(detection == 3){
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
			else if(detection ==4){
				map1++;
				if(map1 == 2){
					this.viewFrame.getModel().loadMessage(changeMap.L2);
				}
				else if(map1 == 3){
					this.viewFrame.getModel().loadMessage(changeMap.L3);
				}
				if(map1 == 4){
					this.viewFrame.getModel().loadMessage(changeMap.L4);
				}
				if(map1 == 5){
					this.viewFrame.getModel().loadMessage(changeMap.L5);
				}
				setMap();
				afficheMap(map, graphics);
				this.viewFrame.getModel().initHero( x, y);
				this.mobile.setX(x);
				this.mobile.setY(y);
				this.viewFrame.getModel().initMonstre( xm, ym);
				this.monstre.setX(xm);
				this.monstre.setY(ym);
				setCrystal();
				CrystalRecup = 0;
				
				
			}
			if(detection != 3){
				try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/lorann_r.png"));
				graphics.drawImage(img, x, y, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			}
			detection =0;
		}
		if(crystal != null){
			
			
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/crystal_ball.png"));
				graphics.drawImage(img, xc, yc, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			if(xc==x &&yc==y ){
			 recup = 1;
			}
			if(recup == 1){
				this.crystal = null;
				CrystalRecup=1;
				this.viewFrame.getModel().setCrystalRecup(CrystalRecup);
				try {
					Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/lorann_r.png"));
					graphics.drawImage(img, xc, yc, this);
				
				} catch (final IOException e) {
					e.printStackTrace();
				}
				try {
					Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/gate_open.png"));
					graphics.drawImage(img, xd, yd, this);
				
				} catch (final IOException e) {
					e.printStackTrace();
				}	
				recup=0;
			}
			}
		
		if(this.projectile != null){
			this.projectile.deplacement();
			setXP();
			setYP();
			detection = this.viewFrame.getModel().verifPos(xp,yp);
			if(detection != 0){
				this.mobile.ResetMove();
				setXP();
				setYP();
				this.projectile.changeDirection();
				this.projectile.deplacement();
				setXP();
				setYP();
			}
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/fireball_1.png"));
				graphics.drawImage(img, xp, yp, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			collision = this.mobile.Collision(xp,yp);
			if(collision == 1){
				this.mobile.ResetCompt();
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
			//this.monstre.patternLineaire(xm);
			/*this.monstre.Pattern(x,y, correction);
			setXM();
			setYM();
			detection = this.viewFrame.getModel().verifPos(xm,ym);*/
			//while(detection == 1 || detection == 2){
			  /* if(detection != 0){
					this.monstre.ResetMove();
					setXM();
					setYM();
					correction = 1;
					this.monstre.Pattern(x,y, correction);
					setXM();
					setYM();
					detection = this.viewFrame.getModel().verifPos(xm,ym);
					if(detection != 0){
						this.monstre.ResetMove();
						setXM();
						setYM();
						correction = 2;
						this.monstre.Pattern(x,y, correction);
						setXM();
						setYM();
						detection = this.viewFrame.getModel().verifPos(xm,ym);
						if(detection != 0){
							this.monstre.ResetMove();
							setXM();
							setYM();
							correction = 3;
							this.monstre.Pattern(x,y, correction);
							setXM();
							setYM();
							detection = this.viewFrame.getModel().verifPos(xm,ym);
							
						}

						
					}
				}
			   
			/*else if(detection == 2 && (x != xm || y != ym)){
					this.monstre.ResetMove();
					setXM();
					setYM();
					correction = 1;
					this.monstre.Pattern(x,y, correction);
					setXM();
					setYM();
					detection = this.viewFrame.getModel().verifPos(xm,ym);
				}*/
				/*correction = 0;*/
			//}
			
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
				this.mobile.ResetCompt();
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
	public void setCrystal(){
		this.crystal = this.viewFrame.getModel().getCrystal();
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
				else if(affiche.equals("M")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/case.jpg"));
						graphics.drawImage(img, j*32, i*32, this);
						xm = j*32;
						ym = i*32;
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("H")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/case.jpg"));
						graphics.drawImage(img, j*32, i*32, this);
						x = j*32;
						y = i*32;
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
					if(CrystalRecup==1){
						try {
							Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/gate_open.png"));
							graphics.drawImage(img, j*32, i*32, this);
							xd=j*32;
							yd=i*32;
						} catch (final IOException e) {
							e.printStackTrace();
						}
					}
						else{
							try {
									Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/gate_closed.png"));
									graphics.drawImage(img, j*32, i*32, this);
									xd=j*32;
									yd=i*32;
								} catch (final IOException e) {
									e.printStackTrace();
								}
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
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/case.jpg"));
						graphics.drawImage(img, j*32, i*32, this);
						xc=j*32;
						yc=i*32;
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				
				k++;
			}
		}
	}
}
