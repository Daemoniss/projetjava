package Mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IMobile;
import contract.IProjectile;

public class heroTest {
	IMobile hero;
	@Before
	public void setUp() throws Exception {
		this.hero = new hero(32,64);
		this.hero.setDirection(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testHero() {
		if (hero == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testshoot() {
		this.hero.shoot();
		IProjectile shoot = this.hero.getProjectile();
		if (shoot == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testDeathProjectileAndGetProjectile() {
		this.hero.shoot();
		this.hero.DeathProjectile();
		if(this.hero.getProjectile() != null){
			fail("Not yet implemented"); // TODO
		}
	}


	@Test
	public final void testResetCompt() {
		this.hero.shoot();
		this.hero.ResetCompt();
		this.hero.setDirection(2);
		this.hero.shoot();
		IProjectile shoot = this.hero.getProjectile();
		if( shoot.getY() != 64){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testLoseLifeAndGetLife() {
		this.hero.LoseLife();
		if(this.hero.getLife() != 2){
			fail("Not yet implemented"); // TODO
		}
	}

}
