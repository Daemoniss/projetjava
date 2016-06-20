package contract;

public interface IProjectile {

	void setDirection(int dir);

	int getX();

	int getY();

	void move();

	void changeDirection();

	void setDire(int dir);

	void ResetMove();

	int Collision(int xp, int yp, int xm, int ym);

}
