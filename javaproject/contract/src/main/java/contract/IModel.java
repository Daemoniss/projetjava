package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	/*String getMessage();*/

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	/*void loadMessage(String key);*/

	

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	IMobile getHero();

	void refresh();

	IMonster getMonster();

	void deadHero();

	void deadMonster();

	String getMap();

	int verifPos(int x, int y);

	void setCrystalRecup(int crystalRecup);

	ICrystal getCrystal();

	void loadMessage(changeMap l1);

	void initHero(int x, int y);

	void initMonster(int xm, int ym);

	void changeMap( int x, int y);

	void initMonster1(int xm1, int ym1);

	void initMonster2(int xm2, int ym2);

	void initMonster3(int xm3, int ym3);

	IMonster getMonster1();

	IMonster getMonster2();

	IMonster getMonster3();
}
