package main;

import controller.Controller;
import Mobile.hero;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {
	
	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 */
	public static void main(final String[] args) {
		int x = 50;
		int y = 50;
		final hero hero = new hero(x , y);
		final Model model = new Model();
		final View view = new View(model, hero);
		final Controller controller = new Controller(view, model, hero);
		view.setController(controller);
		controller.control();
	}
}