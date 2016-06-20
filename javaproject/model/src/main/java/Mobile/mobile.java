package Mobile;


//import contract.IViewFrame;

public class mobile{
	public int coordonnex;
	public int coordonney;
	public int dir;
	//private IViewFrame View;
	
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
	/*public void setViewPanel(IViewFrame View){
		this.View = View;
	}*/
	public void setDirection(int direction){
		this.dir = direction;
		deplacement();
	}
	public void deplacement(){
		switch(dir){
		case 1 :
			coordonney -= 32;
			//this.View.setY(coordonney);
			break;
		case 2 : 
			coordonney += 32;
			///this.View.setY(coordonney);
			break;
		case 3 :
			coordonnex -= 32;
			//this.View.setX(coordonnex);
			break;
		case 4 : 
			coordonnex += 32;
			//this.View.setX(coordonnex);
			break;
		case 5 :
			coordonney += 32;
			coordonnex += 32;
			/*this.View.setX(coordonnex);
			this.View.setY(coordonney);*/
			break;
		case 6 :
			coordonney -= 32;
			coordonnex += 32;
			/*this.View.setX(coordonnex);
			this.View.setY(coordonney);*/
			break;
		case 7 :
			coordonney += 32;
			coordonnex -= 32;
			/*this.View.setX(coordonnex);
			this.View.setY(coordonney);*/
			break;
		case 8 :
			coordonney -= 32;
			coordonnex -= 32;
			/*this.View.setX(coordonnex);
			this.View.setY(coordonney);*/
			break;
		case 0 : 
			/*this.View.setY(coordonney);
			this.View.setX(coordonnex);*/
			break;
		default:
			break;
		}
	}
		public int Collision(int x1, int y1, int x2, int y2){
				if(x1 == x2 && y1 == y2){
						return 1;
				}
				else {
					return 0;
				}
		}
		public void setDire(int dir){
			this.dir = dir;
		}
		public void ResetMove(){
			switch(dir){
			case 1 :
				coordonney += 32;
				//this.View.setY(coordonney);
				break;
			case 2 : 
				coordonney -= 32;
				///this.View.setY(coordonney);
				break;
			case 3 :
				coordonnex += 32;
				//this.View.setX(coordonnex);
				break;
			case 4 : 
				coordonnex -= 32;
				//this.View.setX(coordonnex);
				break;
			case 5 :
				coordonney -= 32;
				coordonnex -= 32;
				/*this.View.setX(coordonnex);
				this.View.setY(coordonney);*/
				break;
			case 6 :
				coordonney += 32;
				coordonnex -= 32;
				/*this.View.setX(coordonnex);
				this.View.setY(coordonney);*/
				break;
			case 7 :
				coordonney -= 32;
				coordonnex += 32;
				/*this.View.setX(coordonnex);
				this.View.setY(coordonney);*/
				break;
			case 8 :
				coordonney += 32;
				coordonnex += 32;
				/*this.View.setX(coordonnex);
				this.View.setY(coordonney);*/
				break;
			case 0 : 
				/*this.View.setY(coordonney);
				this.View.setX(coordonnex);*/
				break;
			default:
				break;
				
			}
		}
	
}
