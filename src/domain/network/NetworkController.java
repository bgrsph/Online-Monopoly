package domain.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import domain.FaceVal;
import domain.Player;
import ui.networkApps.ServerApp;

public class NetworkController {

	private SingleThreadServer server;


	public boolean isClientNetworkController;
	public boolean isServerNetworkController;
	Client client;
	private int numberOfPlayers;
	private int portNumber;
	private String serverIP; 
	private HashMap<String,String> clientsWithPawnImageNames;
	private LinkedHashMap<String,String> clientsWithPawnImageNamesLinked;
	private LinkedHashMap<String,String> clientNamesWithBotTypes;
	
	private static NetworkController networkContollerInstance;

	public static NetworkController getInstance() {

		if (networkContollerInstance == null) {
			System.out.println("NetworkController Instance Was Created");
			networkContollerInstance = new NetworkController();
			return networkContollerInstance;
		}
 
		else {
			return networkContollerInstance;
		}
	}

	
	public void initializeArgumentsAndStartServer(int numberOfPlayers, String serverIP, int portNumber, ServerApp app) throws IOException {

		this.numberOfPlayers = numberOfPlayers;

		this.serverIP = serverIP;

		this.portNumber = portNumber;

		this.server = new SingleThreadServer(numberOfPlayers, serverIP, portNumber);
		
		this.clientsWithPawnImageNames = new HashMap<String,String>();
		clientsWithPawnImageNamesLinked = new LinkedHashMap<String,String>();
		clientNamesWithBotTypes = new LinkedHashMap<String,String>();
		this.isServerNetworkController = true;
		this.isClientNetworkController = false;
		System.out.println("SingleThreadServer Object: " + server);
		System.out.println("NetworkController has been started.");
		System.out.println("Number of Players: " + numberOfPlayers);
		System.out.println("Server IP: " + serverIP);
		System.out.println("Port Number " + portNumber);
		
		server.addServerEventListener(app);
		server.connectClients();
		server.start();
		
	}
	
	public void updateClient(Boolean isHuman, String botType, String clientName, String pawnImageName) {
		
		if(this.isServerNetworkController) {
			
			this.clientsWithPawnImageNames.put(clientName, pawnImageName);
			this.clientsWithPawnImageNamesLinked.put(clientName, pawnImageName);
			this.clientNamesWithBotTypes.put(clientName,botType);
			System.out.println("NetworkController is updated with a new client: " + clientName + "-" + pawnImageName + "-" + botType);
		}

	}
	
	
	
	public SingleThreadServer getServer() {
		if(this.isServerNetworkController) {
			return server;
		} else {
			return null;
		}	
	}

	
	
	public HashMap<String, String> getClientNamesWithBotTypes() {
		return (HashMap<String,String>) this.clientNamesWithBotTypes;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}


	public int getPortNumber() {
		return portNumber;
	}


	public String getServerIP() {
		return serverIP;
	}


	public HashMap<String, String> getClientsWithPawnImageNames() {
		return (HashMap<String,String>) this.clientsWithPawnImageNamesLinked;
	}
 

	public void addClient(Client c) {
			this.isClientNetworkController = true;
			this.isServerNetworkController = false;
			this.client = c;
	}


	//Format: "move-currentPlayerName-totalFaceValue-senderName"
	public void moveEvent(Player currentPlayer, int totalFaceValue) {
		client.sendMessageToServer("Move", currentPlayer.getName() + "-" + totalFaceValue + "-" + client.getClientName());
	}


	public void nextTurnEvent(String oldPlayerName) {
		client.sendMessageToServer("EndTurn", oldPlayerName);
	}


	//Format: "RollDiceAnimation-firstVal-secondVal-thirdVal"
	public void rollDiceAnimationEvent(ArrayList<FaceVal> results) {
		
		int firstVal = results.get(0).getValue();
		int secondVal = results.get(1).getValue();
		int thirdVal = results.get(2).getValue();
		client.sendMessageToServer("RollDiceAnimation", firstVal + "-" + secondVal + "-" + thirdVal);
		
	}


	public void logEvent(String notification) {
		client.sendMessageToServer("Log", notification);
		
	}


	public void buyEvent() {
		client.sendMessageToServer("Buy", "");
		
	}


	public void disableOtherClientsInteractions() {
		
		client.sendMessageToServer("DisableInteractions", "");
	}


	//Format: "Load-fileName"
	public void loadEvent(String chosenFileName) {
		client.sendMessageToServer("Load", chosenFileName);
		
	}


	public void saveEvent(String wannaBeFileName) {
		client.sendMessageToServer("Save", wannaBeFileName);
		
	}


	public void pauseEvent() {
		client.sendMessageToServer("Pause", "");
		
	}


	public void resumeEvent() {
		client.sendMessageToServer("Resume", "");
		
	}

	//Format: "PayRent-squareIndex"
	public void rentEvent(int currentSqIndex) {
		client.sendMessageToServer("Rent", Integer.toString(currentSqIndex));
		
	}


	//Format: "RollDice-val1-val2-val3"
	public void rollDiceEvent(ArrayList<FaceVal> results) {
		
		String val1 = Integer.toString(results.get(0).getValue());
		String val2 = Integer.toString(results.get(1).getValue());
		String val3 = Integer.toString(results.get(2).getValue());
		
		client.sendMessageToServer("RollDice", val1 + "-" + val2 + "-" + val3);
	}


	//Format: "UseCard-cardName"
	public void useCardEvent(String selectedCardName) {	
		client.sendMessageToServer("UseCard", selectedCardName);	
	}

	//Format: "CardPulledOnChanceOrCommunitySquare-cardName"
	public void cardPulledInChanceOrCommunitySquareEvent(String name) {	
		client.sendMessageToServer("CardPulledOnChanceOrCommunitySquare", name);	
		
	}

	//Format: "triples-cardName"
	public void handleTriplesEvent(String desiredSquareName) {
		client.sendMessageToServer("Triples", desiredSquareName);	
	}


	public void specialMoveEvent(int faceValue) {
		client.sendMessageToServer("SpecialMove", Integer.toString(faceValue));
		
	}


	public void mortgageEvent(String selectedSquareName) {
		client.sendMessageToServer("Mortgage", selectedSquareName);
		
	}


	public void buildBuildingEvent(String selectedSquareName) {
		client.sendMessageToServer("BuildBuilding", selectedSquareName);
		
	}


	public void botEndedMoveEvent() {
		client.sendMessageToServer("BotEndedMove", "");
		
	}


	public void hurricaneEvent(String squareType, String selectedColor) {
		client.sendMessageToServer("Hurricane", squareType + "-" + selectedColor);
		
	}


	
	
	

	

	

	
	
	
	
	

	




}
