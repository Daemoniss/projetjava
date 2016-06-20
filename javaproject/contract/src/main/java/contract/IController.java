package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	int dire = 0;

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(direction direction);

	public void messageMort(int score);

	public void messageEnd(int i, int j);
}
