package contract;

public interface IMobile {
	
	void setDirection(int dire);

	/*void setViewPanel(IViewFrame viewFrame);*/

	void setX(int i);

	void setY(int i);

	int getX();

	int getY();
	
	IProjectile getProjectile();

	int Collision(int x, int y, int x2, int y2);

	void DeathProjectile();

	void move();

	void ResetMove();

	void ResetCompt();

	void LoseLife();

	void shoot();

	int getLife();
	
}
