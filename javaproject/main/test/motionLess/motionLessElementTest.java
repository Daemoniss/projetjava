package motionLess;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.permeability;

public class motionLessElementTest {
	private motionLessElement motionlesselement;
	@Before
	public void setUp() throws Exception {
		this.motionlesselement = new motionLessElement(32,32, permeability.Pass);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMotionLessElement() {
		if(this.motionlesselement == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testGetX() {
		if(this.motionlesselement.getX() != 32){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testGetY() {
		if(this.motionlesselement.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
	}

	/*@Test
	public final void testSetPermeability() {
		fail("Not yet implemented"); // TODO
	}*/

}
