package Mobile;

import contract.IMobile;
import contract.IProjectile;
/*import contract.IViewFrame;*/


public class hero extends mobile implements IMobile{
	int compt = 0;
	private IProjectile shoot;
	private int Life;

	public hero(int x, int y) {
		super(x, y);
		this.Life = 3;
		
	}
	
	public void shoot(){
		if (compt == 0){
		final projectile shoot = new projectile(coordinateX, coordinateY);
		this.shoot = shoot;
		this.shoot.setDire(dir);
		this.compt = 1;
		}
		else{
			
		}
		
	}
	
	public void DeathProjectile(){
		this.shoot = null;
	}
	public IProjectile getProjectile(){
		return shoot;
	}
	public void ResetCompt(){
		this.compt = 0;
	}
	public void LoseLife(){
		this.Life -= 1;
	}
	public int getLife(){
		return this.Life;
	}
	
}
