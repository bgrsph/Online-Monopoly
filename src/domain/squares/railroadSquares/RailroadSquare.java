package domain.squares.railroadSquares;

import domain.Player;
import domain.squares.Square;

public abstract class RailroadSquare extends Square {

	Player owner;
	int price;
	int[] rent;
	int numberOfTrainDepots;
	int trainDepotPrice;
	boolean isOwned;


	public RailroadSquare(String name, int x, int y, Player owner, int price, int[] rent, int numberOfTrainDepots, int trainDepotPrice, boolean isOwned) {
		super(name, x, y);
		this.owner = owner;
		this.price = price;
		this.rent = rent;
		this.numberOfTrainDepots = numberOfTrainDepots;
		this.trainDepotPrice = trainDepotPrice;
		this.isOwned=false;
	} 
	public void buyTrainDepot(){
		if(this.getOwner().checkBalance(100) && this.getNumberOfTrainDepots()==0){
			this.getOwner().decreaseMoney(100);
			this.numberOfTrainDepots++;
		} else System.out.println(this.getOwner().getName() + "has no enough money to buy train depot!");
	}

	public void sellTrainDepots(){
		if(this.getNumberOfTrainDepots()==1){
			this.owner.increaseMoney(50);
			this.numberOfTrainDepots--;
		} 
	}


	@Override
	public abstract void landedOn();



	public Player getOwner() {
		return owner;
	}



	public int getPrice() {
		return price;
	}



	public int[] getRent() {
		return rent;
	}



	public void setOwner(Player owner) {
		this.owner = owner;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public void setRent(int[] rent) {
		this.rent = rent;
	}



	public int getNumberOfTrainDepots() {
		return numberOfTrainDepots;
	}



	public void setNumberOfTrainDepots(int numberOfTrainDepots) {
		this.numberOfTrainDepots = numberOfTrainDepots;
	}



	public int getTrainDepotPrice() {
		return trainDepotPrice;
	}



	public void setTrainDepotPrice(int trainDepotPrice) {
		this.trainDepotPrice = trainDepotPrice;
	}

	public boolean isOwned() {
		if(this.owner==null) return false;
		else return true;
	}
	public void decrementDepot() {
		// TODO Auto-generated method stub
		if(this.numberOfTrainDepots!=0)
		this.numberOfTrainDepots--;
	}

}
