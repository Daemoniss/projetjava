package view;

import static org.junit.Assert.*;
import model.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IMonster;
import contract.IMobile;
import contract.IModel;
import contract.IProjectile;
import controller.Controller;

public class ViewPanelTest {

	private View view;
	private Controller controller;
	private ViewFrame viewframe;
	private ViewPanel viewpanel;
	private IMobile hero;
	private IMonster monster;
	private IProjectile projectile;
	
	@Before
	public void setUp() throws Exception {
		IModel model = new Model();
		this.view = new View(model);
		this.controller = new Controller(view , model);
		this.viewframe = new ViewFrame(model);
		this.viewpanel = new ViewPanel(viewframe);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testViewPanel() {
		if(this.viewpanel == null){
			fail("Not yet implemented"); // TODO
		}
	}

	/*@Test
	public final void testUpdateObservableObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testPaintComponentGraphics() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testSetCrystal() {
		if(this.viewframe.getModel().getCrystal() == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetXAndSetYAndSetHero() {
		this.hero = this.viewframe.getModel().getHero();
		int x = -32;
		x = this.hero.getX();
		int y = -32;
		y = this.hero.getY();
		if( x == -32 || y == -32){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetXPAndSetYPAndSetProjectile() {
		this.hero = this.viewframe.getModel().getHero();
		this.projectile = this.hero.getProjectile();
		int x = -32;
		x = this.projectile.getX();
		int y = -32;
		y = this.projectile.getY();
		if( x == -32 || y == -32){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetXMAndSetYMAndSetMonstre() {
		this.monster = this.viewframe.getModel().getMonster();
		int x = -32;
		x = this.monster.getX();
		int y = -32;
		y = this.monster.getY();
		if( x == -32 || y == -32){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetMap() {
		if(this.viewframe.getModel().getMap() == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetXM1AndSetYM1AndSetMonstre1() {
		this.monster = this.viewframe.getModel().getMonster1();
		int x = -32;
		x = this.monster.getX();
		int y = -32;
		y = this.monster.getY();
		if( x == -32 || y == -32){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetXM2AndSetYM2AndSetMonstre2() {
		this.monster = this.viewframe.getModel().getMonster2();
		int x = -32;
		x = this.monster.getX();
		int y = -32;
		y = this.monster.getY();
		if( x == -32 || y == -32){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetXM3AndSetYM3AndSetMonstre3() {
		this.monster = this.viewframe.getModel().getMonster3();
		int x = -32;
		x = this.monster.getX();
		int y = -32;
		y = this.monster.getY();
		if( x == -32 || y == -32){
			fail("Not yet implemented"); // TODO
		}
		
	}

	/*@Test
	public final void testAfficheMap() {
		fail("Not yet implemented"); // TODO
	}*/

}
