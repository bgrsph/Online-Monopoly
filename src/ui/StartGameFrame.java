package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import domain.MonopolyGameController;

@SuppressWarnings("serial")
public class StartGameFrame extends JFrame implements ActionListener {

	private JButton actionButton;
	private JDialog errDialog;

	private HashMap<String, String> playersWithPawnImageNames = new HashMap<String, String>();

	private String serverIPAddress; //--> not for now.
	int numberOfPlayers;
	int numberOfPlayersAdded = 0;

	PlayerInformationFormPanel informationPanel;
	
	MonopolyGameFrame gameFrame;
	

	public StartGameFrame() {
		super("Setup");
		initializeGUI();
		
		pack();

	}

	
	@SuppressWarnings({ "deprecation", "static-access" })
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "userSelectsNumberOfPlayers":

			numberOfPlayers = Integer.parseInt(informationPanel.getNumberOfPlayers());
			informationPanel.switchToPlayerNameAndPawnSelectionState();

			actionButton.setActionCommand("userAddsOnePlayer");
			actionButton.setText("Add One Player");
			break;

		case "userAddsOnePlayer":
			
			numberOfPlayersAdded++;
			String currentlyAddedPlayerName = this.informationPanel.getPlayerName();
			String currentlyAddedPawnImageName = this.informationPanel.getSelectedPawnImageName();
			if (currentlyAddedPlayerName.equals("") || currentlyAddedPawnImageName == null) {
				riseError("You need to determine the pawn and the player name...");
				break;

			}
			this.playersWithPawnImageNames.put(currentlyAddedPlayerName, currentlyAddedPawnImageName);
			this.informationPanel.getPlayerNameTextField().setText("");

			if (this.numberOfPlayersAdded == this.numberOfPlayers) {

				informationPanel.switchToStartGameState();
				this.actionButton.setText("Start the Game");
				this.actionButton.setActionCommand("userWantsToStartTheGame");

			}

			break;

		case "userWantsToStartTheGame":
			

			MonopolyGameController.getInstance(); //first initialization of the controller.
		//	MonopolyGameController.initializeTheGame(playersWithPawnImageNames, this.numberOfPlayers, this.serverIPAddress);
			
			MonopolyGameFrame.getInstance();
		
			
			
			
			dispose();
			break;

		case "errorWasRasedAndOKPressed":
			this.errDialog.dispose();
			this.enable();

			break;

		default:
			System.out.println("Button Error");
			break;

		}

	}

	@SuppressWarnings("deprecation")
	private void riseError(String errorMessage) {

		this.disable();
		errDialog = new JDialog();
		JLabel errMessage = new JLabel(errorMessage);
		JButton okButton = new JButton("OK");
		okButton.addActionListener(this);
		okButton.setActionCommand("errorWasRasedAndOKPressed");
		errDialog.setLayout(new BorderLayout());
		errMessage.setHorizontalAlignment(JLabel.CENTER);
		errMessage.setVerticalAlignment(JLabel.CENTER);
		errDialog.add(errMessage, BorderLayout.CENTER);
		errDialog.add(okButton, BorderLayout.SOUTH);
		errDialog.setSize(new Dimension(300, 70));
		errDialog.setVisible(true);

	}

	private void initializeGUI() {

		/*
		 * Main Frame Initialization
		 */
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.getContentPane().setBackground(Color.decode("#BFDBAE"));

		/*
		 * Welcome Message Label
		 */
		JLabel welcomeMessageLabel = new JLabel("Welcome To The Ultimate Monopoly Game");
		welcomeMessageLabel.setHorizontalAlignment(JLabel.CENTER);
		welcomeMessageLabel.setVerticalAlignment(JLabel.CENTER);
		welcomeMessageLabel.setBounds(100, 50, 100, 30);
		Font labelFont = new Font("ARIAL", Font.PLAIN, 30);
		welcomeMessageLabel.setFont(labelFont);
		this.add(welcomeMessageLabel, BorderLayout.NORTH);

		/*
		 * Initialize the Information Panel (Players Information labels and areas are
		 * here
		 */
		informationPanel = new PlayerInformationFormPanel();
		this.add(informationPanel, BorderLayout.CENTER);
		pack();

		/*
		 * Initialize and add the action button into frame
		 */
		actionButton = new JButton("I've Selected the Number of Players");
		this.add(actionButton, BorderLayout.SOUTH);
		actionButton.addActionListener(this);
		actionButton.setActionCommand("userSelectsNumberOfPlayers");

		/*
		 * Initialize the information panel such that user can enter only number of
		 * players
		 */

		informationPanel.switchToPlayerNumberSelectionState();

	}

}

