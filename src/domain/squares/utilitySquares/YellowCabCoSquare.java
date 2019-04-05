
package domain.squares.utilitySquares;

import domain.MonopolyGameController;
import domain.Player;
import domain.squares.Square;

public class YellowCabCoSquare extends Square{

	private Player owner;
	private int price;
	private int[] rent;

	
	public YellowCabCoSquare() {
		
		super("YellowCabCoSquare", 0, 0);
		rent = new int[7];
		initYellowCabCo();
		
	}
	
	public void initYellowCabCo() {
		this.price = 300;
		this.owner = null;
		
		this.rent[1] = 30;
		this.rent[2] = 60;
		this.rent[3] = 120;
		this.rent[4] = 240;
	


			
		
	}
	
	public void landedOn(MonopolyGameController controller) {
		System.out.println("Landed On Yellow Cab Co");
		
		
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		
	}
	
	public void payRent() {
		
	}
}
