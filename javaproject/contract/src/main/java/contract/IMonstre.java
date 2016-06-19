package contract;

public interface IMonstre {

	int getX();

	int getY();

	void patternCarre(int xm, int ym);

	int Collision(int xp, int yp);

	void deplacement();

}
