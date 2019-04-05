package domain;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.webkit.Timer;

import domain.bots.Bot;
import domain.cards.Card;
import domain.cards.chanceActionCards.HurricaneMakesLandfallCard;
import domain.network.NetworkController;
import domain.squares.Passable;
import domain.squares.Square;
import domain.squares.actionSquares.ChanceSquare;
import domain.squares.actionSquares.CommunityChestSquare;
import domain.squares.actionSquares.PayDaySquare;
import domain.squares.propertySquares.DeedSquare;
import domain.squares.railroadSquares.RailroadSquare;
import domain.squares.utilitySquares.UtilitySquare;
import ui.Facade;

public class MonopolyGameController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static MonopolyGameController monopolyGameController;
	private static int PLAYER_TURN_INDEX = 0;
	private static ArrayList<Player> players;
	private static ArrayList<Pawn> pawns;
	private static String serverIPAddress;
	private static int numberOfPlayers;
	private static ArrayList<String> pawnNames;
	private static Cup cup;
	private static Board board; //contains all the squares
	private static Deck deck; //contains all the cards
	private static Pool pool; //contains bank money
	private static HashMap<String, Object> saveMap = new HashMap<String,Object>();
	public static ArrayList<File> fileList = new ArrayList<File>();
	private static SaveLoadHandler saveLoadHandler;
	private static int doubleCounter;  
	private static int useCardCounter;
	private static int mortgageButtonCounter = 0;
	private static int buildBuildingButtonCounter = 0;
  
	private MonopolyGameController() {
		players = new ArrayList<Player>();
		pawns = new ArrayList<Pawn>();
		cup = new Cup();
		deck = new Deck();
		board = new Board(); 
		pawnNames = new ArrayList<String>();
		NetworkController.getInstance(); 
		pool= new Pool();
		saveLoadHandler = new SaveLoadHandler();
		
	} 
	

	public static int getDoubleCounter() {
		return doubleCounter;
	}
	
	
	public static void setDoubleCounter(int x) {
		 doubleCounter = x;
	}
  

	public static void initializeTheGame(HashMap<String, String> playersWithPawnImageNames, HashMap<String, String> playerNamesWithBotTypes, int numberOfPlayers,
			String serverIPAddress) {
	
		setNumberOfPlayers(numberOfPlayers);
		setServerIPAddress(serverIPAddress);
		initializePlayersAndPawns(playersWithPawnImageNames,playerNamesWithBotTypes);
	
		Logger.getInstance().notifyLocal("Game is initiated now."); 
		Logger.getInstance().notifyLocal("Please Press \"Start\" button to start the game.");
	}
	
	
	
	

// Bot(String name, int startingBalance, ArrayList<Card> cards, Pawn pawn, String botType) {
	private static void initializePlayersAndPawns(HashMap<String, String> playersWithPawnImageNames, HashMap<String, String> playerNamesWithBotTypes) {
		
		System.out.println("INIT PLAYERS AND PAWNS CALLED WITH TWO HASHMAPS:");
		
		
		System.out.println("PLAYERS WITH OAWN IMAGE NAMES: " + playersWithPawnImageNames );
		System.out.println("PLAYERS WITH BOT TYPES: " + playerNamesWithBotTypes );
		
		
		
		for(String currentPlayerName: playersWithPawnImageNames.keySet()) {
			
		
			
			if(playerNamesWithBotTypes.get(currentPlayerName).equals("HumanPlayer")) {
				System.out.println("OVER HERE!!!!!!!");
				String currentPawnName = playersWithPawnImageNames.get(currentPlayerName);
				Pawn newPawn = new Pawn(currentPawnName);
				ArrayList<Card> playersInitialCardList = new ArrayList<Card>();
				Player newPlayer = new Player(currentPlayerName,3200,playersInitialCardList,newPawn);	
				getPawnNames().add(currentPawnName);
				getPlayersList().add(newPlayer);
				System.out.println("ADDING PAWN FOR BOT: " + currentPawnName);
				getPawnsList().add(newPawn);
			} else {
				System.out.println("OVER :((");
				String currentPawnName = playersWithPawnImageNames.get(currentPlayerName);
				Pawn newPawn = new Pawn(currentPawnName);
				ArrayList<Card> playersInitialCardList = new ArrayList<Card>();
				String botType = playerNamesWithBotTypes.get(currentPlayerName);
				Bot newPlayerAsBot = new Bot(currentPlayerName,3200,playersInitialCardList,newPawn,botType);
				System.out.println("ADDING PAWN FOR BOT: " + currentPawnName);
				getPawnNames().add(currentPawnName);
				getPlayersList().add(newPlayerAsBot);
				getPawnsList().add(newPawn);
			}

		}
 
	}
	
	
	
	public static void hurricaneButtonPressed() {
		
		
		String squareType = Facade.getInstance().getSelectedSquareType();
		String selectedColor = Facade.getInstance().getSelectedColorType();
		
		handleHurricaneMakesLandFallCard(squareType,selectedColor);
		NetworkController.getInstance().hurricaneEvent(squareType,selectedColor);
	}
	
	
	public static void handleHurricaneMakesLandFallCard(String squareType, String selectedColor) {
		
		Card c = getDeck().getCard("HurricaneMakesLandfallCard");
		((HurricaneMakesLandfallCard) c).useCard(squareType,selectedColor);
		
	}
	
	
	


	public static int getBankruptPlayerNumber() {
		int i=0;
		for(Player p: getPlayersList()) {
			if(p.getBankruptcy()) {
				i++;
			}
		}
		return i;
	}
	 
	
	public static void nextTurnLocal() {
		
		
		String oldPlayerName = getCurrentPlayer().getName();
		PLAYER_TURN_INDEX++;
		doubleCounter = 0;
		Logger.getInstance().notifyAll("It's " + MonopolyGameController.getCurrentPlayer().getName() + "'s turn now.");
		
		
		Player currentPlayer = getCurrentPlayer();
		if(currentPlayer instanceof Bot) {
			((Bot) MonopolyGameController.getCurrentPlayer()).playBot();
			PLAYER_TURN_INDEX++;
		}
		
//			if(MonopolyGameController.getCurrentPlayer().getBankruptcy()) {
//			// oldPlayerName = getCurrentPlayer().getName();
//			PLAYER_TURN_INDEX++;
//			return;
//		}
		
//		if(1==(getPlayersList().size()-getBankruptPlayerNumber())) {
//			Logger.getInstance().notifyAll("Game is over!!!");
//			Logger.getInstance().notifyAll(getCurrentPlayer()+" has won the game.");
//			//NetworkController.getInstance().gameEndEvent();
//			return;
//		}
//		
		
		
	}
	
	
	
	
	public static void endTurnButtonPressed() {
		mortgageButtonCounter = 0;
		nextTurn();
		Facade.getInstance().switchButtonsToAfterEndTurnPressed();
	}
	
	
	public static void nextTurn() {
		String oldPlayerName = getCurrentPlayer().getName();
		NetworkController.getInstance().nextTurnEvent(oldPlayerName);
		PLAYER_TURN_INDEX++;
		doubleCounter = 0;
		Logger.getInstance().notifyAll("It's " + MonopolyGameController.getCurrentPlayer().getName() + "'s turn now.");
	}
	
	
	
	public static void nextTurnWithoutNetwork() {
		
		doubleCounter = 0;
		buildBuildingButtonCounter = 0;
		PLAYER_TURN_INDEX++;
		Logger.getInstance().notifyAll("It's " + MonopolyGameController.getCurrentPlayer().getName() + "'s turn now.");
	}
	
	public static void handleHappyBirthdayCard(Player cardOwnerPlayer) throws InterruptedException {
		
		for(Player player: getPlayersList()) {
			
			if(player != cardOwnerPlayer) {
				
				if(player.getBalance() < 10) {
					
				}
				player.decreaseMoney(10);
				cardOwnerPlayer.increaseMoney(10);
			}
			
		}
		
		Logger.getInstance().notifyAll(cardOwnerPlayer.getName() + " pulled Happy birthday card. (takes 10 from others)");
		//MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		int currentSqIndex = getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = getBoard().getSquareList().get(currentSqIndex);
		Square targetSquare = getBoard().getSquare("BirthdayGiftSquare");
		int targetSqIndex = getBoard().getSquareList().indexOf(targetSquare);
		cardOwnerPlayer.setCurrentSquareIndex(targetSqIndex);
		teleportPlayer(cardOwnerPlayer,currentSquare, targetSquare,targetSqIndex);
	}
	
	
	public static Board getBoard()  {
		return board;
	}
	 

	

	 public static void teleportPlayer(Player cardOwnerPlayer, Square source, Square target, int targetSquareIndex) throws InterruptedException {
		 		 
		Facade.getInstance().teleport(cardOwnerPlayer,source.getName(), target.getName(),targetSquareIndex );
		
	}



	
	
	
	/*
	 * GETTERS AND SETTERS START HERE
	 */
	
	public static Player getCurrentPlayer() {
		
		
		if(MonopolyGameController.PLAYER_TURN_INDEX == getNumberOfPlayers()) { 
			
			MonopolyGameController.PLAYER_TURN_INDEX = 0;
			
			return getPlayersList().get(MonopolyGameController.PLAYER_TURN_INDEX );
		}
		
		else {
			return getPlayersList().get(MonopolyGameController.PLAYER_TURN_INDEX );
		}
	}
	
	

	public static ArrayList<Player> getPlayersList() {
		return players;
	}

	public static ArrayList<Pawn> getPawnsList() {
		return pawns;
	}

	public static String getServerIPAddress() {
		return serverIPAddress;
		
		
	}

	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public static void setServerIPAddress(String serverIPAddress) {
		MonopolyGameController.serverIPAddress = serverIPAddress;
	}


	public static Deck getDeck() {
		return MonopolyGameController.deck;
	}

	private static void setNumberOfPlayers(int numberOfPlayers2) {
		numberOfPlayers = numberOfPlayers2;
		
	}



	public static void useCard() {
		
		
	}
	
	public static Pool getPool() {
		return pool;
	}
	
	
	
	public static ArrayList<String> getPawnNames() {
		return MonopolyGameController.pawnNames;
	}
	


	public void notifyAll(String notification) {
		
		Facade.getInstance();
		Facade.notifyPlayers(notification);
	}
	
	
	public static Cup getCup() {
		
		return MonopolyGameController.cup;
	}
 
	
	//TODO: Call the move function according to the values of the dice!
	public static void rollDice() throws InterruptedException {
		
		getCup().rollDice(2);
		int totalFaceValue = getCup().getResults().get(0).getValue() + getCup().getResults().get(1).getValue();
		Logger.getInstance().notifyAll((getCurrentPlayer().getName()+" rolled "+ cup.getResults().toString()));
		
		System.out.println("ROLL DICE WITH NETWORK CUP RESULT: " + 	getCup().getResults());
		System.out.println("IS SPECIAL? " + getCup().isSpecial() );
		System.out.println("IS DOUBLE? " + getCup().isDouble() );
		System.out.println("IS TRIPLE? " + getCup().isTriple());
		
		
		MonopolyGameController.getInstance();
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();	
		Facade.getInstance().startRollDiceAnimation();	
	
		
		Cup c=getCup();
		if(currentPlayer.isInJail()) {
			handleJail();
		}else {
			if(c.isTriple()) {
				Facade.getInstance().switchButtonsToTriplesState();
				Facade.getInstance().informPlayerToSelectDesiredSquare();
			}else {
				if(getCup().isDouble()) {
					doubleCounter++;
					if(doubleCounter==3) {
						//Todo:
						currentPlayer.nowInJail();
						doubleCounter=0;
						allowCurrentPlayerToEndTurn();
							
					} else {
						Facade.getInstance().switchButtonsToPlayAgainState();
					}
				}
				if(!currentPlayer.isInJail()) {
					MonopolyGameController.move(currentPlayer, totalFaceValue);	
				}

				if(cup.isSpecial()) {	
					Facade.getInstance().switchButtonsToSpecialMoveState();
				}
			}
		}
		
		System.out.println("SENDING OVER NETWORK CUP RESULTS: " + getCup().getResults());
		NetworkController.getInstance().rollDiceEvent(getCup().getResults());
		NetworkController.getInstance().disableOtherClientsInteractions();
//		if(getCup().isSpecial()||(doubleCounter>0&&doubleCounter<3)) {
//			Facade.getInstance().closeEndTurn();
//		}
		
	}
	
	
	
	
	//TODO: Call the move function according to the values of the dice!
	public static void rollDiceWithoutNetwork(int val1, int val2, int val3) throws InterruptedException {
		ArrayList<FaceVal> results = new ArrayList<FaceVal>();
		results.add(FaceVal.fromIntegerToFaceVal(val1));
		results.add(FaceVal.fromIntegerToFaceVal(val2));
		results.add(FaceVal.fromIntegerToFaceVal(val3));
		getCup().setResults(results);
		
		
		System.out.println("ROLL DICE WITHOUT NETWORK CUP RESULT: " + 	getCup().getResults());
		System.out.println("IS SPECIAL? " + getCup().isSpecial() );
		System.out.println("IS DOUBLE? " + getCup().isDouble() );
		System.out.println("IS TRIPLE? " + getCup().isTriple());
		
		int totalFaceValue = getCup().getResults().get(0).getValue() + getCup().getResults().get(1).getValue();
		Logger.getInstance().notifyAll((getCurrentPlayer().getName()+" rolled "+ cup.getResults().toString()));
		MonopolyGameController.getInstance();
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();	
		Facade.getInstance().startRollDiceAnimation();	
		
		
		Cup c=getCup();
		if(currentPlayer.isInJail()) {
			handleJail();
		}else {
			if(c.isTriple()) {
				//Do nothing.
			}else {
				if(getCup().isDouble()) {
					doubleCounter++;
					if(doubleCounter==3) {
						currentPlayer.nowInJail();
						doubleCounter=0;
						allowCurrentPlayerToEndTurn();
							 
					} else {
						Facade.getInstance().switchButtonsToPlayAgainState();
					}
				}
				if(!currentPlayer.isInJail()) {
					MonopolyGameController.move(currentPlayer, totalFaceValue);	
				}

				if(cup.isSpecial()) {	
					Facade.getInstance().switchButtonsToSpecialMoveState();
				}
				
			}
		}
		
		
	}
	
	
	public void specialMoveButtonPressed() {
		Cup cup = getCup();
		Player currentPlayer = getCurrentPlayer();
		int faceValue = cup.getResults().get(0).getValue() + cup.getResults().get(1).getValue();
				if(cup.getResults().contains(FaceVal.BUSICON)) {
					try {
						moveWithBusIcon(currentPlayer, faceValue);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
				}
				else if(cup.getResults().contains(FaceVal.MRMONOPOLY)) {
					try {
						moveWithMrMonopoly(currentPlayer, faceValue);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
				}
		NetworkController.getInstance().specialMoveEvent(faceValue);
		NetworkController.getInstance().disableOtherClientsInteractions();
		
	}
	
	public void specialMoveButtonPressedVirtually(int faceValue) {
		
		Cup cup = getCup();
		Player currentPlayer = getCurrentPlayer();
				if(cup.getResults().contains(FaceVal.BUSICON)) {
					try {
						moveWithBusIcon(currentPlayer, faceValue);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
				}
				else if(cup.getResults().contains(FaceVal.MRMONOPOLY)) {
					try {
						moveWithMrMonopoly(currentPlayer, faceValue);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
				}
		
	}
	

	
	public void triplesButtonPressed(){
		
		try {
			handleTriples();
			Facade.getInstance().switchButtonsToAfterTriplesState();
			NetworkController.getInstance().disableOtherClientsInteractions();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void handleTriplesWithoutNetwork(String desiredSquareName) {
		Player currentPlayer = getCurrentPlayer();
		int currentSqIndex = MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		Square targetSquare = getBoard().getSquare(desiredSquareName);
		Logger.getInstance().notifyAll(currentPlayer.getName() + " rolled Triples");
		Facade.getInstance().disableInteractions();
		try {
			MonopolyGameController.getCurrentPlayer().setCurrentSquareIndex(MonopolyGameController.getInstance().getBoard().getSquareList().indexOf(targetSquare));
			currentPlayer.setCurrentSquareIndex(getBoard().getSquareList().indexOf(targetSquare));
			MonopolyGameController.teleportPlayer(currentPlayer,currentSquare, targetSquare, MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex());
			targetSquare.landedOn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void handleTriples() throws InterruptedException {
		doubleCounter=0;
		//Facade.getInstance().switchButtonsToTriplesState();
		//Facade.getInstance().informPlayerToSelectDesiredSquare();
		
		String desiredSquareName =Facade.getInstance().getSelectedSquareNameFromUser();
		Square sq = getBoard().getSquare(desiredSquareName);
		
		int currentSqIndex = MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		
		
		MonopolyGameController.getCurrentPlayer().setCurrentSquareIndex(MonopolyGameController.getInstance().getBoard().getSquareList().indexOf(sq));
		
		try {
			MonopolyGameController.teleportPlayer(MonopolyGameController.getCurrentPlayer(),currentSquare, sq, MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex());
			sq.landedOn();
			NetworkController.getInstance().handleTriplesEvent(desiredSquareName);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void setPool(Pool p) {
		MonopolyGameController.pool = p;
	}
	
	public static void setCup(Cup c) {
		MonopolyGameController.cup = c;
	}
	
	public static void setPawnNames(ArrayList<String> n) {
		MonopolyGameController.pawnNames = n;
	}
	
	public static void setPawns(ArrayList<Pawn> p) {
		MonopolyGameController.pawns = p;
	}
	
	public static void setDeck(Deck d) {
		MonopolyGameController.deck = d;
	}
	
	public static void setPlayers(ArrayList<Player> p) {
		MonopolyGameController.players = p;
	}

	
	public static void allowCurrentPlayerToEndTurn() {
		
		Facade.getInstance().switchButtonsToEndTurnState();

		
	}
	
	public static void allowCurrentPlayerToPayRent() {
		
		Facade.getInstance().allowCurrentPlayerToPayRent();
	}
	
	
	public static Player getPlayerByName(String name) {
		
		for(Player p : getPlayersList()) {
			
			if(p.getName().equals(name)) {
				
				return p;
			}
			
		}
		
		return null;
		
	}
	

	public static void move(Player currentPlayer, int totalFaceValue) throws InterruptedException {
		System.out.println("-------------------------MOVE STARTED-----------------------------");
		System.out.println("MOVE HAS BEEN CALLED: TOTAL FACE VALUE IS :" + totalFaceValue);
		System.out.println("PLAYER : " + currentPlayer.getName());
		int currentSquareIndex = currentPlayer.getCurrentSquareIndex();
		Square initialSquare = board.getSquareList().get(currentSquareIndex);
		System.out.println("CURRENT SQUARE: " + initialSquare.getName() + " (" + initialSquare.getX() + "," + initialSquare.getY() + ")");
		int nextSquareIndex;
		
		if(currentPlayer.isInJail()) {
			handleJail();
			return;
		}
		System.out.println("PLAYER IS NOT IN JAIL");
		
	
		if(getBoard().getSquareList().get(currentSquareIndex) instanceof RailroadSquare) {
			
			System.out.println("CURRENT SQUARE IS A RAILROAD SQUARE");
			if(totalFaceValue % 2 == 0) { //if dice is rolled double, change the way
				System.out.println();
				System.out.println("DICE IS DOUBLE ROLLED, PLAYER IS TRYING TO CHANGE TRACK");
				//in this function, look at the indexes and return the next square index in the other cirlce.
				nextSquareIndex = MovementHandler.getInstance().handleRailRoadSquare(currentSquareIndex, currentPlayer.getDirection());
				System.out.println("NEXT SQUARE INDEX HASS BEEN DETERMINED: " + nextSquareIndex);
				Square nextSquare =  getBoard().getSquareList().get(nextSquareIndex);
				System.out.println("NEXT SQUARE IN THE OTHER TRACK ACCORDING TO NEW INDEX: " + nextSquare.getName()+ " (" + nextSquare.getX() + "," + nextSquare.getY() + ")" + " index: " +  getBoard().getSquareList().indexOf(nextSquare));
				System.out.println();
			} else {
				System.out.println();
				System.out.println("DICE IS ODD ROLLED, PLAYER IS MOVING ON IN ITS CURRENT TRACK");
				//regular addition of currentIndex and totalFaceValue
				nextSquareIndex = MovementHandler.getInstance().handleNextSquare(currentSquareIndex, currentPlayer.getDirection());
				System.out.println("NEXT SQUARE INDEX HASS BEEN DETERMINED: " + nextSquareIndex);
				Square nextSquare =  getBoard().getSquareList().get(nextSquareIndex);
				System.out.println("NEXT SQUARE IN THE ORIGINAL TRACK ACCORDING TO NEW INDEX: " + nextSquare.getName()+ " (" + nextSquare.getX() + "," + nextSquare.getY() + ")" + " index: " +  getBoard().getSquareList().indexOf(nextSquare));
				System.out.println();
			}
			
			
		} else {
			System.out.println();
			System.out.println("CURRENT SQUARE IS A REGULAR SQUARE");
			nextSquareIndex = MovementHandler.getInstance().handleNextSquare(currentSquareIndex, currentPlayer.getDirection());
			System.out.println("NEXT SQUARE INDEX HASS BEEN DETERMINED: " + nextSquareIndex);
			Square nextSquare =  getBoard().getSquareList().get(nextSquareIndex);
			System.out.println("NEXT SQUARE IN THE ORIGINAL TRACK ACCORDING TO NEW INDEX: " + nextSquare.getName()+ " (" + nextSquare.getX() + "," + nextSquare.getY() + ")" + " index: " +  getBoard().getSquareList().indexOf(nextSquare));
			System.out.println();
		}
		
		
		
		for (int i = 1; i < totalFaceValue; i++) {
			System.out.println();
			System.out.println("PLAYER START MOVING THROUGH SQUARES");
			Square newLocation = getBoard().getSquareList().get(nextSquareIndex);
			System.out.println("NEW TEMP LOCATION: ");
			teleportPlayer(currentPlayer, initialSquare, newLocation, nextSquareIndex);
			
			
			
			System.out.println("TELEPORTING PLAYER TO " + newLocation.getName() + " (" + newLocation.getX() + "," + newLocation.getY() + ")" + " index: " +  getBoard().getSquareList().indexOf(newLocation));
			System.out.println();
			
 
			if (newLocation instanceof Passable && i != totalFaceValue) {
				System.out.println("PLAYER PASSED A PASSABLE SQUARE: " + newLocation.getName() + " (" + newLocation.getX() + "," + newLocation.getY() + ")" + " index: " +  getBoard().getSquareList().indexOf(newLocation));
				((Passable) newLocation).passedBy();

			}

			if (newLocation instanceof RailroadSquare && totalFaceValue % 2 == 0) {
				System.out.println("PLAYER PASSED A RAILROAD SQUARE AND DICE IS DOUBLE ROLLED. CHANGING TRACK...");
				nextSquareIndex = MovementHandler.getInstance().handleRailRoadSquare(nextSquareIndex,
						currentPlayer.getDirection());
				System.out.println("NEXT SQUARE INDEX HASS BEEN DETERMINED: " + nextSquareIndex);
				Square nextSquare =  getBoard().getSquareList().get(nextSquareIndex);
				System.out.println("NEXT SQUARE IN THE OTHER TRACK ACCORDING TO NEW INDEX: " + nextSquare.getName()+ " (" + nextSquare.getX() + "," + nextSquare.getY() + ")" + " index: " +  getBoard().getSquareList().indexOf(nextSquare));
				
			} else {
				System.out.println("PLAYER PASSED A regular SQUARE. CONTINUING ON THE SAME TRACK...");
				nextSquareIndex = MovementHandler.getInstance().handleNextSquare(nextSquareIndex,
						currentPlayer.getDirection());
				Square nextSquare =  getBoard().getSquareList().get(nextSquareIndex);
				System.out.println("NEXT SQUARE INDEX HASS BEEN DETERMINED: " + nextSquareIndex);
				System.out.println("NEXT SQUARE IN THE OTHER TRACK ACCORDING TO NEW INDEX: " + nextSquare.getName()+ " (" + nextSquare.getX() + "," + nextSquare.getY() + ")" + " index: " +  getBoard().getSquareList().indexOf(nextSquare));
				
			}
		}
		
		
		System.out.println("FINAL SQUARE INDEX: " + nextSquareIndex);

		Square landedSquare = getBoard().getSquareList().get(nextSquareIndex);
		System.out.println("LANDED SQUARE : "+ landedSquare.getName()+ " (" + landedSquare.getX() + "," + landedSquare.getY() + ")" + " index: " +  getBoard().getSquareList().indexOf(landedSquare));
		currentPlayer.setCurrentSquareIndex(nextSquareIndex);
		teleportPlayer(currentPlayer, initialSquare, landedSquare, nextSquareIndex);
		landedSquare.landedOn();
		Logger.getInstance().notifyAll(currentPlayer.getName() + " landed on " + landedSquare.getName());
		System.out.println("-------------------------MOVE ENDED-----------------------------");
	}
	


	//for bus icon and mr monopoly
	public static void moveWithBusIcon(Player currentPlayer, int totalFaceValue) throws InterruptedException {
		int currentSquareIndex = currentPlayer.getCurrentSquareIndex();
		Square initialSquare = board.getSquareList().get(currentSquareIndex);
		int nextSquareIndex;
		if(getBoard().getSquareList().get(currentSquareIndex) instanceof RailroadSquare) {
			if(totalFaceValue % 2 == 0) { //if dice is rolled double, change the way
				//in this function, look at the indexes and return the next square index in the other cirlce.
				nextSquareIndex = MovementHandler.getInstance().handleRailRoadSquare(currentSquareIndex, currentPlayer.getDirection());
			} else {
				nextSquareIndex = MovementHandler.getInstance().handleNextSquare(currentSquareIndex, currentPlayer.getDirection());
			}
		} else {
			nextSquareIndex = MovementHandler.getInstance().handleNextSquare(currentSquareIndex, currentPlayer.getDirection());
		}
		while(true) {
			Square newLocation = getBoard().getSquareList().get(nextSquareIndex);
			if (newLocation instanceof Passable) {
				((Passable) newLocation).passedBy();
			}
			if (newLocation instanceof CommunityChestSquare || newLocation instanceof ChanceSquare) break;
			nextSquareIndex = MovementHandler.getInstance().handleNextSquare(nextSquareIndex,
					currentPlayer.getDirection());

		}
		Square landedSquare = getBoard().getSquareList().get(nextSquareIndex);
		currentPlayer.setCurrentSquareIndex(nextSquareIndex);
		teleportPlayer(currentPlayer, initialSquare, landedSquare, nextSquareIndex);
		landedSquare.landedOn();
		Logger.getInstance().notifyAll(currentPlayer.getName() + " landed on " + landedSquare.getName());
//		allowCurrentPlayerToEndTurn();
	}
	

	
	public static void moveWithMrMonopoly(Player currentPlayer, int totalFaceValue) throws InterruptedException {
		int currentSquareIndex = currentPlayer.getCurrentSquareIndex();
		Square initialSquare = board.getSquareList().get(currentSquareIndex);
//		Square prevSquare = board.getSquareList().get(currentSquareIndex);

		int nextSquareIndex;
		
		if(getBoard().getSquareList().get(currentSquareIndex) instanceof RailroadSquare) {
			System.out.println("CURRENT SQUARE IS A RAILROAD SQUARE");
			if(totalFaceValue % 2 == 0) { //if dice is rolled double, change the way
				nextSquareIndex = MovementHandler.getInstance().handleRailRoadSquare(currentSquareIndex, currentPlayer.getDirection());
			} else {
				nextSquareIndex = MovementHandler.getInstance().handleNextSquare(currentSquareIndex, currentPlayer.getDirection());
			}
		} else {
			nextSquareIndex = MovementHandler.getInstance().handleNextSquare(currentSquareIndex, currentPlayer.getDirection());
		}
		
		Square nextSquare =  getBoard().getSquareList().get(nextSquareIndex);

		
		while (!initialSquare.equals(nextSquare)) {
			Square newLocation = getBoard().getSquareList().get(nextSquareIndex);
			if (newLocation instanceof RailroadSquare && !((RailroadSquare)newLocation).isOwned()) break;
			if (newLocation instanceof DeedSquare && !((DeedSquare)newLocation).isOwned()) break;
			if (newLocation instanceof UtilitySquare && !((UtilitySquare)newLocation).isOwned()) break;
			if (newLocation instanceof Passable ) {
				((Passable) newLocation).passedBy();
			}
			if (newLocation instanceof RailroadSquare && totalFaceValue % 2 == 0) {
				nextSquareIndex = MovementHandler.getInstance().handleRailRoadSquare(nextSquareIndex,
						currentPlayer.getDirection());
			} else {
				nextSquareIndex = MovementHandler.getInstance().handleNextSquare(nextSquareIndex,
						currentPlayer.getDirection());
			}
			if (newLocation instanceof PayDaySquare) {
				((PayDaySquare) newLocation).landedWithMonop();
			}
			nextSquare = getBoard().getSquareList().get(nextSquareIndex);
		}
		
		Square landedSquare = getBoard().getSquareList().get(nextSquareIndex);
		currentPlayer.setCurrentSquareIndex(nextSquareIndex);
		teleportPlayer(currentPlayer, initialSquare, landedSquare, nextSquareIndex);
		landedSquare.landedOn();
		Logger.getInstance().notifyAll(currentPlayer.getName() + " landed on " + landedSquare.getName());
//		allowCurrentPlayerToEndTurn();
	}
	
	
	
	
	
	
	
	
	
	
	public static void handleJail() {
		
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		
		if(currentPlayer.jailRemaining()>1) {
			if (getCup().isDouble()) {
				currentPlayer.setInJail(0);
				Logger.getInstance().notifyAll(currentPlayer.getName() + " is out of jail.");
			} else {
				Logger.getInstance().notifyAll(currentPlayer.getName() + " is still in jail.");
				currentPlayer.decrementInJail();
				//end turn
			}
		}else {
			currentPlayer.decreaseMoney(50);
		}
	}
	
	public static void allowCurrentPlayerToBuy() {
		
		Facade.getInstance().allowCurrentPlayerToBuy();
	
		
		
	}
	
	

	public static boolean isPropertyOwned(DeedSquare d1) {
		
		boolean isOwned = false;
		for(Player p : MonopolyGameController.getPlayersList()) {
			
			for(Square property: p.getProperties()) {
				
				if(property.getName() == d1.getName()) {
					
					isOwned = true;
					break;
				}
			}
			
			if(isOwned) {
				break;
			}
		}
	
		return isOwned;
	}
	
	//LOAD AND SAVE ACTIONS
	
	public static void loadGame(String chosenFileName) {
		MonopolyGameController.getInstance();
		MonopolyGameController.saveLoadHandler.load(chosenFileName);
		NetworkController.getInstance().loadEvent(chosenFileName);
		
	}
	
	public static void loadGameWithoutNetwork(String chosenFileName) {
		MonopolyGameController.getInstance();
		MonopolyGameController.saveLoadHandler.load(chosenFileName);
		
	}
	
	public static void saveGame(String wannaBeFileName) {
		MonopolyGameController.getInstance();
		MonopolyGameController.saveLoadHandler.save(pawnNames, players, cup, deck, pawns, pool,wannaBeFileName);
		NetworkController.getInstance().saveEvent(wannaBeFileName);
	}
	
	public static void saveGameWithoutNetwork(String wannaBeFileName) {
		MonopolyGameController.getInstance();
		MonopolyGameController.saveLoadHandler.save(pawnNames, players, cup, deck, pawns, pool,wannaBeFileName);
		
	}
	
	public static void addSavedGame(Object savedGameObject, String fileName) {
		saveMap.put(fileName, savedGameObject);
	}
	
	public static void onSaveEvent(Object savedGameObject, String fileName) {
		addSavedGame(savedGameObject,fileName);
		
		
	}
	
	public static HashMap<String, Object> getSaveMap(){
		return saveMap;
	}


	public static ArrayList<Player> getPlayers() {
		return MonopolyGameController.players;
		
	}


	public static ArrayList<Pawn> getPawns() {
		return MonopolyGameController.pawns;
		
	}
	
	public static void setBoard(Board b) {
	 MonopolyGameController.board = b;
	}


	public void pauseGame() {
		
		NetworkController.getInstance().pauseEvent();
		
	}
	
	public void pauseGameWithoutNetwork() {
		
		Facade.getInstance().switchGameToPauseState();
		
	}


	public void resumeGame() {
		Facade.getInstance().switchGameToResumeState();
		NetworkController.getInstance().resumeEvent();
	}
	
	public void resumeGameWithoutNetwork() {
		
		Facade.getInstance().switchGameToResumeState();
		
	}


	
	
	public static MonopolyGameController getInstance() {

		if (monopolyGameController == null) {
		
			monopolyGameController = new MonopolyGameController();
			
		}

		return monopolyGameController;
	}

	public static void myTurn() {
		
		//Facade.getInstance().switchToMyTurnState();
		
	}




	
	public void startTheGameButtonPressed(String playerName) {
		
		if(getCurrentPlayer().getName().equals(playerName)) {
			
			Facade.getInstance().switchButtonsToStartStateForPlayerInTurn();
			
		} else {
			
			Facade.getInstance().switchButtonsToStartStateForPlayerNotInTurn();
			//Facade.getInstance().switchButtonsToStartStateForPlayerInTurn();
		}
		
	}


	public static void rollDiceButtonPressed() throws InterruptedException {
		
		rollDice();
		Facade.getInstance().switchButtonsToAfterRollDiceState();
		Facade.getInstance().startRollDiceAnimation();
		
	}


 






	public static void yourTurnMessageHasReceived() {
		
		Facade.getInstance().switchButtonsToPlayerInTurnState();
		
		updatePlayerScreen();		
	}



	public static void updatePlayerScreen() {
		Facade.getInstance().updatePlayerScreen();
	}


	public void rollDiceAnimationWithoutNetwork(int firstVal, int secondVal, int thirdVal) {
		ArrayList<FaceVal> results = new ArrayList<FaceVal>();
		
		results.add(FaceVal.fromIntegerToFaceVal(firstVal));
		results.add(FaceVal.fromIntegerToFaceVal(secondVal));
		results.add(FaceVal.fromIntegerToFaceVal(thirdVal));
		getCup().setResults(results);
		Facade.getInstance().startRollDiceAnimation();
		
	}

	
	

	public void buyButtonPressed() {
		
		int currentSqIndex = MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		
		MonopolyGameController.getCurrentPlayer().buy(currentSquare);
		Facade.getInstance().switchButtonsToAfterBuyState();
		NetworkController.getInstance().buyEvent();
		Facade.getInstance().showPlayerStatus();
	}
	
	
	public  void buyButtonPressedVirtually() {
		int currentSqIndex = MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		
		MonopolyGameController.getCurrentPlayer().buy(currentSquare);
		Facade.getInstance().showPlayerStatus();
	}


	public void disableInteractions() {
		Facade.getInstance().disableInteractions();
		
	}
	
	public void payRentButtonPressed() {
		int currentSqIndex = MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		MonopolyGameController.getCurrentPlayer().payRent(currentSquare);
		Facade.getInstance().showPlayerStatus();
		Facade.getInstance().switchButtonsToAfterRentState();
		NetworkController.getInstance().rentEvent(currentSqIndex);
	}





	public void payRentButtonPressedVirtually(int squareIndex) {
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(squareIndex);
		MonopolyGameController.getCurrentPlayer().payRent(currentSquare);
		Facade.getInstance().showPlayerStatus();
	}


	public void useCardButtonPressed(String selectedCardName) {
		Player currentPlayer = 	getCurrentPlayer();
		
		if(useCardCounter == 0) {
			if(currentPlayer.getCards().isEmpty()) {
				Facade.getInstance().giveInvalidPressOfUseCardButtonError();	
				return;
			} else {		
				Logger.getInstance().notifyAll(currentPlayer.getName() + "; You can select the card you want to use, then press the \"Use Card\" button again.");
				useCardCounter ++;
				MonopolyGameController.updatePlayerScreen();
				return;
			}
		}
		
		else if(useCardCounter == 1) {
			Card cardToBeUsed = currentPlayer.getOwnedCardByName(selectedCardName);
			NetworkController.getInstance().useCardEvent(selectedCardName);
			cardToBeUsed.useCard();
			useCardCounter = 0;
			MonopolyGameController.updatePlayerScreen();
			return;
		}

	} 
	
	
	public void useCardWithoutNetwork(String selectedCardName) {
		Player currentPlayer = 	getCurrentPlayer();
		Card cardToBeUsed = currentPlayer.getOwnedCardByName(selectedCardName);
		cardToBeUsed.useCard();
	}
	

	
	
	public void usePulledCardOnChanceOrCommunitySquareWithoutNetwork(String pulledCardName) {
//		System.out.println("I am in the usePulledCardOnChanceOrCommunitySquareWithoutNetwork");
//		System.out.println("pulledCardName : " + pulledCardName);
//		MonopolyGameController.getInstance();
//		System.out.println("CurrentPlayer: " + currentPlayer.getName());
//		//Card pulledCard = currentPlayer.getOwnedCardByName(pulledCardName);
		
//		System.out.println("PulledCard as Object: " + pulledCard);
//		pulledCard.useCard();
//		System.out.println("Right after pullCard.useCard call");
		
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		Card pulledCard = getDeck().getCard(pulledCardName);
		
		if(!pulledCard.isDisposable()) {
			Logger.getInstance().notifyAll(currentPlayer.getName() + " pulled a storable card: " + pulledCard.getName());
			Logger.getInstance().notifyAll("Card will be stored in players card list.");
			currentPlayer.getCards().add(pulledCard);
			MonopolyGameController.updatePlayerScreen();
		}
		else {
			Logger.getInstance().notifyAll(currentPlayer.getName() + " pulled a disposible card: " + pulledCard.getName());
			pulledCard.useCard();
		}

	}
	



	public void mortgageButtonPressed() {
	

		if(mortgageButtonCounter == 0) {
			Facade.getInstance().riseDialog("Please Select Your Square To Be Mortgaged and Press the \"Mortgage Button\" Again.");
			mortgageButtonCounter++;	
		}
		
		else if (mortgageButtonCounter == 1) {
			mortgageButtonCounter = 0;
			String selectedSquareName = Facade.getInstance().getSelectedSquareNameFromUser();
			Square selectedSquare = getBoard().getSquare(selectedSquareName);
			
			if(selectedSquare instanceof DeedSquare) {
				
				((DeedSquare) selectedSquare).mortgage();				
				NetworkController.getInstance().mortgageEvent(selectedSquareName);
				
			} else {
				Facade.getInstance().riseDialog("Please Select a \"Deed\" Square for Mortgage");
				mortgageButtonCounter = 1;			
			}
			
		}
	

	}



	public void mortgageButtonPressedVirtually(String desiredSquareName) {
		
		Square selectedSquare = getBoard().getSquare(desiredSquareName);
		((DeedSquare) selectedSquare).mortgage();		
		
	}




	public void buildBuildingPressed() {

		if(buildBuildingButtonCounter == 0) {
			Facade.getInstance().riseDialog("Please Select Your Square To Build Building and Press the \"Build Building Button\" Again.");
			buildBuildingButtonCounter ++;
		}
		
		else if (buildBuildingButtonCounter == 1) {
			buildBuildingButtonCounter = 0;
			String selectedSquareName = Facade.getInstance().getSelectedSquareNameFromUser();
			Square selectedSquare = getBoard().getSquare(selectedSquareName);
			if(selectedSquare instanceof DeedSquare) {
				((DeedSquare) selectedSquare).upgrade();			
				NetworkController.getInstance().buildBuildingEvent(selectedSquareName);
				
			} else {
				Facade.getInstance().riseDialog("Please Select a \"Deed\" Square for Build Building");
				buildBuildingButtonCounter = 1;			
			}
			
		}

	}


	public void buildBuildingButtonPressedVirtually(String desiredSquareName) {
		Square selectedSquare = getBoard().getSquare(desiredSquareName);
		((DeedSquare) selectedSquare).upgrade();
	}


	public void botEndedSwitchMyTurnState() {
		Facade.getInstance().switchButtonsToPlayerInTurnState();
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
