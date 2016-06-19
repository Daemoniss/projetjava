package motionLess;
import contract.permeability;

public class motionLessElement{
	private int x;
	private int y;
	public permeability permeability;
	
	public motionLessElement(int x, int y, permeability permeability){
		this.x = x;
		this.y = y;
		setPermeability(permeability);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setPermeability(permeability permeability){
		this.permeability = permeability;
	}
}
