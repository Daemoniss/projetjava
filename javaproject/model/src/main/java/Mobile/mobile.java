package Mobile;

import contract.IViewFrame;

public class mobile{
	public int coordonnex;
	public int coordonney;
	public int dir;
	private IViewFrame View;
	
	public mobile(int x,int y){
		setX(x);
		setY(y);
	}
	public void setX(int x){
		this.coordonnex = x;
	}
	public void setY(int y){
		this.coordonney = y;
	}
	public int getX(){
		return coordonnex;
	}
	public int getY(){
		return coordonney;
	}
	public void setViewPanel(IViewFrame View){
		this.View = View;
	}
	public void setDirection(int direction){
		this.dir = direction;
		deplacement(dir);
	}
	public void deplacement(int direction){
		switch(direction){
		case 1 :
			coordonney -= 10;
			this.View.setY(coordonney);
			break;
		case 2 : 
			coordonney += 10;
			this.View.setY(coordonney);
			break;
		case 3 :
			coordonnex -= 10;
			this.View.setX(coordonnex);
			break;
		case 4 : 
			coordonnex += 10;
			this.View.setX(coordonnex);
			break;
		default:
			break;
		}
	}
	
}
