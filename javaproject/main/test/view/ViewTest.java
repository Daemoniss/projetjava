package view;

import static org.junit.Assert.*;
import model.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.direction;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.IMobile;

public class ViewTest {
	
	private ViewFrame viewFrame;
	private IModel model;
	private IMobile mobile;
	private IView View;
	private direction dir;


	@Before
	public void setUp() throws Exception {
		IModel model = new Model();
		this.View = new View(model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testViewEtGetMobile() {
		if(View == null){
			fail("Not yet implemented"); // TODO
		}
	}

	/*@Test
	public final void testKeyCodeToControllerOrder() {
		this.View.KeyCodeToControllerOrder(90); 
		this.View.KeyCodeToControllerOrder(83); 
		this.View.KeyCodeToControllerOrder(68); 
		this.View.KeyCodeToControllerOrder(81); 
		fail("Not yet implemented"); // TODO
	}*/

	/*@Test
	public final void testPrintMessage() {
		fail("Not yet implemented"); // TODO
	}*/

	/*@Test
	public final void testRun() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetController() {
		fail("Not yet implemented"); // TODO
	}*/

	/*@Test
	public final void testGetMobile() {
		fail("Not yet implemented"); // TODO
	}*/

}
