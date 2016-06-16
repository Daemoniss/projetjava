package view;

import static org.junit.Assert.*;
import model.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IViewFrame;
import contract.IView;
import contract.IModel;
import contract.IController;
import controller.Controller;

public class ViewFrameTest {

	public int x;
	public int y;
	private IView View;
	private IModel model;
	private IController controller;
	private IViewFrame viewframe;
	private IController controller2;
	
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.View = new View(model);
		this.controller = new Controller(View,model);
		this.viewframe = new ViewFrame(model);
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public final void testViewFrameIModel() {
		fail("Not yet implemented"); // TODO
	}*/

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
	public final void testGetController() {
		
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testSetController() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetModel() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testSetModel() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testbuildViewFrame() {
		fail("Not yet implemented"); // TODO
	}

/*	@Test
	public final void testPrintMessage() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testKeyPressed() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetXEtGetX() {
		this.viewframe.setX(20);
		this.x = this.viewframe.getX();
		if(this.x != 20){
			fail("Not yet implemented"); // TODO
		}
		
	}

	@Test
	public final void testSetYEtGetY() {
		this.viewframe.setY(20);
		this.y = this.viewframe.getY();
		if(this.y != 20){
			fail("Not yet implemented"); // TODO
		}
	}

}
