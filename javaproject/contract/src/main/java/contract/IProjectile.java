package contract;

public interface IProjectile {

	void setDirection(int dir);

	int getX();

	int getY();

	void deplacement();

	void changeDirection();

	void setDire(int dir);

	void ResetMove();

}
