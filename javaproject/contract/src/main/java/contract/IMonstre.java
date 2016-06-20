package contract;

public interface IMonstre {

	int getX();

	int getY();

	int Collision(int xp, int yp, int xm, int ym);

	void deplacement();

	void Pattern(int x, int y, int correction);

	void ResetMove();

	void setX(int xm);

	void setY(int ym);

}
