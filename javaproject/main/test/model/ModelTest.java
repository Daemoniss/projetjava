package model;

import static org.junit.Assert.*;

import java.util.Observable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.changeMap;

public class ModelTest {
	private Model model;
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testModel() {
		if(model == null){
			fail("Not yet implemented"); // TODO
		}
	}

	/*@Test
	public final void testRefresh() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testSetMapAndGetMap() {
		String map = "|   |-o";
		this.model.setMap(map);
		if(this.model.getMap() != "|   |-o"){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testChangeMap() {
		String map = "|   |-o";
		this.model.setMap(map);
		this.model.changeMap(0,1);
		if(this.model.getMap() != "|   |-o"){
			fail("Not yet implemented"); // TODO
		}
	}

	/*@Test
	public final void testInitElementMap() {
		fail("Not yet implemented"); // TODO
	}*/

	/*@Test
	public final void testVerifPos() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testGetCrystalAndInitCrystal() {
		this.model.initCrystal();
		if(this.model.getCrystal() == null){
			fail("Not yet implemented"); // TODO
		}
	}

	/*@Test
	public final void testSetCrystalRecup() {
		fail("Not yet implemented"); // TODO
	}
*/
	@Test
	public final void testLoadMessage() {
		this.model.loadMessage(changeMap.L1);
		if(this.model.getMap() == null){
			fail("Not yet implemented"); // TODO
		}
		
	}

	@Test
	public final void testInitHeroAndGetHero() {
		this.model.initHero(0, 32);
		if(this.model.getHero() == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testInitMonstreAndGetMonster() {
		this.model.initMonster(0, 32);
		if(this.model.getMonster() == null){
			fail("Not yet implemented"); // TODO
		}
	}


	@Test
	public final void testInitMonster1AndGetMonster1() {
		this.model.initMonster1(0, 32);
		if(this.model.getMonster1() == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testInitMonster1AndGetMonster2() {
		this.model.initMonster2(0, 32);
		if(this.model.getMonster2() == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testInitMonster1AndGetMonster3() {
		this.model.initMonster3(0, 32);
		if(this.model.getMonster3() == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testDeadHero() {
		this.model.initMonster1(0, 32);
		this.model.deadHero();
		if(this.model.getMonster1() != null){
			fail("Not yet implemented"); // TODO
		}
	}

	/*@Test
	public final void testDeadMonstre() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testGetObservable() {
		Observable ob = this.model.getObservable();
		if(ob == null){
			fail("Not yet implemented"); // TODO
		}
	}

}
