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
	private ViewFrame viewframe;
	
	@Before
	public void setUp() throws Exception {
		IModel model = new Model();
		this.view = new View(model);
		this.controller = new Controller(view , model);
		this.viewframe = new ViewFrame(model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testViewFrameIModel() {
		if (this.viewframe == null){
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
		this.viewframe.setController(controller);
		if(this.viewframe.getController() ==  null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testGetModel() {
		if(this.viewframe.getModel() == null){
			fail("Not yet implemented"); // TODO
		}
	}

	/*@Test
	public final void testPrintMessage() {
		
		fail("Not yet implemented"); // TODO
	}*/

	/*@Test
	public final void testKeyTyped() {
		fail("Not yet implemented"); // TODO
	}*/

/*	@Test
	public final void testKeyPressed() {
		
		fail("Not yet implemented"); // TODO
	}*/

/*	@Test
	public final void testKeyReleased() {
		fail("Not yet implemented"); // TODO
	}*/

	/*@Test
	public final void testAfficherScore() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testSetScoreGetScore() {
		this.viewframe.setScore(400);
		if(this.viewframe.getScore(220) ==  0){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetLife() {
		this.viewframe.setLife(2);
		if(this.viewframe.getLife(3) == 0){
			fail("Not yet implemented"); // TODO
		}
	}
}
