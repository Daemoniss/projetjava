package Mobile;

import contract.IViewFrame;

public class mobile{
	public int coordonnex;
	public int coordonney;
	public int dir;
	private IViewFrame View;
	
	public mobile(int x,int y){
		setx(x);
		sety(y);
	}
	public void setx(int x){
		this.coordonnex = x;
	}
	public void sety(int y){
		this.coordonney = y;
	}
	public int getx(){
		return coordonnex;
	}
	public int gety(){
		return coordonney;
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
			coordonney -= 10;
			this.View.sety(coordonney);
			break;
		case 2 : 
			coordonney += 10;
			this.View.sety(coordonney);
			break;
		case 3 :
			coordonnex -= 10;
			this.View.setx(coordonnex);
			break;
		case 4 : 
			coordonnex += 10;
			this.View.setx(coordonnex);
			break;
		default:
			break;
		}
	}
	
}
