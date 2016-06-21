package view;

import static org.junit.Assert.*;
import model.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IModel;
import contract.IView;

public class ViewTest {
	private IView view;
	@Before
	public void setUp() throws Exception {
		IModel model = new Model();
		this.view = new View(model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		if (view == null){
			fail("Not yet implemented"); // TODO
		}
	}

}
