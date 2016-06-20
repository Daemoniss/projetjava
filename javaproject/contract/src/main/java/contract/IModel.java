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

	IMonstre getMonstre();

	void deadHero();

	void deadMonstre();

	String getMap();

	int verifPos(int x, int y);

	void setCrystalRecup(int crystalRecup);

	ICrystal getCrystal();

	void loadMessage(changeMap l1);

	void initHero(int x, int y);

	void initMonstre(int xm, int ym);

	void changeMap( int x, int y);
}
