package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class NewYorkAvenueSquare extends DeedSquare{

	public NewYorkAvenueSquare() {
		
		super("NewYorkAvenueSquare", 0, 0, null, 100, 0, 100, 0, 100, 0, 100, "orange");
		this.rent[0]=16;
		this.rent[1]=80;
		this.rent[2]=220;
		this.rent[3]=600;
		this.rent[4]=800;
		this.rent[5]=1000;
		this.rent[6]=1500;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();
	}
	
	public void payRent() {
		
	}
}
