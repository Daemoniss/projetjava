package Mobile;

import contract.IMonstre;

public class Monstre extends Mobile implements IMonstre{

	public Monstre(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void Pattern( int x, int y){
		int herox = x - coordonnex;
		int heroy = y - coordonney;
		System.out.println(herox + "  " + heroy);
		if(herox == 0 && coordonney < y){
			setDirection(2);
		}
		else if(herox == 0 && coordonney > y){
			setDirection(1);
		}
		else if(heroy == 0 && coordonnex > x){
			setDirection(3);
		}
		else if(heroy == 0 && coordonnex < x){
			setDirection(4);
		}
		else if(herox <= heroy && coordonney < y){
			setDirection(2);
		}
		else if(herox <= heroy && coordonney > y){
			setDirection(1);
		}
		else if(herox > heroy && coordonnex > x){
			setDirection(3);
		}
		else if(herox > heroy && coordonnex < x){
			setDirection(4);
		}
	}


}
