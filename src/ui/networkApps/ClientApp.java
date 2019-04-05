package ui.networkApps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import domain.ClientEventListener;
import domain.network.Client;
import ui.MonopolyGameFrame;
import ui.PawnSelectionPanel;

public class ClientApp extends JFrame implements ActionListener, ClientEventListener{

	JPanel playerInfoPanel;
	JLabel playerNameLabel;
	JTextArea playerNameTextArea;
	JLabel serverIPLabel;
	JTextArea serverIPTextArea;
	JLabel portLabel;
	JTextArea portTextArea;
	JButton startButton;
	PawnSelectionPanel pawnPanel;
	JDialog errDialog;
	Client client;
	MonopolyGameFrame gameFrame;
	boolean isThisClientBot = false;
	
	
	JLabel isBotLabel;
	JButton isBotButton;
	
	JLabel selectBotTypeLabel;
	JComboBox<String> selectBotTypeCombo;
	
	


	public ClientApp() {
		super("MONOPOLY CLIENT");
		initGUI();

		this.setVisible(true);
	}
	
	
	public JTextArea getPlayerNameArea() {
		return this.playerNameTextArea;
	} 
	public JButton getButton() {
		return this.startButton;
	}

	
	public String getPlayerName() {
	
		return this.playerNameTextArea.getText().trim();
	}
	
	
	public String getServerIP() {
		return this.serverIPTextArea.getText();
	}
	
	
	
	public String getPawnName() {
		return this.pawnPanel.getSelectedPawnImageName();
	}
	
	public int getPortNumber() {
		return Integer.parseInt(this.portTextArea.getText());
	}
	
	
	
	public String getAllInfo() {
		
		return getPlayerName() + "\n" + getServerIP() + "\n" + getPawnName() + "\n" + getPortNumber();
	}
	

	

	public static void main(String[] args) {

		ClientApp cP = new ClientApp();

	}
	

	
	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		// this.getContentPane().setBackground(Color.decode("#BFDBAE"));
		this.setSize(500, 300);

		playerInfoPanel = new JPanel();
		playerInfoPanel.setLayout(new GridLayout(5, 2));
		playerInfoPanel.setBackground(Color.decode("#BFDBAE"));
		playerInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		playerNameLabel = new JLabel("Enter Your Name");
		playerNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(playerNameLabel);

		playerNameTextArea = new JTextArea();
		playerNameTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(playerNameTextArea);

		serverIPLabel = new JLabel("Enter Server IP");
		serverIPLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(serverIPLabel);

		serverIPTextArea = new JTextArea();
		serverIPTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		serverIPTextArea.setText("172.20.105.25");
		playerInfoPanel.add(serverIPTextArea);
		
		portLabel = new JLabel("Enter Port Number");
		portLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(portLabel);

		portTextArea = new JTextArea();
		portTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		portTextArea.setText("123");
		playerInfoPanel.add(portTextArea);
		
		
		
		isBotLabel = new JLabel("Is This Client A Bot?");
		isBotLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(isBotLabel);
		

		isBotButton = new JButton("Yes");
		isBotButton.addActionListener(this);
		isBotButton.setActionCommand("isBot");
		playerInfoPanel.add(isBotButton);
		
		
		
		
		selectBotTypeLabel = new JLabel("What Kind of Bot Would You Prefer?");
		selectBotTypeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(selectBotTypeLabel);
		
		
		selectBotTypeCombo = new JComboBox<String>();
		selectBotTypeCombo.addItem("IntelligentBot");
		selectBotTypeCombo.addItem("GreedyBot");
		selectBotTypeCombo.addItem("RandomBot");
		selectBotTypeCombo.setEditable(false);
		playerInfoPanel.add(selectBotTypeCombo);
		
		

		this.add(playerInfoPanel, BorderLayout.CENTER);

		startButton = new JButton("Start The Game");
		startButton.addActionListener(this);
		startButton.setActionCommand("startGame");
		
		this.add(startButton, BorderLayout.NORTH);
		
		pawnPanel = new PawnSelectionPanel();
		this.add(pawnPanel, BorderLayout.SOUTH);


	}

	
	public String getBotType() {
		return (String) this.selectBotTypeCombo.getSelectedItem();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("startGame")) {
			
			/*
			 * 2. All the neccessary information has collected from client. 
			 * 2. Server is already created. 
			 * 2. Network Controller is already created, but this application(class) does not know.
			 * 2. Initially this class needs to create Client object.!!
			 */
			if(areInputsValid()) {
				disableUserInteractions();
				if(!isThisClientBot) {
					client = new Client(true, "HumanPlayer", this.getPlayerName(), this.getPortNumber(), this.getServerIP(), this.getPawnName());
				}
				
				else {
					client = new Client(false, this.getBotType(), this.getPlayerName(), this.getPortNumber(), this.getServerIP(), this.getPawnName());
				}
				
				client.addClientEventListener(this);
				client.startConnection();
			} else {
				riseInvalidInputError();
			}
			

		} 
		
		else if(e.getActionCommand().equals("isBot")) {
			this.isBotButton.setEnabled(false);		
			isThisClientBot = true;
		}
		

	}
	
	private void disableUserInteractions() {
		this.disable();
	}


	private void riseInvalidInputError() {
		
		JOptionPane.showMessageDialog(this, "Fill the Blanks");

	}


	private boolean areInputsValid() {
		
		String trimmedServerIP = this.serverIPTextArea.getText().trim();
		String trimmedPortNum = this.portTextArea.getText().trim();
		return !trimmedServerIP.equals("")&& !trimmedPortNum.equals("") && pawnPanel.isPawnSelected();
	}
	

	//ALL THE GUI MESSAGES WILL BE DECODED HERE AND GAMEFRAME WILL BE CALLED FOR GUI ACTIONS.
	@Override
	public void onClientEvent(String message) {
		
		String[] messageParts = message.split("-");
		String actionMessage = messageParts[0];
		
		if(actionMessage.equals("log")) {
			
			String logMessage = messageParts[1];
			gameFrame.writeOnGameLog(logMessage);
		}
		
		else if(actionMessage.equals("CloseStartApp")) {
			
			this.setVisible(false);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
