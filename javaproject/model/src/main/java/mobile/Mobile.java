package mobile;

import contract.IViewFrame;

public class Mobile{
	public int coordonneX;
	public int coordonneY;
	public int dir;
	private IViewFrame View;
	
	public Mobile(int x,int y){
		setX(x);
		setY(y);
	}
	public void setX(int x){
		this.coordonneX = x;
	}
	public void setY(int y){
		this.coordonneY = y;
	}
	public int getX(){
		return coordonneX;
	}
	public int getY(){
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
			this.View.setY(coordonneY);
			break;
		case 2 : 
			coordonneY += 10;
			this.View.setY(coordonneY);
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
