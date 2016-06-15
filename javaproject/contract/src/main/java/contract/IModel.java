package contract;

import java.util.Observable;



/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {
	String getMessage();
	void loadMessage(String key);
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	//void loadMap(String string);
	
	IMobile getHero();

}
