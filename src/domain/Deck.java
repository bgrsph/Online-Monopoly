package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import domain.cards.Card;



public class Deck implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Card> chanceActionCards;
	private ArrayList<Card> communityChestCards;
	private ArrayList<Card> allCards;

	public Deck() {
		chanceActionCards = new ArrayList<Card>();
		communityChestCards = new ArrayList<Card>();
		initAllCards();
		allCards = new ArrayList<Card>(chanceActionCards);
		allCards.addAll(communityChestCards);
	}

	
	
	public ArrayList<Card> getChanceActionCards() {
		return this.chanceActionCards;
	}
	
	public ArrayList<Card> getCommunityChestCards() {
		return this.communityChestCards;
	}
	
	private void initAllCards() { 
	
		chanceActionCards.add(CardFactory.getInstance().createCard("AdvanceToTheNearestRailRoadCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("GetOutJailFreeCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("GoToJailCard"));
		communityChestCards.add(CardFactory.getInstance().createCard("HappyBirthdayCard"));
		communityChestCards.add(CardFactory.getInstance().createCard("HouseCondemnedCard"));
		
		
		chanceActionCards.add(CardFactory.getInstance().createCard("HolidayBonusCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("HurricaneMakesLandfallCard"));

		/*

		chanceActionCards.add(CardFactory.getInstance().createCard("AdvanceToTheSaintCharlesPlaceCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("BuyersMarketCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("ChangingLanesCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("ForeclosedPropertySaleCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("ForwardThinkerCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("GetOutJailFreeCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("GetRollinCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("GpsIsNotWorkingCard"));
		*/
	
		//chanceActionCards.add(CardFactory.getInstance().createCard("AdvanceToThePayCornerCard"));
		
		
		/*
		
		chanceActionCards.add(CardFactory.getInstance().createCard("JustSayNoCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("MakeGeneralRepairsToAllYourPropertiesCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("MardiGrasCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("PayBackCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("PropertyTaxesCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("RideTheSubwayCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("SeeYouInCourtCard"));
		chanceActionCards.add(CardFactory.getInstance().createCard("SocialMediaFailCard"));
		
		*/
		
	
		/*
		communityChestCards.add(CardFactory.getInstance().createCard("AMovingExperienceCard"));
		communityChestCards.add(CardFactory.getInstance().createCard("BeKindRewindCard"));
		communityChestCards.add(CardFactory.getInstance().createCard("GameNightCard"));
	
		communityChestCards.add(CardFactory.getInstance().createCard("HappyBirthdayCard"));
		//communityChestCards.add(CardFactory.getInstance().createCard("TornadoHitsCard"));
		communityChestCards.add(CardFactory.getInstance().createCard("HouseCondemnedCard"));
		
		
		communityChestCards.add(CardFactory.getInstance().createCard("HouseCondemnedCard"));
		communityChestCards.add(CardFactory.getInstance().createCard("PayHospitalBillsCard"));
		communityChestCards.add(CardFactory.getInstance().createCard("ShareInTheirGoodFortuneCard"));
		communityChestCards.add(CardFactory.getInstance().createCard("TheInsidersEdgeCard"));
		
*/

		
		
		

	}

	public Card pickRandomCard(String cardType) {

		if (cardType.equals("ChanceActionCard")) {

			return chanceActionCards.get(new Random().nextInt(chanceActionCards.size()));

		}

		else if (cardType.equals("CommunityChestCard")) {

			return communityChestCards.get(new Random().nextInt(communityChestCards.size()));
		}

		System.out.println("You did not correctly write the cardType. \n" + "Possible Card Types: "
				+ "\nChanceActionCard \nCommunityChestCard \nRollThreeCard");

		return null;
	}


	
	public Card getCard(String cardName) {
		
		for(Card c: this.allCards) {
			if(c.getName().equals(cardName)) {
				return c;
			}
		}
		
		return null;
	}
	
	
	
	
	
	
}
