package domain.squares.railroadSquares;

import domain.MonopolyGameController;
import domain.Player;

public class ShortLineSquare extends RailroadSquare {
	private int price;
	private int[] rent;
	private int numberOfTrainDepots;
	private int trainDepotPrice;
	private Player owner;

	public ShortLineSquare() {
		super("ShortLineSquare", 0, 0, null, 200, null, 0, 0, false);
		rent = new int[7];
		this.rent[0] = 25;
		this.rent[1] = 50;
		this.rent[2] = 100;
		this.rent[3] = 200;

	}

	public void initShortLineSquare() {
		
		this.price = 200;
		this.owner = null;
		//rent = new int[7];
		this.rent[1] = 25;
		this.rent[2] = 50;
		this.rent[3] = 100;
		this.rent[4] = 200;
		this.numberOfTrainDepots = 0;
		this.trainDepotPrice = 0;
	}

	@Override
	public void landedOn() {
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();
	}

}
