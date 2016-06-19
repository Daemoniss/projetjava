package element;


import Mobile.Crystal;
import motionless.Bone;
import motionless.BoneHorizontal;
import motionless.BoneVertical;
import motionless.Case;
import motionless.GateClosed;
import motionless.Purse;
import contract.IBone;
import contract.IBoneHorizontal;
import contract.IBoneVertical;
import contract.ICase;
import contract.IElement;
import contract.IGateClosed;
import contract.IModel;
import contract.IPurse;
import contract.permeability;
import contract.IViewFrame;

public class element implements IElement{
	
	private char[][] map2 = new char[20][13];
	private IBone[] bone = new Bone[200];
	private ICase[] Case = new Case[200];
	private IPurse[] purse = new Purse[200];
	private IBoneHorizontal[] boneHorizontal = new BoneHorizontal[200];
	private IBoneVertical[] boneVertical = new BoneVertical[200];
	private IGateClosed GateClosed = null;
	int Crystalrecup;

	
	public element(String map){
		
		int k = 0;
		int b = 0;
		int c = 0;
		int p = 0;
		int bh = 0;
		int bv = 0;
		char[] map1 = map.toCharArray();
		for(int i = 1; i <=12; i++){
			for(int j = 0; j< 20; j++){
				if (map1[k] == 'o'){
					bone[b] = new Bone(j*32, i*32, permeability.Block);
					map2[j][i] = 'B';
				}
				else if (map1[k] == ' '){
					Case[c] = new Case(j*32, i*32, permeability.Pass);
					map2[j][i] = ' ';
				}
				else if (map1[k] == 'G'){
					purse[p] = new Purse(j*32, i*32, permeability.Pass);
					map2[j][i] = 'P';
				}
				else if (map1[k] == '-'){
					boneHorizontal[bh] = new BoneHorizontal(j*32, i*32, permeability.Block);
					map2[j][i] = 'H';
				}
				else if (map1[k] == '|'){
					boneVertical[bv] = new BoneVertical(j*32, i*32, permeability.Block);
					map2[j][i] = 'V';
				}
				else if (map1[k] == 'S'){
					GateClosed = new GateClosed(j*32, i*32, permeability.Kill);
					map2[j][i] = 'S';
				}
				
				k++;
			}
		}
	}
	public int CrystalRecup(){
		return 0;
		
	}
	public int VerifPosition(int y, int x){
		int j = x/32;
		int i = y/32;
		setCrystalRecup(Crystalrecup);
		if(map2[j][i] == ' '){
			return 0;
		}
		else if(map2[j][i] == 'V'){
			return 1;
		}
		else if(map2[j][i] == 'H'){
			return 1;
		}
		else if(map2[j][i] == 'P'){
			return 2;
		}
		else if(map2[j][i] == 'C'){
			return 2;
		}
		else if(map2[j][i] == 'S'){
		
			if(Crystalrecup==1){
				return 4;
			}
			else{
				return 3;
			}
		}
		else if(map2[j][i] == 'B'){
			return 1;
		}
		else if(map2[j][i] == 'O'){
			return 4;
		}
		else {
			return 0;
		}
		
		
	}
	public void setCrystalRecup(int Crystalrecup ){
		this.Crystalrecup = Crystalrecup;
		System.out.println(Crystalrecup);
		}
	
	
}
