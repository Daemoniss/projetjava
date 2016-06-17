package Mobile;

import contract.IMonstre;

public class monstre extends mobile implements IMonstre{

	public monstre(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void patternCarre(int x, int y){
		if(x == 64 && y == 96){
			dir = 4;
		}
		else if(x == 160 && y == 96){
			dir = 2;
		}
		else if(x == 160 && y == 160){
			dir = 3;
		}
		else if(x == 64 && y == 160){
			dir =1;
		}
		deplacement();
	}
}
