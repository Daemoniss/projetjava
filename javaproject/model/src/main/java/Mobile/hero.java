package Mobile;

import contract.IMobile;
import contract.IProjectile;
/*import contract.IViewFrame;*/


public class hero extends mobile implements IMobile{
	
	private IProjectile tiree;

	public hero(int x, int y) {
		super(x, y);
		
	}
	
	public void tire(){
		final projectile tire = new projectile(coordonnex, this.coordonney);
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
