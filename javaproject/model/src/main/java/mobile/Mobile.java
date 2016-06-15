package mobile;

import contract.IViewFrame;

public class Mobile{
	public int coordonneX;
	public int coordonneY;
	public int dir;
	private IViewFrame View;
	
	public Mobile(int x,int y){
		setx(x);
		sety(y);
	}
	public void setx(int x){
		this.coordonneX = x;
	}
	public void sety(int y){
		this.coordonneY = y;
	}
	public int getx(){
		return coordonneX;
	}
	public int gety(){
		return coordonneY;
	}
	public void setViewPanel(IViewFrame View){
		this.View = View;
	}
	public void setdirection(int direction){
		this.dir = direction;
		deplacement(dir);
	}
	public void deplacement(int direction){
		switch(direction){
		case 1 :
			coordonneY -= 10;
			this.View.setX(coordonneY);
			break;
		case 2 : 
			coordonneY += 10;
			this.View.setX(coordonneY);
			break;
		case 3 :
			coordonneX -= 10;
			this.View.setX(coordonneX);
			break;
		case 4 : 
			coordonneX += 10;
			this.View.setX(coordonneX);
			break;
		default:
			break;
		}
	}
}
	
	/*
	package mobile;

	import java.awt.Point;


	import contract.IModel;
	import contract.ISprite;
	import contract.Permeability;
	import aedt.showboard.IPawn;

	public abstract class Mobile extends Element implements IPawn {
		private final Point position;

		public Mobile(final ISprite sprite) {
			super(sprite, Permeability.BLOCKING);
			this.position = new Point();
		}

		
		public int getX() {
			return this.position.x;
		}

		protected void setX(final int x) {
			if ((x >= 0) && (x < this.getModel().getWidth())) {
				this.position.x = x;
				this.getModel().setMobileHasChanged();
			}
		}

		
		public int getY() {
			return this.position.y;
		}

		protected void setY(final int y) {
			if ((y >= 0) && (y < this.getModel().getHeight())) {
				this.position.y = y;
				this.getModel().setMobileHasChanged();
			}
		}


		public Point getPosition() {
			return this.position;
		}

		public void setNettleWorld(final IModel model, final int x, final int y) {
			super.setModel(model);
			this.setX(x);
			this.setY(y);
		}

		private boolean isMovePossible(final int x, final int y) {
			return (this.getModel().getElements(x, y).getPermeability() != Permeability.BLOCKING);
		}

		public void moveUp() {
			if (this.isMovePossible(this.getX(), this.getY() - 1)) {
				this.setY(this.getY() - 1);
			}
		}

		public void moveLeft() {
			if (this.isMovePossible(this.getX() - 1, this.getY())) {
				this.setX(this.getX() - 1);
			}
		}

		public void moveDown() {
			if (this.isMovePossible(this.getX(), this.getY() + 1)) {
				this.setY(this.getY() + 1);
			}
		}

		public void moveRight() {
			if (this.isMovePossible(this.getX() + 1, this.getY())) {
				this.setX(this.getX() + 1);
			}
		}
		public void moveDownRight() {
				if (this.isMovePossible(this.getX() + 1, this.getY() +1 )) {
					this.setX(this.getX() + 1);
					this.setY(this.getY() + 1);
				}
		}
		public void moveDownLeft() {
			if (this.isMovePossible(this.getX() - 1, this.getY() +1 )) {
				this.setX(this.getX() - 1);
				this.setY(this.getY() + 1);
			}
		}
		public void moveUpRight() {
			if (this.isMovePossible(this.getX() + 1, this.getY() - 1 )) {
				this.setX(this.getX() + 1);
				this.setY(this.getY() - 1);
			}
	}
	public void moveUpLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY() - 1 )) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}
	}*/
	