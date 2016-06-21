package element;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IElement;

public class elementTest {
	IElement element;
	String map ="o------------------o|       4          || o----o o------oo || |     2    G  |  ||G| o--------o  | S|| | |        |  | o|| | |   1    | o| o|| | o---o o--o  | H|| |            B|  || o-------------oo ||       3  G       |o------------------o";
	@Before
	public void setUp() throws Exception {
		this.element = new element(map);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testElement() {
		if(element == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testVerifPositionAndSetCrystalRecup() {
		this.element.setCrystalRecup(1);
		int x = this.element.VerifPosition(5, 19);
		if(x !=  4){
			fail("Not yet implemented"); // TODO
		}
		
	}

}
