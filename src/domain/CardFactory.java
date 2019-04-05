package domain;



import domain.cards.Card;
import domain.cards.chanceActionCards.AdvanceToTheNearestRailRoadCard;
import domain.cards.chanceActionCards.AdvanceToThePayCornerCard;
import domain.cards.chanceActionCards.GetOutJailFreeCard;
import domain.cards.chanceActionCards.GoToJailCard;
import domain.cards.chanceActionCards.HolidayBonusCard;
import domain.cards.chanceActionCards.HurricaneMakesLandfallCard;
import domain.cards.communityChestCards.HappyBirthdayCard;
import domain.cards.communityChestCards.HouseCondemnedCard;
import domain.cards.communityChestCards.TornadoHitsCard;

/*
 * Creates Cards according to their names. 
 * (Returns card classes)
 */
public class CardFactory {

	

	private static CardFactory cardFactoryInstance;
	
	 
	public static CardFactory getInstance() {
		
		if(cardFactoryInstance == null) {
			cardFactoryInstance = new CardFactory();
		}
		
		return cardFactoryInstance;
	}
	
	
	public Card createCard(String cardName) {
		
		 if(cardName.equals("HolidayBonusCard")) {
			return new HolidayBonusCard();
		}

		else if(cardName.equals("AdvanceToTheNearestRailRoadCard")) {
			 return new AdvanceToTheNearestRailRoadCard();
				
		}
		else if(cardName.equals("AdvanceToThePayCornerCard")) {
			 return new AdvanceToThePayCornerCard();
				
		}
		else if(cardName.equals("GetOutJailFreeCard")) {
			 return new GetOutJailFreeCard();
				
		}
		else if(cardName.equals("GoToJailCard")) {
			 return new GoToJailCard();
				
		}
		else if(cardName.equals("HappyBirthdayCard")) {
			 return new HappyBirthdayCard();
				
		}
		else if(cardName.equals("TornadoHitsCard")) {
			 return new TornadoHitsCard();
				
		}
		else if(cardName.equals("HouseCondemnedCard")) {
			 return new HouseCondemnedCard();
				
		}
		 
		else if(cardName.equals("HurricaneMakesLandfallCard")) {
			 return new HurricaneMakesLandfallCard();
				
		}
		 
		 
		 

		else {
			System.out.println("You did not write the code for generating the card called \" " + cardName +"\" in the CardFactory class" );
			return null;
		}
		
		
		
		
		
		
		
		
	}


	

}
