package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IMobile;
import contract.IModel;

import java.util.Observable;

public class ModelTest {
	
	public IMobile mobile;
	public IModel model;

	@Before
	public void setUp() throws Exception {
		final Model Model = new Model();
		this.model = Model;
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testModel() {
		if(this.model == null){
			fail("Not yet implemented"); // TODO
		}
		
	}

	/*@Test
	public final void testGetMessage() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testLoadMessage() {
		fail("Not yet implemented"); // TODO
	}*/

	@Test
	public final void testGetHeroEtInitHero() {
		this.mobile = this.model.getHero();
		if(mobile == null){
			fail("Not yet implemented"); // TODO	
		}
	}

	@Test
	public final void testGetObservable() {
		Observable observation = this.model.getObservable();
		if(observation == null){
			fail("Not yet implemented"); // TODO
		}
	}

}
