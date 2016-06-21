package Mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IProjectile;

public class projectileTest {
	int dir = 1;
	IProjectile projectile;
	@Before
	public void setUp() throws Exception {
		projectile = new projectile(0,32);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testProjectile() {
		if(projectile == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testChangeDirection() {
		this.projectile.setDirection(dir);
		this.projectile.changeDirection();
		if(this.projectile.getX() != 0 || this.projectile.getY() != 0){
			fail("Not yet implemented"); // TODO
		}
		
	}

}
