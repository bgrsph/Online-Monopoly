package domain.squares.utilitySquares;

import domain.Player;
import domain.squares.Square;

public abstract class UtilitySquare extends Square {

	Player owner;
	int price;
	
	public UtilitySquare(String name, int x, int y) {
		super(name, x, y);
		this.owner = null;
		this.price = 150;
	}
	
	@Override
	public abstract void landedOn();


	public Player getOwner() {
		return owner;
	}



	public int getPrice() {
		return price;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}



	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public int getCurrentRent(int x){
		int calculatedRent=0;
		if(x==1) calculatedRent=4;
		else if(x==2) calculatedRent=10;
		else if(x==3) calculatedRent=20;
		else if(x==4) calculatedRent=40;
		else if(x==5) calculatedRent=80;
		else if(x==6) calculatedRent=100;
		else if(x==7) calculatedRent=120;
		else if(x==8) calculatedRent=150;
		return calculatedRent;
	}


	public boolean isOwned() {
		if(this.owner==null) return false;
		else return true;
	}







}