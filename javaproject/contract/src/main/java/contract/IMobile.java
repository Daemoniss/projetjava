package contract;

public interface IMobile {
	
	void setDirection(int dire);

	/*void setViewPanel(IViewFrame viewFrame);*/

	void setX(int i);

	void setY(int i);

	void tire();

	int getX();

	int getY();
	
	IProjectile getProjectile();
	
}
