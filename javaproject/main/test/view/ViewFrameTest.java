package view;

import static org.junit.Assert.*;
import model.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.View;
import contract.IController;
import contract.IModel;
import contract.IView;
import controller.Controller;

public class ViewFrameTest {

	private IController controller;
	private IView view;
	@Before
	public void setUp() throws Exception {
		IModel model = new Model();
		this.view = new View(model);
		this.controller = new Controller(view , model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testViewFrameIModel() {
		if (this.view == null){
			fail("Not yet implemented"); // TODO
		}
		
	}

	/*@Test
	public final void testViewFrameIModelGraphicsConfiguration() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testViewFrameIModelString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testViewFrameIModelStringGraphicsConfiguration() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testGetControllerAndSetController() {
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetModel() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testPrintMessage() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testKeyTyped() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testKeyPressed() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testKeyReleased() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAfficherScore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetScore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetScore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetVie() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetVie() {
		fail("Not yet implemented"); // TODO
	}

}
