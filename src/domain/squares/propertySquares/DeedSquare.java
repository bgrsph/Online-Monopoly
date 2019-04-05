package domain.squares.propertySquares;

import java.util.Arrays;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.squares.Square;

public abstract class DeedSquare extends Square {
	
	Player owner;
	int price;
	int[] rent = new int[7];
	int numberOfHouses;
	int housePrice;
	int numberOfHotels;
	int hotelPrice;
	int numberOfSkyScrapers;
	int SkyScraperPrice;
	String color;
	String currentBuilding;


	//CONSTRUCTOR
	public DeedSquare(String name, int x, int y, Player owner, int price, int numberOfHouses,
			int housePrice, int numberOfHotels, int hotelPrice, int numberOfSkyScrapers, int skyScraperPrice,
			String color) {
		
		super(name, x, y);
		this.owner = owner;
		this.price = price;
		this.numberOfHouses = numberOfHouses;
		this.housePrice = housePrice;
		this.numberOfHotels = numberOfHotels;
		this.hotelPrice = hotelPrice;
		this.numberOfSkyScrapers = numberOfSkyScrapers;
		SkyScraperPrice = skyScraperPrice;
		this.color = color;
		this.currentBuilding="house";

	}

	/**
	 * @requires -
	 * @modifies -
	 * @effects Since it is not an action square, this type of squares does manuplates 
	 * 			nothing.
	 * 
	 */

	@Override
	public abstract void landedOn();

	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the owner of the this DeedSquare
	 * 
	 */

	public Player getOwner() {
		return owner;
	}

	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the price of the this DeedSquare
	 * 
	 */

	public int getPrice() {
		return price;
	}

	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the rent array, the array including
	 * 			all the possible rents of the this DeedSquare
	 * 
	 */

	public int[] getRent() {
		return rent;
	}

	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the color of the this DeedSquare
	 * 
	 */

	public String getColor() {
		return color;
	}

	/**
	 * @requires -
	 * @modifies owner
	 * @effects Sets the owner fied of the DeedSquare to the param owner
	 * 
	 */

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	/**
	 * @requires -
	 * @modifies price
	 * @effects Sets the price fied of the DeedSquare to the param price if the param price is larger than or equals to 0
	 * 
	 */   

	public void setPrice(int price) {
		if(price>=0) this.price = price;
	}

	/**
	 * @requires -
	 * @modifies rent
	 * @effects Sets the rent fied of the DeedSquare to the param rent
	 * 
	 */

	public void setRent(int[] rent) {
		this.rent = rent;
	}

	/**
	 * @requires -
	 * @modifies color
	 * @effects Sets the color fied of the DeedSquare to the param color
	 * 
	 */

	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * @requires Param property should not be null and there has to be at least one instance of that property in this DeedSquare
	 * @modifies this, currentPlayer(owner)
	 * @effects Decreases the number of the param property of the DeedSquare and increase the sub-building of that property with adequate number.
	 * 			Also, increase the amountMoney param of the owner, which is an instance of Player, with the halved price of the property.
	 * 
	 */
	
	public void mortgage() {
		MonopolyGameController.getInstance();
		//we have excluded the checking the building amount
		//by assuming we always have enough building as we talk
		//with TA. Nevertheless, we commented out the part that written assuming the limited propert resource
		switch(currentBuilding) {
		case "skyscraper":
			if(this.getNumberOfSkyScrapers()==1) {
				MonopolyGameController.getInstance();
				MonopolyGameController.getCurrentPlayer().demolishSkyscraper(color);
			} else Logger.getInstance().notifyAll("Can not mortgage such a skyscraper");
			break;
		case "hotel":
			if(this.getNumberOfHotels()==1) {
				this.owner.increaseMoney(this.hotelPrice/2);
				this.downgradeFrom(currentBuilding);
				Logger.getInstance().notifyAll("Mortgage operation for skyscraper is done");
			} else Logger.getInstance().notifyAll("Can not mortgage such a hotel");
			break;
		case "house":
			if(this.getNumberOfHouses()>=1) {
				this.owner.increaseMoney(this.housePrice/2);
				this.downgradeFrom(currentBuilding);
				Logger.getInstance().notifyAll("Mortgage operation for skyscraper is done");
			}else Logger.getInstance().notifyAll("Can not mortgage such a house");
			break;
		}
	}
	
	public boolean repOk() {
		if (this.price > 0 && this.housePrice > 0 
				&& this.hotelPrice > 0 && this.SkyScraperPrice > 0 && this.color != null ) {
			
				return true;
		}

		return false;
	}

	public int getNumberOfHouses() {
		return numberOfHouses;
	}
	/**
	 * @requires -
	 * @modifies numberOfHouses
	 * @effects Sets the numberOfHouses fied of the DeedSquare to the param numberOfHouses
	 * 
	 */
	public void setNumberOfHouses(int numberOfHouses) {
		if(numberOfHouses>=0)
		this.numberOfHouses = numberOfHouses;
	}
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the housePrice of the this DeedSquare
	 * 
	 */

	public int getHousePrice() {
		return housePrice;
	}
	/**
	 * @requires -
	 * @modifies housePrice
	 * @effects Sets the housePrice fied of the DeedSquare to the param housePrice
	 * 
	 */
	public void setHousePrice(int housePrice) {
		if(housePrice>=0)
		this.housePrice = housePrice;
	}
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the numberOfHotels of the this DeedSquare
	 * 
	 */
	public int getNumberOfHotels() {
		return numberOfHotels;
	}
	/**
	 * @requires -
	 * @modifies numberOfHotels
	 * @effects Sets the numberOfHotels fied of the DeedSquare to the param numberOfHotels
	 * 
	 */

	public void setNumberOfHotels(int numberOfHotels) {
		if(numberOfHotels>=0)
		this.numberOfHotels = numberOfHotels;
	}
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the hotelPrice of the this DeedSquare
	 * 
	 */
	public int getHotelPrice() {
		return hotelPrice;
	}
	/**
	 * @requires -
	 * @modifies hotelPrice
	 * @effects Sets the hotelPrice fied of the DeedSquare to the param hotelPrice
	 * 
	 */

	public void setHotelPrice(int hotelPrice) {
		if(hotelPrice>=0)
		this.hotelPrice = hotelPrice;
	}
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the numberOfSkyScrapers of the this DeedSquare
	 * 
	 */
	public int getNumberOfSkyScrapers() {
		return numberOfSkyScrapers;
	}
	/**
	 * @requires -
	 * @modifies numberOfSkyScrapers
	 * @effects Sets the numberOfSkyScrapers fied of the DeedSquare to the param numberOfSkyScrapers
	 * 
	 */

	public void setNumberOfSkyScrapers(int numberOfSkyScrapers) {
		if(numberOfSkyScrapers>=0)
		this.numberOfSkyScrapers = numberOfSkyScrapers;
	}
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the SkyScraperPrice of the this DeedSquare
	 * 
	 */

	public int getSkyScraperPrice() {
		return SkyScraperPrice;
	}
	/**
	 * @requires -
	 * @modifies skyScraperPrice
	 * @effects Sets the skyScraperPrice fied of the DeedSquare to the param skyScraperPrice
	 * 
	 */

	public void setSkyScraperPrice(int skyScraperPrice) {
		if(skyScraperPrice>=0)
		SkyScraperPrice = skyScraperPrice;
	}

	@Override
	public String toString() {
		return this.getName();
	}

	public void downgradeFrom(String property) {
		switch(property) {
		case "skyscraper":
			if(this.getNumberOfSkyScrapers()==1) {
				this.currentBuilding="hotel";				
				this.numberOfSkyScrapers--;
				this.numberOfHotels++;
				Logger.getInstance().notifyAll(this.getName()+" downgraded from skyscraper to hotel");
			} else Logger.getInstance().notifyAll("Could not downgraded since lack of skyscraper");
			break;
		case "hotel":
			if(this.getNumberOfHotels()==1) {
				this.currentBuilding="house";	
				this.numberOfHotels--;
				this.numberOfHouses+=4;
				Logger.getInstance().notifyAll(this.getName()+" downgraded from hotel to house");
			} else Logger.getInstance().notifyAll("Could not downgraded since lack of hotel");
			break;
		case "house":
			if(this.getNumberOfHouses()>=1) {
				this.numberOfHouses--;
			} else Logger.getInstance().notifyAll("Could not downgraded since lack of houses");
			break;
		}
	}
	
	public void upgrade() {
		if(this.avaibleForImproving()) {
			switch(currentBuilding) {
			case "hotel":
				MonopolyGameController.getInstance();
				MonopolyGameController.getCurrentPlayer().buildSkyscraper(this.color);
				Logger.getInstance().notifyAll(this.getName() +" upgraded to skyscraper from hotel" );
				break;
			case "house":
				if(this.getNumberOfHouses()<4) {
				this.currentBuilding="house";
				this.numberOfHouses++;
				this.owner.decreaseMoney(this.housePrice);
				Logger.getInstance().notifyAll(this.getName() +" upgraded to hotel from house" );
				}else {
					this.currentBuilding="hotel";
					this.numberOfHouses=0;
					this.numberOfHotels++;
					this.owner.decreaseMoney(this.hotelPrice);
					Logger.getInstance().notifyAll(this.getName() +" upgraded with house" );
				}
				break;
			}
		} else Logger.getInstance().notifyAll("Can't upgrade at the moment");

	}
	
	public boolean avaibleForImproving() {
		Player p= this.getOwner();
		System.out.println("Owner of the square as object: " + p);
		System.out.println("Same Colored Ones: " + p.getColoredOnes(this.getColor()))
		;
		if(p.majorityOrMonopoly(this.color)=="Majority Ownership"||p.majorityOrMonopoly(this.color)=="Monopoly") return true;
		else return false;
	}
	public String getCurrentBuilding() {
		return currentBuilding;
	}

	public void setCurrentBuilding(String currentBuilding) {
		this.currentBuilding = currentBuilding;
	}
	public int getCurrentRent() {
		if(this.currentBuilding.equals("house")) {
			return this.rent[this.numberOfHouses];
		}
		else if(this.currentBuilding.equals("hotel")) {
			return this.rent[5];
		}
		else if(this.currentBuilding.equals("skyscraper")){
			return this.rent[6];

		} else return this.rent[0];
		
	}
	
	public boolean isOwned() {
		if(this.owner==null) return false;
		else return true;
	}

}
