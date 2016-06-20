package Mobile;

import contract.IMonstre;

public class monstre extends mobile implements IMonstre{

	public monstre(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void Pattern( int x, int y, int correction){
		int herox = x - coordonnex;
		int heroy = y - coordonney;
		if(herox == 0 && coordonney < y && correction == 0){
			setDirection(2);
		}
		else if(herox == 0 && coordonney > y && correction == 0){
			setDirection(1);
		}
		else if(heroy == 0 && coordonnex > x && correction == 0){
			setDirection(3);
		}
		else if(heroy == 0 && coordonnex < x && correction == 0){
			setDirection(4);
		}
		else if(herox < 0 && heroy < 0 && correction == 0){
			setDirection(8);
		}
		else if(herox < 0 && heroy > 0 && correction == 0){
			setDirection(7);
		}
		else if(herox > 0 && heroy < 0 && correction == 0){
			setDirection(6);
		}
		else if(herox > 0 && heroy > 0 && correction == 0){
			setDirection(5);
		}
		
		
		else if(herox == 0 && coordonney < y && correction == 1){
			setDirection(8);
		}
		else if(herox == 0 && coordonney > y && correction == 1){
			setDirection(8);
		}
		else if(heroy == 0 && coordonnex > x && correction == 1){
			setDirection(8);
		}
		else if(heroy == 0 && coordonnex < x && correction == 1){
			setDirection(6);
		}
		else if(herox < 0 && heroy < 0 && correction == 1){
			setDirection(3);
		}
		else if(herox < 0 && heroy > 0 && correction == 1){
			setDirection(3);
		}
		else if(herox > 0 && heroy < 0 && correction == 1){
			setDirection(4);
		}
		else if(herox > 0 && heroy > 0 && correction == 1){
			setDirection(4);
		}
		
		else if(herox == 0 && coordonney < y && correction == 2){
			setDirection(6);
		}
		else if(herox == 0 && coordonney > y && correction == 2){
			setDirection(5);
		}
		else if(heroy == 0 && coordonnex > x && correction == 2){
			setDirection(7);
		}
		else if(heroy == 0 && coordonnex < x && correction == 2){
			setDirection(5);
		}
		else if(herox < 0 && heroy < 0 && correction == 2){
			setDirection(1);
		}
		else if(herox < 0 && heroy > 0 && correction == 2){
			setDirection(2);
		}
		else if(herox > 0 && heroy < 0 && correction == 2){
			setDirection(1);
		}
		else if(herox > 0 && heroy > 0 && correction == 2){
			setDirection(2);
		}
		
		else if(herox < 0 && heroy < 0 && correction == 3){
			setDirection(7);
		}
		else if(herox < 0 && heroy > 0 && correction == 3){
			setDirection(8);
		}
		else if(herox > 0 && heroy < 0 && correction == 3){
			setDirection(5);
		}
		else if(herox > 0 && heroy > 0 && correction == 3){
			setDirection(6);
		}
	}


}
