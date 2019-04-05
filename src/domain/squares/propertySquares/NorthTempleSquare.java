package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class NorthTempleSquare extends DeedSquare {
	public NorthTempleSquare() {
		super("NorthTempleSquare", 0, 0, null, 360, 0, 200, 0, 200, 0, 200, "olive");
		this.rent[0]=38;
		this.rent[1]=170;
		this.rent[2]=520;
		this.rent[3]=1125;
		this.rent[4]=1425;
		this.rent[5]=1275;
		this.rent[6]=1650;
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
	
	public void landedOn(MonopolyGameController controller) {
		System.out.println("Landed On North Temple");
		
		
	}

}

