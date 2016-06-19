package motionless;

public class motionLessElement{
	private int x;
	private int y;
	public String permeability;
	
	public motionLessElement(int x, int y, String permeability){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setPermeability(String permeability){
		this.permeability = permeability;
	}
}
