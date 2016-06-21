package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMapIntStringStringAndSetIdAndGetIdAndSetKeyAndGetKeyAndSetMapTxtAndGetMapText() {
		Map map = new Map(1, "L1", "  | - o");
		if(map.getId() ==  0){
			fail("Not yet implemented"); // TODO
		}
		if(map.getKey() ==  ""){
			fail("Not yet implemented"); // TODO
		}
		if(map.getMaptxt() ==  ""){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testMap() {
		Map map = new Map();
		if(map.getId() ==  0){
			fail("Not yet implemented"); // TODO
		}
		if(map.getKey() ==  ""){
			fail("Not yet implemented"); // TODO
		}
		if(map.getMaptxt() ==  ""){
			fail("Not yet implemented"); // TODO
		}
		fail("Not yet implemented"); // TODO
	}

}
