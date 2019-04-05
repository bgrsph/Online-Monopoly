package ui.networkApps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

import domain.ServerEventListener;
import domain.network.NetworkController;
import ui.MonopolyGameFrame;
import ui.PawnSelectionPanel;

public class ServerApp extends JFrame implements ActionListener, ServerEventListener {

	JPanel playerInfoPanel;
	JLabel numberOfPlayersLabel;
	JTextArea numberOfPlayersTextArea;
	JLabel playerNameLabel;
	JTextArea playerNameTextArea;
	JLabel serverIPLabel;
	JTextArea serverIPTextArea;
	JLabel portLabel;
	JTextArea portTextArea;
	JButton startButton;
	PawnSelectionPanel pawnPanel;
	JDialog errDialog; 
	MonopolyGameFrame gameFrame; 
	JComboBox<Integer> numberOfPlayersComboBox;
	
	JPanel logPanel;
	JTextArea logTextArea; 
	

	
	public ServerApp() {
		super("MONOPOLY SERVER");
		initGUI();
		this.setVisible(true);
	}

		
		public int getNumberOfPlayers() {
			return (int) numberOfPlayersComboBox.getSelectedItem();
		}
		
		
		

		
		public String getServerIP() {
			return this.serverIPTextArea.getText();
		}
		
		
		

		
		public int getPortNumber() {
			return Integer.parseInt(this.portTextArea.getText());
		}
		
		
		
		
	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		// this.getContentPane().setBackground(Color.decode("#BFDBAE"));
		this.setSize(500, 300);

		playerInfoPanel = new JPanel();
		playerInfoPanel.setLayout(new GridLayout(3, 2));
		playerInfoPanel.setBackground(Color.decode("#BFDBAE"));
		playerInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		numberOfPlayersLabel = new JLabel("Enter Number of Players");
		numberOfPlayersLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(numberOfPlayersLabel);


		
		numberOfPlayersComboBox = new JComboBox<Integer>();
		numberOfPlayersComboBox.addItem(2);
		numberOfPlayersComboBox.addItem(3);
		numberOfPlayersComboBox.addItem(4);
		numberOfPlayersComboBox.addItem(5);
		numberOfPlayersComboBox.addItem(6);
		numberOfPlayersComboBox.addItem(7);
		numberOfPlayersComboBox.addItem(8);
		numberOfPlayersComboBox.addItem(9);
		numberOfPlayersComboBox.addItem(10);
		numberOfPlayersComboBox.addItem(11);
		numberOfPlayersComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(numberOfPlayersComboBox);
		
		
		serverIPLabel = new JLabel("Enter Server IP");
		serverIPLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(serverIPLabel);

		serverIPTextArea = new JTextArea();
		serverIPTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//TODO:
		serverIPTextArea.setText("172.20.105.25");
		playerInfoPanel.add(serverIPTextArea);
		

		portLabel = new JLabel("Enter Port Number");
		portLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerInfoPanel.add(portLabel);

		portTextArea = new JTextArea();
		portTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//TODO:
		portTextArea.setText("123");
		playerInfoPanel.add(portTextArea);

		this.add(playerInfoPanel, BorderLayout.CENTER);

		startButton = new JButton("Start The Game");
		startButton.addActionListener(this);
		startButton.setActionCommand("startGame");

		this.add(startButton, BorderLayout.NORTH);


	}
	


	public static void main(String[] args) {
		
		ServerApp s = new ServerApp();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("startGame")) {
			
		
			
			/*
			 * 0. All the neccessary info is collected from the Server Frame
			 * 1. Invoke the network controller with neccessary arguments.
			 */			
			try {
				
				if(this.areInputsValid()) {
					//1.
					disableUserInteractions();
					NetworkController.getInstance().initializeArgumentsAndStartServer(getNumberOfPlayers(), getServerIP(), getPortNumber(), this);
				} else {
					
					riseInvalidInputError();
					this.enableUserInteractions();
					
				}
				
			} catch (IOException e1) {
				System.out.println("ServerAPP cannot initiated NetworkController");
				e1.printStackTrace();
			}
			
		}


	}
	
	private void riseInvalidInputError() {
		
		JOptionPane.showMessageDialog(this, "Fill the Blanks");

	}


	private boolean areInputsValid() {
		
		String trimmedServerIP = this.serverIPTextArea.getText().trim();
		String trimmedPortNum = this.portTextArea.getText().trim();
		return !trimmedServerIP.equals("")&& !trimmedPortNum.equals("");
		

	}
	


	private void disableUserInteractions() {
		this.startButton.disable();
		this.numberOfPlayersComboBox.disable();
		this.serverIPTextArea.disable();
		this.portTextArea.disable();

	}
	
	private void enableUserInteractions() {
		this.startButton.enable();
		this.numberOfPlayersComboBox.enable();
		this.serverIPTextArea.enable();
		this.portTextArea.enable();

	}



	@Override
	public void onServerEvent(String message) {
		if(message.equals("GameStarted")) {
			this.dispose();
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
