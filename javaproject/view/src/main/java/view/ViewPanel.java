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
import contract.IMonster;
import contract.IProjectile;
import contract.changeMap;


/**
 * The ViewPanel Class
 *
 * @author Luca
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
	private int ym = 32 * 7;
	private int xm1 = 32 * 8;
	private int ym1= 32 * 4;
	private int xm2 = 32 * 8;
	private int ym2 = 32 * 11;
	private int xm3 = 32 * 8;
	private int ym3 = 32 * 2;
	private IMobile hero;
	private IProjectile projectile;
	private IMonster monster;
	private IMonster monster1;
	private IMonster monster2;
	private IMonster monster3;
	private String map;
	private int xc;
	private int yc;
	private int xd;
	private int yd;
	private ICrystal crystal;
	public int CrystalRecup =0;
	public int map1 = 1;
	int score=0;

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
		this.viewFrame.getModel().initMonstre1( xm1, ym1);
		this.viewFrame.getModel().initMonstre2( xm2, ym2);
		this.viewFrame.getModel().initMonstre3( xm3, ym3);
		setMonster();
		setMonster1();
		setMonster2();
		setMonster3();
		setHero();
		this.viewFrame.setLife(this.hero.getLife());
		setCrystal();
	}


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

	/** the paintComponent
	 * 
	 *
	 * 
	 * @param collision will be equal to 1 if there is a collision 
	 * @param collision1 same than collision but for the 2nd monster
	 * @param collision2 collision for the 3rd monster
	 * @param collision3 collision for the 4th monster
	 * @param detection 
	 * 
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		
		int collision;
		int collision1;
		int collision2;
		int collision3;
		int detection;
		int correction = 0;
		int recup = 0;
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		DisplayMap(map, graphics, 0);
		if(hero != null){
			setX();
			setY();
			setProjectile();
			detection = this.viewFrame.getModel().verifPos(x,y);
			if(detection == 1){
				this.hero.ResetMove();
				setX();
				setY();
			}
			else if(detection == 2){
				this.viewFrame.getModel().changeMap(x,y);
				score = score + 75 ;
				this.viewFrame.setScore(score);
				setMap();
			}
			else if(detection == 3){
				this.hero.LoseLife();
				if(this.hero.getLife() != 0){
					this.hero.ResetCompt();
					collision =0;
					this.hero.DeathProjectile();
					this.hero = null;
					this.monster =null;
					graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
					DisplayMap(map, graphics, 1);
					setHero();
					this.hero.setX(x);
					this.hero.setY(y);
					setMonster();
					this.monster.setX(xm);
					this.monster.setY(ym);
					setMonster1();
					this.monster1.setX(xm1);
					this.monster1.setY(ym1);
					setMonster2();
					this.monster2.setX(xm2);
					this.monster2.setY(ym2);
					setMonster3();
					this.monster3.setX(xm3);
					this.monster3.setY(ym3);
					
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_1.png"));
						graphics.drawImage(img, xm, ym, this);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else{
					this.hero = null;
				this.viewFrame.getModel().deadHero();
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				DisplayMap(map, graphics, 0);
				graphics.drawString("dead", x, y);
				try {
					Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_1.png"));
					graphics.drawImage(img, xm, ym, this);
					Image img1 = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_2.png"));
					graphics.drawImage(img1, xm1, ym1, this);
					Image img2 = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_3.png"));
					graphics.drawImage(img2, xm2, ym2, this);
					Image img3 = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_4.png"));
					graphics.drawImage(img3, xm2, ym2, this);
				} catch (final IOException e) {
					e.printStackTrace();
				}
				}
				
			}
			else if(detection ==4){
				map1++;
				score = score + 200 ;
				this.viewFrame.setScore(score);
				if(map1 == 2){
					this.viewFrame.getModel().loadMessage(changeMap.L2);
					setMap();
					this.hero = null;
					this.monster = null;
					this.monster1 = null;
					this.monster2 = null;
					this.monster3 = null;
					DisplayMap(map, graphics, 1);
					setHero();
					this.hero.setX(x);
					this.hero.setY(y);
					setMonster();
					this.monster.setX(xm);
					this.monster.setY(ym);
					setMonster1();
					this.monster1.setX(xm1);
					this.monster1.setY(ym1);
					setMonster2();
					this.monster2.setX(xm2);
					this.monster2.setY(ym2);
					this.xm3 = 0;
					this.ym3  = -32;
				}
				else if(map1 == 3){
					this.viewFrame.getModel().loadMessage(changeMap.L3);
					setMap();
					this.hero = null;
					this.monster = null;
					this.monster1 = null;
					this.monster2 = null;
					this.monster3 = null;
					DisplayMap(map, graphics, 1);
					setHero();
					this.hero.setX(x);
					this.hero.setY(y);
					setMonster();
					this.monster.setX(xm);
					this.monster.setY(ym);
					setMonster1();
					this.monster1.setX(xm1);
					this.monster1.setY(ym1);
					setMonster2();
					this.monster2.setX(xm2);
					this.monster2.setY(ym2);
					setMonster3();
					this.monster3.setX(xm3);
					this.monster3.setY(ym3);
				}
				else if(map1 == 4){
					this.viewFrame.getModel().loadMessage(changeMap.L4);
					setMap();
					this.hero = null;
					this.monster = null;
					this.monster1 = null;
					this.monster2 = null;
					this.monster3 = null;
					DisplayMap(map, graphics, 1);
					setHero();
					this.hero.setX(x);
					this.hero.setY(y);
					setMonster();
					this.monster.setX(xm);
					this.monster.setY(ym);
					setMonster1();
					this.monster1.setX(xm1);
					this.monster1.setY(ym1);
					setMonster2();
					this.monster2.setX(xm2);
					this.monster2.setY(ym2);
					this.xm3 = 0;
					this.ym3 = -32;
				}
				else if(map1 == 5){
					this.viewFrame.getModel().loadMessage(changeMap.L5);
					setMap();
					this.hero = null;
					this.monster = null;
					this.monster1 = null;
					this.monster2 = null;
					this.monster3 = null;
					DisplayMap(map, graphics, 1);
					setHero();
					this.hero.setX(x);
					this.hero.setY(y);
					setMonster();
					this.monster.setX(xm);
					this.monster.setY(ym);
					setMonster1();
					this.monster1.setX(xm1);
					this.monster1.setY(ym1);
					setMonster2();
					this.monster2.setX(xm2);
					this.monster2.setY(ym2);
					setMonster3();
					this.monster3.setX(xm3);
					this.monster3.setY(ym3);
				}
				else if(map1 == 6)
				{
					this.viewFrame.getController().messageEnd(score* this.hero.getLife(), this.hero.getLife());
					this.viewFrame.EndWindows();
				}
				
				setCrystal();
				CrystalRecup = 0;
				
				
			}
			if(this.hero.getLife() != 0){
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
				score = score + 100 ;
				this.viewFrame.setScore(score);
				this.crystal = null;
				CrystalRecup=1;
				this.viewFrame.getModel().setCrystalRecup(CrystalRecup);
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
			this.projectile.move();
			setXP();
			setYP();
			detection = this.viewFrame.getModel().verifPos(xp,yp);
			if(detection != 0){
				this.projectile.ResetMove();
				setXP();
				setYP();
				this.projectile.changeDirection();
				this.projectile.move();
				setXP();
				setYP();
			}
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/fireball_1.png"));
				graphics.drawImage(img, xp, yp, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			collision = this.hero.Collision(xp,yp, x,y);
			if(collision == 1){
				this.hero.ResetCompt();
				collision =0;
				this.hero.DeathProjectile();
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				DisplayMap(map, graphics, 0);
				
			}
			collision = this.projectile.Collision(xp,yp, xm,ym);
			collision1 = this.projectile.Collision(xp,yp, xm1,ym1);
			collision2 = this.projectile.Collision(xp,yp, xm2,ym2);
			collision3 = this.projectile.Collision(xp,yp, xm3,ym3);
			if(collision == 1){
				score = score + 50 ;
				this.viewFrame.setScore(score);
				this.hero.ResetCompt();
				collision =0;
				this.hero.DeathProjectile();
				//this.viewFrame.getModel().deadMonstre();
				this.monster = null;
				this.ym = -32;
				this.xm = 0;
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				DisplayMap(map, graphics, 0);
				
			}
			else if(collision1 == 1){
				score = score + 50 ;
				this.viewFrame.setScore(score);
				this.hero.ResetCompt();
				collision1 =0;
				this.hero.DeathProjectile();
				//this.viewFrame.getModel().deadMonstre();
				this.monster1 = null;
				this.ym1 = -32;
				this.xm1 = 0;
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				DisplayMap(map, graphics, 0);
				
			}
			else if(collision2 == 1){
				score = score + 50 ;
				this.viewFrame.setScore(score);
				this.hero.ResetCompt();
				collision2 =0;
				this.hero.DeathProjectile();
				//this.viewFrame.getModel().deadMonstre();
				this.monster2 = null;
				this.ym2 = -32;
				this.xm2 = 0;
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				DisplayMap(map, graphics, 0);
				
			}
			else if(collision3 == 1){
				score = score + 50 ;
				this.viewFrame.setScore(score);
				this.hero.ResetCompt();
				collision3 =0;
				this.hero.DeathProjectile();
				//this.viewFrame.getModel().deadMonstre();
				this.monster3 = null;
				this.ym3 = -32;
				this.xm3 = 0;
				graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
				DisplayMap(map, graphics, 0);
				
			}
			
		}
		if(monster != null){
			setMonster();
			//this.monstre.patternLineaire(xm);
			/*this.monstre.Pattern(x,y, correction);
			setXM();
			setYM();
			detection = this.viewFrame.getModel().verifPos(xm,ym);
			/*while(detection == 1 || detection == 2){*/
			   /*if(detection != 0){
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
			   
			*/
				//correction = 0;
			
		}

			if(monster1 != null){
				setMonster1();
				/*this.monstre1.Pattern(x,y, correction);
				setXM1();
				setYM1();
				detection = this.viewFrame.getModel().verifPos(xm1,ym1);
				   /*if(detection != 0){
						this.monstre1.ResetMove();
						setXM1();
						setYM1();
						correction = 1;
						this.monstre1.Pattern(x,y, correction);
						setXM1();
						setYM1();
						detection = this.viewFrame.getModel().verifPos(xm1,ym1);
						if(detection != 0){
							this.monstre1.ResetMove();
							setXM1();
							setYM1();
							correction = 2;
							this.monstre1.Pattern(x,y, correction);
							setXM1();
							setYM1();
							detection = this.viewFrame.getModel().verifPos(xm1,ym1);
							if(detection != 0){
								this.monstre1.ResetMove();
								setXM1();
								setYM1();
								correction = 3;
								this.monstre1.Pattern(x,y, correction);
								setXM1();
								setYM1();
								detection = this.viewFrame.getModel().verifPos(xm1,ym1);
								
							}

							
						}
					}
				   
				*/
					//correction = 0;
				
			}
				
				if(monster2 != null){
					setMonster2();
					/*this.monstre2.Pattern(x,y, correction);
					setXM2();
					setYM2();
					detection = this.viewFrame.getModel().verifPos(xm2,ym2);
					   /*if(detection != 0){
							this.monstre2.ResetMove();
							setXM2();
							setYM2();
							correction = 1;
							this.monstre2.Pattern(x,y, correction);
							setXM2();
							setYM2();
							detection = this.viewFrame.getModel().verifPos(xm2,ym2);
							if(detection != 0){
								this.monstre2.ResetMove();
								setXM2();
								setYM2();
								correction = 2;
								this.monstre2.Pattern(x,y, correction);
								setXM2();
								setYM2();
								detection = this.viewFrame.getModel().verifPos(xm2,ym2);
								if(detection != 0){
									this.monstre2.ResetMove();
									setXM2();
									setYM2();
									correction = 3;
									this.monstre2.Pattern(x,y, correction);
									setXM2();
									setYM2();
									detection = this.viewFrame.getModel().verifPos(xm2,ym2);
									
								}

								
							}
						}
					   
					*/
						//correction = 0;
					
				}
				if(monster3 != null){
					setMonster3();
					/*this.monstre3.Pattern(x,y, correction);
					setXM3();
					setYM3();
					detection = this.viewFrame.getModel().verifPos(xm3,ym3);
					   /*if(detection != 0){
							this.monstre3.ResetMove();
							setXM3();
							setYM3();
							correction = 1;
							this.monstre3.Pattern(x,y, correction);
							setXM3();
							setYM3();
							detection = this.viewFrame.getModel().verifPos(xm3,ym3);
							if(detection != 0){
								this.monstre3.ResetMove();
								setXM3();
								setYM3();
								correction = 2;
								this.monstre3.Pattern(x,y, correction);
								setXM3();
								setYM3();
								detection = this.viewFrame.getModel().verifPos(xm3,ym3);
								if(detection != 0){
									this.monstre3.ResetMove();
									setXM3();
									setYM3();
									correction = 3;
									this.monstre3.Pattern(x,y, correction);
									setXM3();
									setYM3();
									detection = this.viewFrame.getModel().verifPos(xm3,ym3);
									
								}

								
							}
						}
					   
					*/
						//correction = 0;
				
				}	
				collision = 0;
				collision1 = 0;
				collision2 = 0;
				collision3 = 0;
				
				if(this.hero != null){
					collision = this.hero.Collision(x,y, xm,ym);
					collision1 = this.hero.Collision(x, y, xm1, ym1);
					collision2 = this.hero.Collision(x, y, xm2, ym2);
					collision3 = this.hero.Collision(x, y, xm3, ym3);
				}
					
					if(collision == 1){
						collision =0;
						this.hero.LoseLife();
						this.viewFrame.setLife(this.hero.getLife());
						if(this.hero.getLife() != 0){
							this.hero.ResetCompt();
							this.hero.DeathProjectile();
							this.hero = null;
							this.monster =null;
							graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
							DisplayMap(map, graphics, 1);
							setHero();
							this.hero.setX(x);
							this.hero.setY(y);
							setMonster();
							this.monster.setX(xm);
							this.monster.setY(ym);
						}
						else {
							this.hero = null;
						this.viewFrame.getModel().deadHero();
						graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
						DisplayMap(map, graphics, 0);
						graphics.drawString("dead", x, y);
						this.viewFrame.getController().messageDeath(score);
						this.viewFrame.EndWindows();
						}						
					}
					else if(collision1 == 1){
						collision1 =0;
						this.hero.LoseLife();
						this.viewFrame.setLife(this.hero.getLife());
						if(this.hero.getLife() != 0){
							this.hero.ResetCompt();
							this.hero.DeathProjectile();
							this.hero = null;
							this.monster =null;
							graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
							DisplayMap(map, graphics, 1);
							setHero();
							this.hero.setX(x);
							this.hero.setY(y);
							setMonster();
							this.monster.setX(xm);
							this.monster.setY(ym);
						}
						else {
							this.hero = null;
						this.viewFrame.getModel().deadHero();
						graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
						DisplayMap(map, graphics, 0);
						graphics.drawString("dead", x, y);
						this.viewFrame.getController().messageDeath(score);
						this.viewFrame.EndWindows();
						}
					}
					else if(collision2 == 1){
						collision2 =0;
						this.hero.LoseLife();
						this.viewFrame.setLife(this.hero.getLife());
						if(this.hero.getLife() != 0){
							this.hero.ResetCompt();
							this.hero.DeathProjectile();
							this.hero = null;
							this.monster =null;
							graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
							DisplayMap(map, graphics, 1);
							setHero();
							this.hero.setX(x);
							this.hero.setY(y);
							setMonster();
							this.monster.setX(xm);
							this.monster.setY(ym);
						}
						else {
							this.hero = null;
						this.viewFrame.getModel().deadHero();
						graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
						DisplayMap(map, graphics, 0);
						graphics.drawString("dead", x, y);
						this.viewFrame.getController().messageDeath(score);
						this.viewFrame.EndWindows();
						}
					}
					else if(collision3 == 1){
						collision3 =0;
						this.hero.LoseLife();
						this.viewFrame.setLife(this.hero.getLife());
						if(this.hero.getLife() != 0){
							this.hero.ResetCompt();
							this.hero.DeathProjectile();
							this.hero = null;
							this.monster =null;
							graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
							DisplayMap(map, graphics, 1);
							setHero();
							this.hero.setX(x);
							this.hero.setY(y);
							setMonster();
							this.monster.setX(xm);
							this.monster.setY(ym);
						}
						else {
							this.hero = null;
						this.viewFrame.getModel().deadHero();
						graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
						DisplayMap(map, graphics, 0);
						graphics.drawString("dead", x, y);
						this.viewFrame.getController().messageDeath(score);
						this.viewFrame.EndWindows();
						}
					}
				
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/lorann_r.png"));
				graphics.drawImage(img, x, y, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_1.png"));
				graphics.drawImage(img, xm, ym, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_2.png"));
				graphics.drawImage(img, xm1, ym1, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}	
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_3.png"));
				graphics.drawImage(img, xm2, ym2, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}	
			try {
				Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/monster_4.png"));
				graphics.drawImage(img, xm3, ym3, this);
			} catch (final IOException e) {
				e.printStackTrace();
			}	
			
		
	}
	public void setCrystal(){
		this.crystal = this.viewFrame.getModel().getCrystal();
	}
	public void setX(){
		this.x = this.hero.getX();
	}
	public void setY(){
		this.y = this.hero.getY();
	}
	public void setHero(){
		this.hero = this.viewFrame.getModel().getHero();
	}
	public void setProjectile(){
		this.projectile = this.hero.getProjectile();
	}
	public void setXP(){
		this.xp = this.projectile.getX();
	}
	public void setYP(){
		this.yp = this.projectile.getY();
	}
	public void setMonster(){
		this.monster = this.viewFrame.getModel().getMonstre();
	}
	public void setXM(){
		this.xm = this.monster.getX();
	}
	public void setYM(){
		this.ym = this.monster.getY();
	}
	public void setMap(){
		this.map = this.viewFrame.getModel().getMap();
	}
	public void setMonster1(){
		this.monster1 = this.viewFrame.getModel().getMonstre1();
	}
	public void setXM1(){
		this.xm1 = this.monster1.getX();
	}
	public void setYM1(){
		this.ym1 = this.monster1.getY();
	}
	public void setMonster2(){
		this.monster2 = this.viewFrame.getModel().getMonstre2();
	}
	public void setXM2(){
		this.xm2 = this.monster2.getX();
	}
	public void setYM2(){
		this.ym2 = this.monster2.getY();
	}
	public void setMonster3(){
		this.monster3 = this.viewFrame.getModel().getMonstre3();
	}
	public void setXM3(){
		this.xm3 = this.monster3.getX();
	}
	public void setYM3(){
		this.ym3 = this.monster3.getY();
	}

	public void DisplayMap(String map, final Graphics graphics, int change){
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
				else if(affiche.equals("1")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/case.jpg"));
						graphics.drawImage(img, j*32, i*32, this);
						if(this.monster == null && change == 1){
							xm = j*32;
							ym = i*32;
						}
						
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("2")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/case.jpg"));
						graphics.drawImage(img, j*32, i*32, this);
						if(this.monster == null && change == 1){
							xm1 = j*32;
							ym1 = i*32;
						}
						
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("3")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/case.jpg"));
						graphics.drawImage(img, j*32, i*32, this);
						if(this.monster == null && change == 1){
							xm2 = j*32;
							ym2 = i*32;
						}
						
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("4")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/case.jpg"));
						graphics.drawImage(img, j*32, i*32, this);
						if(this.monster == null && change == 1){
							xm3 = j*32;
							ym3 = i*32;
						}
						
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				else if(affiche.equals("H")){
					try {
						Image img = ImageIO.read(new File("C:/Users/toto/git/projetjava/javaproject/sprite/case.jpg"));
						graphics.drawImage(img, j*32, i*32, this);
						if(this.hero == null && change == 1){
							x = j*32;
							y = i*32;
						}
						
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
				
				k++;
			}
		}
	}
}
