package controller;

import static org.junit.Assert.*;
import model.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.View;
import contract.IController;
import contract.IModel;
import contract.IView;



public class ControllerTest {
	private IController controller;

	@Before
	public void setUp() throws Exception {
		IModel model = new Model();
		IView view = new View(model);
		this.controller = new Controller(view , model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testController() {
		if(this.controller == null){
			fail("Not yet implemented"); // TODO
		}
		
	}

	@Test
	public final void testControl() {
		this.controller.control();
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testMessageEnd() {
		this.controller.messageEnd(500, 1);
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testMessageDeath() {
		this.controller.messageDeath(4000);
		//fail("Not yet implemented"); // TODO
	}

	/*@Test
	public final void testOrderPerform() {
		fail("Not yet implemented"); // TODO
	}*/

}
