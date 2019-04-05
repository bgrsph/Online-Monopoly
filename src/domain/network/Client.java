package domain.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import domain.ClientEventListener;
import domain.Logger;
import domain.MonopolyGameController;
import ui.MonopolyGameFrame;

public class Client extends Thread {

	private int portNumber;
	private String serverIP;
	private String name;
	private String pawnName;
	private ArrayList<ClientEventListener> clientEventListeners;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean firstTime = false;
	private static boolean IS_GAME_ENDED = false;
	private HashMap<String,String> playerNamesWithPawnImages;
	private LinkedHashMap<String,String> playerNamesWithPawnImagesLinked;
	private LinkedHashMap<String,String> playerNamesWithBotTypes;
	private boolean isHumanPlayer;
	private String botType;
	 
	public Client(boolean isHumanPlayer, String botType, String name, int portNumber, String serverIP, String pawnName) {
		super("Client");
		this.isHumanPlayer = isHumanPlayer;
		this.botType = botType;
		this.name = name;
		this.portNumber = portNumber;
		this.serverIP = serverIP;
		this.pawnName = pawnName;
		this.clientEventListeners = new ArrayList<ClientEventListener>();
		this.playerNamesWithPawnImages = new HashMap<String,String>();
		this.playerNamesWithPawnImagesLinked = new LinkedHashMap<String,String>();
		this.playerNamesWithBotTypes =  new LinkedHashMap<String,String>();
	}
	
	@Override
	public void run() {

		try {
			
			notifyServerAsNewClientCreated();
			
			while(!IS_GAME_ENDED) {
				communicateWithServer();
			}

			//TODO:Game Ended Stuff

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private void communicateWithServer() throws IOException, InterruptedException {
		while (true) {
 
			
			String fullMessageFromServer = in.readLine();
			
			if (fullMessageFromServer != null) {

				String[] messageParts = fullMessageFromServer.split("-");
				String actionMessageFromServer = messageParts[0];

				//Format: "YourTurn-senderName"
				if(actionMessageFromServer.equals("YourTurn")) {
					
					if(this.getClientName().equals(messageParts[1])) {
						MonopolyGameController.getInstance();
						MonopolyGameController.yourTurnMessageHasReceived();
					}
					
				}

				
				//Message Format: "startGame-NumberOfPlayers-{PlayerName-PawnImageName}*-serverIP"
				//TODO:New Message Format: "startGame-NumberOfPlayers-{isHuman-botType-PlayerName-PawnImageName}*-serverIP"
				else if (actionMessageFromServer.equals("startGame")) {
					
					System.out.println("Server sended Start Request...");
					System.out.println("Full Message: " + fullMessageFromServer);
					String numOfPlayerMessage = messageParts[1];
					int numberOfPlayers = Integer.parseInt(numOfPlayerMessage);
					System.out.println("Number of Players: " + numberOfPlayers);
					String serverIP = messageParts[messageParts.length - 1];
					System.out.println("Server IP: " + serverIP);

					for(int i = 2; i <= (numberOfPlayers * 4) - 2; i++) {
						
						boolean isHuman = Boolean.parseBoolean(messageParts[i]);
						String botType = messageParts[i+1];
						String playerName = messageParts[i+2];
						String pawnName =  messageParts[i+3].substring(0, 5).trim(); //TODO:
						i += 3;			
						System.out.println("Adding " + playerName + "-" + pawnName + "-" + botType);			
						this.playerNamesWithPawnImages.put(playerName, pawnName);
						this.playerNamesWithPawnImagesLinked.put(playerName, pawnName);
						this.playerNamesWithBotTypes.put(playerName, botType);
					}
					
					
					MonopolyGameController.getInstance(); 
					MonopolyGameController.initializeTheGame((HashMap<String,String>) playerNamesWithPawnImagesLinked, playerNamesWithBotTypes, numberOfPlayers, serverIP);
					System.out.println("Monopoly Game Controller has been initiated.");
					addClientEventListener(MonopolyGameFrame.getInstance());
					MonopolyGameFrame.getInstance().setTitle(this.getClientName());
					System.out.println("MonopolyGameFrame has been initiated.");	
					publishClientEvent("CloseStartApp");
					sendMessageToServer("ClientStarted", "");
					NetworkController.getInstance().addClient(this);
				}
				
				

				else if(actionMessageFromServer.equals("EndTurnWithoutNetwork")) {
					
					MonopolyGameController.getInstance();
					MonopolyGameController.nextTurnWithoutNetwork();
					//MonopolyGameController.nextTurnLocal();
				}
				
				
				//Format: "UseCard-cardName"
				else if(actionMessageFromServer.equals("UseCardWithoutNetwork")) {
					String cardName = messageParts[1];
					MonopolyGameController.getInstance().useCardWithoutNetwork(cardName);
				}
				
				
				else if(actionMessageFromServer.equals("PauseWithoutNetwork")) {
					
					MonopolyGameController.getInstance().pauseGameWithoutNetwork();
				}
				
				//HurricaneWithoutNetwork
				else if(actionMessageFromServer.equals("HurricaneWithoutNetwork")) {
					String type = messageParts[1];
					String color = messageParts[2];
					MonopolyGameController.handleHurricaneMakesLandFallCard(type, color);				
					
				}

				
				else if(actionMessageFromServer.equals("ResumeWithoutNetwork")) {
					
					MonopolyGameController.getInstance().resumeGameWithoutNetwork();
				}
				
				else if(actionMessageFromServer.equals("BuyWithoutNetwork")) {
					
					MonopolyGameController.getInstance().buyButtonPressedVirtually();
				}
				//BotEndedMoveSwitchToYourTurnStateWithoutNetwork
				else if(actionMessageFromServer.equals("BotEndedMoveSwitchToYourTurnStateWithoutNetwork")) {
					
					MonopolyGameController.getInstance().botEndedSwitchMyTurnState();
				}
				
				//usePulledCardOnChanceOrCommunitySquareWithoutNetwork
				else if(actionMessageFromServer.equals("usePulledCardOnChanceOrCommunitySquareWithoutNetwork")) {
					String cardName = messageParts[1];
					MonopolyGameController.getInstance().usePulledCardOnChanceOrCommunitySquareWithoutNetwork(cardName);
				}
				
				//Format: "RentWithoutNetwork-squareIndex"
				else if(actionMessageFromServer.equals("RentWithoutNetwork")) {
					int squareIndex = Integer.parseInt(messageParts[1]);
					MonopolyGameController.getInstance().payRentButtonPressedVirtually(squareIndex);
				}
				
				else if(actionMessageFromServer.equals("LoadWithoutNetwork")) {
					String fileName = messageParts[1];
					MonopolyGameController.getInstance();
					MonopolyGameController.loadGameWithoutNetwork(fileName);
				}
				
				else if(actionMessageFromServer.equals("SaveWithoutNetwork")) {
					String fileName = messageParts[1];
					MonopolyGameController.getInstance();
					MonopolyGameController.saveGameWithoutNetwork(fileName);
				}

				
				
				else if(actionMessageFromServer.equals("TriplesWithoutNetwork")) {
					String desiredSquareName = messageParts[1];
					MonopolyGameController.getInstance();
					MonopolyGameController.handleTriplesWithoutNetwork(desiredSquareName);
					
				}
				
				else if(actionMessageFromServer.equals("MortgageWithoutNetwork")) {
					String desiredSquareName = messageParts[1];
					MonopolyGameController.getInstance().mortgageButtonPressedVirtually(desiredSquareName);	
				}
				
				else if(actionMessageFromServer.equals("BuildBuildingWithoutNetwork")) {
					String desiredSquareName = messageParts[1];
					MonopolyGameController.getInstance().buildBuildingButtonPressedVirtually(desiredSquareName);
				} 
				
				
				//SpecialMoveWithoutNetwork
				else if(actionMessageFromServer.equals("SpecialMoveWithoutNetwork")) {
					int faceValue = Integer.parseInt(messageParts[1]);
					MonopolyGameController.getInstance().specialMoveButtonPressedVirtually(faceValue);
					
				}
				
				//Format: "MoveWithoutNetwork-totalFaceVal"
				else if(actionMessageFromServer.equals("DisableInteractions")) {
					System.out.println("Client disables interactions");
					MonopolyGameController.getInstance().disableInteractions();
				
					
				}
				
				//Format: "RollDice-val1-val2-val3"
				else if(actionMessageFromServer.equals("RollDiceWithoutNetwork")) {
					int firstVal = Integer.parseInt(messageParts[1]);
					int secondVal = Integer.parseInt(messageParts[2]);
					int thirdVal = Integer.parseInt(messageParts[3]);
					
					MonopolyGameController.getInstance();
					MonopolyGameController.rollDiceWithoutNetwork(firstVal, secondVal, thirdVal);
					
				}
				
				
				else if (actionMessageFromServer.equals("Notification")) {

					String notificationMessageFromServer = messageParts[1];
					System.out.println("Client " + this.name + " received notification from server: "
							+ notificationMessageFromServer);
				}
				
				else if (actionMessageFromServer.equals("Log")) {

					String logMessageFromServer = messageParts[1];
					Logger.getInstance().notifyAll(logMessageFromServer);		
				}
				

				
				else {
					System.out.println("Client received unknown message from client: " + fullMessageFromServer);
				}
								
									
				

			}

		}

	}

	
	
	//Format: "NewClient-isHuman-botType-name-pawnName-senderClient
	public void notifyServerAsNewClientCreated() throws IOException {

		if (this.firstTime) {
			
			out.println("NewClient" + "-" + Boolean.toString(this.isHumanPlayer) + "-" + this.botType + "-" + this.name + "-" + this.pawnName + "-" + this );
			//out.println("NewClient" + "-" + this.name + "-" + this.pawnName + this);
			this.firstTime = false;
		}

	}

	public void connectToServer() {

		try {
			// System.out.println("Client connecting at "+ portNumber);
			socket = new Socket(serverIP, portNumber);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.firstTime = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void startConnection() {

		this.connectToServer();
		this.start();	
	}

	public void sendMessageToServer(String action, String message) {
		StringBuilder fullMessage = new StringBuilder(action);
		fullMessage.append("-" + message);
		out.println(fullMessage.toString());
	}

	public void sendMessageToGUI(String action, String message) {

		StringBuilder fullMessage = new StringBuilder(action);
		fullMessage.append("-" + message);
		this.publishClientEvent(fullMessage.toString());

	}

	public void addClientEventListener(ClientEventListener clientApp) {
		clientEventListeners.add(clientApp);
	}

	private void publishClientEvent(String message) {

		for (ClientEventListener listener : clientEventListeners) {

			listener.onClientEvent(message);
		}
	}

	public String getClientName() {
		return this.name;
	}
	
	public String getPawnName() {
		return this.pawnName;
	}

}
