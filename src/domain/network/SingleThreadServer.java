package domain.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import domain.ServerEventListener;
import ui.networkApps.ServerApp;

public class SingleThreadServer extends Thread {

	private ServerSocket serverSocket;
	private ArrayList<Socket> clientSockets;
	private ArrayList<BufferedReader> inputStreams;
	private ArrayList<PrintWriter> outputStreams;
	private int numberOfPlayers;
	private String serverIP;
	private int portNumber;
	private ArrayList<String> clientNames;
	private ArrayList<String> pawnImageNames;
	private static int NUMBER_OF_CLIENTS_ADDED = 0;
	private static boolean ARE_ALL_CLIENTS_ADDED = false;
	private static boolean IS_GAME_ENDED = false;
	private ArrayList<ServerEventListener> serverEventListeners;
 
	
	public SingleThreadServer(int numberOfPlayers, String serverIP, int portNumber) {
		clientSockets = new ArrayList<Socket>();
		inputStreams = new ArrayList<BufferedReader>();
		outputStreams = new ArrayList<PrintWriter>();
		clientNames = new ArrayList<String>();
		pawnImageNames = new ArrayList<String>();
		this.numberOfPlayers = numberOfPlayers;
		this.serverIP = serverIP;
		this.portNumber = portNumber;
		this.serverEventListeners = new ArrayList<ServerEventListener>();
		System.out.println("SingleThreadServer has been created...");

	} 

	
	public void connectClients() throws IOException {

		System.out.println("SingleThreadServer tries to connect clients....");
		serverSocket = new ServerSocket(this.portNumber);

		for (int i = 0; i < this.numberOfPlayers; i++) {
			System.out.println("Waiting for Client" + i);
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client" + i + " has connected successfully");
			clientSockets.add(clientSocket);
			outputStreams.add(new PrintWriter(clientSockets.get(i).getOutputStream(), true));
			inputStreams.add(new BufferedReader(new InputStreamReader(clientSockets.get(i).getInputStream())));

		}

	}

	
	
	
	public void sendMessageToAllClients(String action,String msg) {

		for (PrintWriter out : this.outputStreams) {
			out.println(action + "-" + msg);
			out.flush();
		}
	
	}


	
	public void sendMessageToAllClientsExceptOne(String clientName, String message) {
		
		int clientIndex = clientNames.indexOf(clientName);
		
		for(int i = 0; i < outputStreams.size(); i++) {
			
			if(i != clientIndex) {
				outputStreams.get(i).println(message);
				outputStreams.get(i).flush();
			}
			
		}
	}
	
	
	


	public void sendMessageToAClient(String clientName, String message) {

		int clientIndex = clientNames.indexOf(clientName);
		outputStreams.get(clientIndex).println(message);
	}

	public void run() {

		try {

			listenForNewClients();
			
			if(ARE_ALL_CLIENTS_ADDED) {
				sendStartRequestToAllClients();
				ARE_ALL_CLIENTS_ADDED = false;
			}
			
			while (!IS_GAME_ENDED) {

				communicateWithClients();

			}

		} catch (ClassNotFoundException | IOException e) {

		}

	}
	
	
	
	
	

	
	//New Message Format: "startGame-NumberOfPlayers-{isHuman-botType-PlayerName-PawnImageName}*-serverIP"
	private void sendStartRequestToAllClients() {
		System.out.println("Sending Start Request To Clients...");
		int numberOfPlayers = NetworkController.getInstance().getNumberOfPlayers();
		HashMap <String,String> playerNamesWithPawnImageNames = NetworkController.getInstance().getClientsWithPawnImageNames();
		HashMap<String,String> playerNamesWithBotTypes = NetworkController.getInstance().getClientNamesWithBotTypes();
		String serverIPAddress = NetworkController.getInstance().getServerIP();
		System.out.println("Sending start request to clients with hashmap: " + playerNamesWithPawnImageNames.toString() );
		System.out.println("Sending start request to clients with hashmap2: " + playerNamesWithBotTypes.toString() );
		
		for (int i = 0; i < numberOfPlayers; i++) {
			
			PrintWriter out = outputStreams.get(i);
			StringBuilder startRequestMessage = new StringBuilder("startGame");
			startRequestMessage.append("-" + numberOfPlayers);
			
			//startGame-numOfPlayers
			startRequestMessage = new StringBuilder(startRequestMessage.toString().trim());
			
			for(String playerName: playerNamesWithPawnImageNames.keySet()) {
				
				String botType = playerNamesWithBotTypes.get(playerName);
				if(botType.equals("HumanPlayer")) {
					
					startRequestMessage.append("-" + true);
				}	
				else {
					startRequestMessage.append("-" + false);
				}
				
				
				
				startRequestMessage.append("-" + botType + "-" + playerName + "-" + playerNamesWithPawnImageNames.get(playerName));
				

			}
			
			startRequestMessage.append("-" + serverIPAddress);
			out.println(startRequestMessage.toString());
			out.flush();
		}
		
	}

	
	
	// this.sendMessageToAllClientsExceptOne(clientName, fullMessageFromClient);
	private void communicateWithClients() throws IOException {

		for (int i = 0; i < numberOfPlayers; i++) {
			BufferedReader in = inputStreams.get(i);
			PrintWriter out = outputStreams.get(i);
			String fullMessageFromClient;
			String clientInCommunication = clientNames.get(i);
			out.println("YourTurn" + "-" + clientInCommunication);
			System.out.println("CLIENT IN TURN: " + clientInCommunication);

			while (true) {
				fullMessageFromClient = in.readLine();

				if (fullMessageFromClient != null) {
					System.out.println("NEW MESSAGE FROM CLIENT: " + fullMessageFromClient);
					String[] messageParts = fullMessageFromClient.split("-");
					String actionMessageFromClient = messageParts[0];

					if (actionMessageFromClient.equals("EndTurn")) {
						System.out.println("ClIENT " + clientInCommunication + " HAS ENDED ITS TURN.");
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "EndTurnWithoutNetwork");
						System.out.println("BREAKING THE WHILE LOOP FOR NEXT PLAYER...");
						break;
					}
					
					else if(actionMessageFromClient.equals("Log")) {
						this.sendMessageToAllClientsExceptOne(clientInCommunication, fullMessageFromClient);
						
					}
					//BotEndedMove
					else if(actionMessageFromClient.equals("BotEndedMove")) {
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "BotEndedMoveSwitchToYourTurnStateWithoutNetwork");
						
					}
					
					else if(actionMessageFromClient.equals("Pause")) {
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "PauseWithoutNetwork" + "-");
						
					}
					
					else if(actionMessageFromClient.equals("Resume")) {
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "ResumeWithoutNetwork" + "-");
						
					}
					
					//Hurricane
					else if(actionMessageFromClient.equals("Hurricane")) {
						String type = messageParts[1];
						String color = messageParts[2];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "HurricaneWithoutNetwork" + "-" + type + "-" + color);
						
					}
					
					else if(actionMessageFromClient.equals("Triples")) {
						String desiredSquareName = messageParts[1];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "TriplesWithoutNetwork" + "-" + desiredSquareName);
						
					}
					
					else if(actionMessageFromClient.equals("Mortgage")) {
						String desiredSquareName = messageParts[1];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "MortgageWithoutNetwork" + "-" + desiredSquareName);
						
					}
					
					else if(actionMessageFromClient.equals("BuildBuilding")) {
						String desiredSquareName = messageParts[1];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "BuildBuildingWithoutNetwork" + "-" + desiredSquareName);
						
					}
					
					
					//SpecialMove
					else if(actionMessageFromClient.equals("SpecialMove")) {
						String faceVal = messageParts[1];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "SpecialMoveWithoutNetwork" + "-" + faceVal);
						
					}
					
					
					//Format: "CardPulledOnChanceOrCommunitySquare-cardName"
					else if(actionMessageFromClient.equals("CardPulledOnChanceOrCommunitySquare")) {
						String cardName = messageParts[1];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "usePulledCardOnChanceOrCommunitySquareWithoutNetwork" + "-" + cardName);
						
					}
					
					
					//Format: "Load-fileName"
					else if(actionMessageFromClient.equals("Load")) {
						String fileName =messageParts[1];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "LoadWithoutNetwork" + "-" + fileName);
						
					}
					//Format: "Save-fileName"
					else if(actionMessageFromClient.equals("Save")) {
						String fileName =messageParts[1];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "SaveWithoutNetwork" + "-" + fileName);
						
					}
					
					
					
					else if(actionMessageFromClient.equals("Buy")) {
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "BuyWithoutNetwork");
						
					}
					
					//Format: "RentWithoutNetwork-squareIndex"
					else if(actionMessageFromClient.equals("Rent")) {
						String squareIndex = messageParts[1];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "RentWithoutNetwork" + "-" + squareIndex);
						
					}
					
					//Format: "UseCard-cardName"
					else if(actionMessageFromClient.equals("Rent")) {
						String cardName = messageParts[1];
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "UseCardWithoutNetwork" + "-" + cardName);
						
					}
					
					else if(actionMessageFromClient.equals("DisableInteractions")) {
		
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "DisableInteractions" + "-");
						
					}
					
				
					//Format: "RollDice-val1-val2-val3"
					else if (actionMessageFromClient.equals("RollDice")) {
						
						String val1 = messageParts[1];
						String val2 = messageParts[2];
						String val3 = messageParts[3];
						
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "RollDiceWithoutNetwork" + "-" + val1 + "-" + val2 + "-" + val3);
						
						
					}
					
					// Format: "move-currentPlayerName-totalFaceValue-senderName"
					else if (actionMessageFromClient.equals("Move")) {
						int totalFaceValue = Integer.parseInt(messageParts[2]);
						this.sendMessageToAllClientsExceptOne(clientInCommunication,
								"MoveWithoutNetwork" + "-" + totalFaceValue);
					}
					
					
					//Format: "RollDiceAnimation-firstVal-secondVal-thirdVal"
					else if(actionMessageFromClient.equals("RollDiceAnimation")) {
						int firstVal = Integer.parseInt(messageParts[1]);
						int secondVal = Integer.parseInt(messageParts[2]);
						int thirdVal = Integer.parseInt(messageParts[3]);
						this.sendMessageToAllClientsExceptOne(clientInCommunication, "RollDiceAnimationWithoutNetwork" + "-" + firstVal + "-" + secondVal + "-" + thirdVal );
					}

				}
			}
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private void listenForNewClients() throws IOException, ClassNotFoundException {
		for (int i = 0; i < numberOfPlayers; i++) {

			BufferedReader in = inputStreams.get(i);
			PrintWriter out = outputStreams.get(i);
			String fullMessageFromClient = in.readLine();

			if (fullMessageFromClient != null) {

				String[] messageParts = fullMessageFromClient.split("-");
				String actionMessageFromClient = messageParts[0];

				
				//Format: "NewClient-isHuman-botType(or HumanPlayer)-name-pawnName-senderClient
				if (actionMessageFromClient.equals("NewClient")) {
					System.out.println("NEW CLIENT; FULL MESSAGE: " + fullMessageFromClient );
					Boolean isHuman = Boolean.parseBoolean(messageParts[1]);
					String botType = messageParts[2];
					String clientName = messageParts[3];
					String pawnImageName = messageParts[4];
				
					System.out.println("New Client has arrived to server:  Client Name and PawnName:  " + clientName
							+ "-" + pawnImageName);
					this.sendMessageToAllClients("Notification", "New Client has arrived to server:\" + clientName + \"-\" + pawnImageName");
					clientNames.add(i, clientName);
					pawnImageNames.add(i, pawnImageName);
					NetworkController.getInstance().updateClient(isHuman, botType, clientName, pawnImageName);

				}
			}

		}
		
		ARE_ALL_CLIENTS_ADDED = true;
		this.publishServerEvent("GameStarted");
	}
	
	public void publishServerEvent(String message) {
		for (ServerEventListener listener : serverEventListeners) {

			listener.onServerEvent(message);
		}
	}

	public void addServerEventListener(ServerApp app) {
		serverEventListeners.add((ServerEventListener) app);
		
	}

}
