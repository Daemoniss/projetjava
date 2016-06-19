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

	int Collision(int x, int y);

	void mortProjectile();

	void deplacement();

	void ResetMove();
	
}
