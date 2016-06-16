package controller;

import static org.junit.Assert.*;
import model.Model;
import view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.direction;
import contract.IMobile;

public class ControllerTest {
	
	private IView	view;

	private IModel	model;
	private IController controller;
	
	private IMobile mobile;

	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.view = new View(model);
		this.controller = new Controller(view,model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testController() {
		if(controller == null){
			fail("Not yet implemented"); // TODO
		}
		
	}

	/*@Test
	public final void testControl() {
		fail("Not yet implemented"); // TODO
	}*/
	
	/*@Test
	public final void testSetView() {
		
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testSetModel() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testSetMobile() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testOrderPerform() {
		this.controller.orderPerform(direction.Haut);
		if(this.controller.dire != 1){
			fail("Not yet implemented"); // TODO
		}
		this.controller.orderPerform(direction.Bas);
		if(this.controller.dire != 2){
			fail("Not yet implemented"); // TODO
		}
		this.controller.orderPerform(direction.Gauche);
		if(this.controller.dire != 3){
			fail("Not yet implemented"); // TODO
		}
		this.controller.orderPerform(direction.Droite);
		if(this.controller.dire != 4){
			fail("Not yet implemented"); // TODO
		}
		
		
	}

}
