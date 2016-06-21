package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

	@Test
	public final void testRefresh() {
		fail("Not yet implemented"); // TODO
	}

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
	public final void testGetCrystal() {
		this.model.initCrystal();
		if(this.model.getCrystal() == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testInitCrystal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetCrystalRecup() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testLoadMessage() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInitHero() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetHero() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInitMonstre() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetMonstre() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInitMonstre1() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetMonstre1() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInitMonstre2() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetMonstre2() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInitMonstre3() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetMonstre3() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDeadHero() {
		fail("Not yet implemented"); // TODO
	}

	/*@Test
	public final void testDeadMonstre() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testGetObservable() {
		fail("Not yet implemented"); // TODO
	}

}
