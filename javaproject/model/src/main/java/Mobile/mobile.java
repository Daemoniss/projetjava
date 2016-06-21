package Mobile;


//import contract.IViewFrame;

public class mobile{
	public int coordinateX;
	public int coordinateY;
	public int dir;
	//private IViewFrame View;
	
	public mobile(int x,int y){
		setX(x);
		setY(y);
	}
	public void setX(int x){
		this.coordinateX = x;
	}
	public void setY(int y){
		this.coordinateY = y;
	}
	public int getX(){
		return coordinateX;
	}
	public int getY(){
		return coordinateY;
	}
	/*public void setViewPanel(IViewFrame View){
		this.View = View;
	}*/
	public void setDirection(int direction){
		this.dir = direction;
		move();
	}
	public void move(){
		switch(dir){
		case 1 :
			coordinateY -= 32;
			//this.View.setY(coordonney);
			break;
		case 2 : 
			coordinateY += 32;
			///this.View.setY(coordonney);
			break;
		case 3 :
			coordinateX -= 32;
			//this.View.setX(coordonnex);
			break;
		case 4 : 
			coordinateX += 32;
			//this.View.setX(coordonnex);
			break;
		case 5 :
			coordinateY += 32;
			coordinateX += 32;
			/*this.View.setX(coordonnex);
			this.View.setY(coordonney);*/
			break;
		case 6 :
			coordinateY -= 32;
			coordinateX += 32;
			/*this.View.setX(coordonnex);
			this.View.setY(coordonney);*/
			break;
		case 7 :
			coordinateY += 32;
			coordinateX -= 32;
			/*this.View.setX(coordonnex);
			this.View.setY(coordonney);*/
			break;
		case 8 :
			coordinateY -= 32;
			coordinateX -= 32;
			/*this.View.setX(coordonnex);
			this.View.setY(coordonney);*/
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
				coordinateY += 32;
				//this.View.setY(coordonney);
				break;
			case 2 : 
				coordinateY -= 32;
				///this.View.setY(coordonney);
				break;
			case 3 :
				coordinateX += 32;
				//this.View.setX(coordonnex);
				break;
			case 4 : 
				coordinateX -= 32;
				//this.View.setX(coordonnex);
				break;
			case 5 :
				coordinateY -= 32;
				coordinateX -= 32;
				/*this.View.setX(coordonnex);
				this.View.setY(coordonney);*/
				break;
			case 6 :
				coordinateY += 32;
				coordinateX -= 32;
				/*this.View.setX(coordonnex);
				this.View.setY(coordonney);*/
				break;
			case 7 :
				coordinateY -= 32;
				coordinateX += 32;
				/*this.View.setX(coordonnex);
				this.View.setY(coordonney);*/
				break;
			case 8 :
				coordinateY += 32;
				coordinateX += 32;
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
