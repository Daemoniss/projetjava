package Mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IMobile;

public class mobileTest {
	
	private IMobile mobile;
	public int x = 32;
	public int y = 32;

	@Before
	public void setUp() throws Exception {
		this.mobile = new hero(x, y);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMobile() {
		if(this.mobile == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testSetXEtGetX() {
		this.mobile.setX(20);
		this.x = this.mobile.getX();
		assertEquals(20, this.x); // TODO
	}

	@Test
	public final void testSetYEtGetY() {
		this.mobile.setY(20);
		this.y = this.mobile.getY();
		assertEquals(20, this.y); // TODO
	}

	@Test
	public final void testSetDirectionEtDeplacement() {
		this.mobile.setDirection(1);
		if(0 != this.mobile.getY()){
			fail("Not yet implemented");
		}
		
		this.mobile.setDirection(2);
		if(64 != this.mobile.getY()){
			fail("Not yet implemented");// TODO
		}
		
		this.mobile.setDirection(3);
		if(0 != this.mobile.getX()){
			fail("Not yet implemented");
		}
		
		this.mobile.setDirection(4);
		if( 64 != this.mobile.getX()){
			fail("Not yet implemented");
		}
		
		this.mobile.setDirection(5);
		if(64 != this.mobile.getY() || 64 != this.mobile.getX()){
			fail("Not yet implemented");
		}
		
		this.mobile.setDirection(6);
		if(0 != this.mobile.getY() || 64 != this.mobile.getX()){
			fail("Not yet implemented");
		}
		
		this.mobile.setDirection(7);
		if(64 != this.mobile.getY() || 0 != this.mobile.getX()){
			fail("Not yet implemented");
		}
		
		this.mobile.setDirection(8);
		if(0 != this.mobile.getY() || 0 != this.mobile.getX()){
			fail("Not yet implemented");
		}
		
		this.mobile.setDirection(9);
		if(32 != this.mobile.getY() || 32 != this.mobile.getX()){
			fail("Not yet implemented");
		}
	}

	@Test
	public final void testCollision() {
		int x = 32;
		int y = 32;
		int z = this.mobile.Collision(x, y, this.x, this.y);
		if(z != 1){
			fail("Not yet implemented");// TODO
		}
		 
	}

	@Test
	public final void testResetMove() {
		this.mobile.setDirection(1);
		this.mobile.ResetMove();
		if(this.mobile.getX() != 32 || this.mobile.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(2);
		this.mobile.ResetMove();
		if(this.mobile.getX() != 32 || this.mobile.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(3);
		this.mobile.ResetMove();
		if(this.mobile.getX() != 32 || this.mobile.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(4);
		this.mobile.ResetMove();
		if(this.mobile.getX() != 32 || this.mobile.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(5);
		this.mobile.ResetMove();
		if(this.mobile.getX() != 32 || this.mobile.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(6);
		this.mobile.ResetMove();
		if(this.mobile.getX() != 32 || this.mobile.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(7);
		this.mobile.ResetMove();
		if(this.mobile.getX() != 32 || this.mobile.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(8);
		this.mobile.ResetMove();
		if(this.mobile.getX() != 32 || this.mobile.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
		this.mobile.setDirection(9);
		this.mobile.ResetMove();
		if(this.mobile.getX() != 32 || this.mobile.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
		
	}

}
