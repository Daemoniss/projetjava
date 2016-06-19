package contract;

public interface IMonstre {

	int getX();

	int getY();

	int Collision(int xp, int yp);

	void deplacement();

	void Pattern(int x, int y);

}
