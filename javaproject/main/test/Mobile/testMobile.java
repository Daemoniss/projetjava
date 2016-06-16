package Mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Model;
import view.View;
import contract.IMobile;
import contract.IViewFrame;
import contract.IView;
import contract.IModel;

public class testMobile {

	private IView View;
	private IModel model;
	private IMobile mobile;
	public int x;
	public int y;
	
	
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.View = new View(model);
		this.mobile = this.model.getHero();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void TestMobile() {
		if(this.mobile == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetXEtGetX() {
		this.mobile.setX(20);
		this.x = this.mobile.GetX();
		if(this.x != 20){
			fail("Not yet implemented"); // TODO
		}
		
	}

	@Test
	public final void testSetYEtGetY() {
		this.mobile.setY(20);
		this.y = this.mobile.GetY();
		if(this.y != 20){
			fail("Not yet implemented"); // TODO
		}
	}

	/*@Test
	public final void testSetViewPanel() {
		
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testSetDirectionEtDeplcement() {
		this.mobile.setDirection(1);
		if(this.mobile.coordonney != 10){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(2);
		if(this.mobile.coordonney != 20){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(3);
		if(this.mobile.coordonnex != 10){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(4);
		if(this.mobile.coordonnex != 20){
			fail("Not yet implemented"); // TODO
		}
		
	}
}
