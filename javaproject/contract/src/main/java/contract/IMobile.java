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

	int Collision(int x, int y, int x2, int y2);

	void mortProjectile();

	void deplacement();

	void ResetMove();

	void ResetCompt();

	void perteVie();

	int getVie();
	
}
