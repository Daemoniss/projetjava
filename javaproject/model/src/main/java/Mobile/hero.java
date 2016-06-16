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
		if(this.dir == 1){
			final projectile tire = new projectile(coordonnex, this.coordonney -10);
			this.tiree = tire;
		}
		if(this.dir == 2){
			final projectile tire = new projectile(coordonnex, this.coordonney +10);
			this.tiree = tire;
		}
		if(this.dir == 3){
			final projectile tire = new projectile(coordonnex -10, this.coordonney);
			this.tiree = tire;
		}
		if(this.dir == 4){
			final projectile tire = new projectile(coordonnex +10, this.coordonney);
			this.tiree = tire;
		}
		this.tiree.setDirection(dir);
	}
	
	public IProjectile getProjectile(){
		return tiree;
	}

}
