package Mobile;

import contract.IMobile;
import contract.IProjectile;
/*import contract.IViewFrame;*/


public class Hero extends Mobile implements IMobile{
	
	private IProjectile tiree;

	public Hero(int x, int y) {
		super(x, y);
		
	}
	
	public void tire(){
		final Projectile tire = new Projectile(this.coordonnex, this.coordonney);
		this.tiree = tire;
		this.tiree.setDire(dir);
		
	}
	
	public void mortProjectile(){
		this.tiree = null;
	}
	public IProjectile getProjectile(){
		return tiree;
	}

}