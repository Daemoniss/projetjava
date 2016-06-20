package Mobile;

import contract.IMobile;
import contract.IProjectile;
/*import contract.IViewFrame;*/


public class hero extends mobile implements IMobile{
	int compt = 0;
	private IProjectile tiree;
	private int vie;

	public hero(int x, int y) {
		super(x, y);
		this.vie = 3;
		
	}
	
	public void tire(){
		if (compt == 0){
		final projectile tire = new projectile(coordonnex, coordonney);
		this.tiree = tire;
		this.tiree.setDire(dir);
		this.compt = 1;
		}
		else{
			
		}
		
	}
	
	public void mortProjectile(){
		this.tiree = null;
	}
	public IProjectile getProjectile(){
		return tiree;
	}
	public void ResetCompt(){
		this.compt = 0;
	}
	public void perteVie(){
		this.vie -= 1;
	}
	public int getVie(){
		return this.vie;
	}
	
}
