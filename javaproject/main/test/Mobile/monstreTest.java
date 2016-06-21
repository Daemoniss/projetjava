package Mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IMonster;

public class monstreTest {
	private IMonster monster;
	@Before
	public void setUp() throws Exception {
		this.monster = new monster(32,32);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMonstre() {
		if(this.monster == null){
			fail("Not yet implemented"); // TODO
		}
	}

	@Test
	public final void testPattern() {
			this.monster.Pattern(0,0,0);
		if(this.monster.getX() != 0 || this.monster.getY() != 0){
			fail("Not yet implemented"); // TODO
		}
			this.monster.Pattern(32,0,0);
		if(this.monster.getX() != 32 || this.monster.getY() != 0){
			fail("Not yet implemented"); // TODO
		}
			this.monster.Pattern(0,32,0);
		if(this.monster.getX() != 0 || this.monster.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
			this.monster.Pattern(64,0,0);
		if(this.monster.getX() != 64 || this.monster.getY() != 0){
			fail("Not yet implemented"); // TODO
		}
			this.monster.Pattern(0,64,0);
		if(this.monster.getX() != 0 || this.monster.getY() != 64){
			fail("Not yet implemented"); // TODO
		}
			this.monster.Pattern(64,32,0);
		if(this.monster.getX() != 64 || this.monster.getY() != 32){
			fail("Not yet implemented"); // TODO
		}
			this.monster.Pattern(32,64,0);
		if(this.monster.getX() != 32 || this.monster.getY() != 64){
			fail("Not yet implemented"); // TODO
		}
			this.monster.Pattern(64,64,0);
		if(this.monster.getX() != 64 || this.monster.getY() != 64){
			fail("Not yet implemented"); // TODO
		}
		
	}

}
