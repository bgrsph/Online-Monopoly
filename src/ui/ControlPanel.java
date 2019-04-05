package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;
import domain.squares.Square;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener {

	int panelWidth;
	int panelHeight;
	
	private JButton buyButton;
	private JButton endTurnButton;
	private JButton rollDiceButton;
	private JButton useCardButton;
	private JButton startGameButton;
	private JButton specialMoveButton;
	private JButton triplesButton;
	private JButton buildBuildingButton;
	private JButton hurricaneButton;
	
	private JButton payRentButton;
	private JButton mortgageButton;
	
	private JPanel gameLogPanel;
	private JPanel playerStatusPanel;
	private JPanel actionPanel;
	
	
	private JTextArea playerStatusTextArea;
	private JTextArea gameLogTextArea;
	
	
	private MonopolyGameFrame monopolyGameFrame;
	private JButton menuButton;
	
	public MenuFrame menuFrame;
	
	
	private JComboBox<String> squareSelector;
	private JComboBox<String> colorSelector;
	private JComboBox<String> playerSelector;
	private JTextField squareTypeTextField;
	private JComboBox<String> cardSelector;
	
	
	
	
	
	
	public ControlPanel(int cONTROL_PANEL_WIDTH, int cONTROL_PANEL_HEIGHT, MonopolyGameFrame monopolyGameFrame) {
		
		super();
		this.monopolyGameFrame = monopolyGameFrame;
		this.panelWidth = cONTROL_PANEL_WIDTH;
		this.panelHeight = cONTROL_PANEL_HEIGHT;
		initPanelGUI();
		
	
		
		initiatePlayerStatusPanel();
		initiateGameLogPanel();
		initiateActionPanel();
		
		
		
	}
	
	
	public void showCurrentPlayerStatus() {
		
		MonopolyGameController.getInstance();
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		
		
		String playerName = currentPlayer.getName();
		int balance = currentPlayer.getBalance();
		
		ArrayList<Card> cards = currentPlayer.getCards();
		ArrayList<Square> squares = currentPlayer.getProperties();
		
		this.playerStatusTextArea.setText("\nPLAYER NAME: " + playerName + "\nBALANCE: " + balance + "\nCARDS:" + cards + "\nPROPERTIES: " +  "\n" + squares);
		
	}



	private void initiateActionPanel() {
		actionPanel = new JPanel();
		//actionPanel.setLayout(new GridLayout(2,4));
		actionPanel.setLayout(new GridLayout(6,5));
		actionPanel.setBackground(Color.decode("#BFDBAE"));
		Border border = BorderFactory.createTitledBorder("ACTION PANEL");
		actionPanel.setBorder(border);
		
		
		
		buyButton = new JButton("Buy");
		buyButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		buyButton.setPreferredSize(new Dimension(100,100));
		buyButton.setBackground(Color.decode("#C70000"));
		buyButton.addActionListener(this);
		buyButton.setActionCommand("buy");
		buyButton.setEnabled(false);
		 
		rollDiceButton = new JButton ("Roll Dice");
		rollDiceButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		rollDiceButton.setPreferredSize(new Dimension(100,100));
		rollDiceButton.setBackground(Color.decode("#C70000"));
		rollDiceButton.addActionListener(this);
		rollDiceButton.setActionCommand("rollDice");
		rollDiceButton.setEnabled(false);
		
		
		endTurnButton = new JButton ("End Turn");
		endTurnButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		endTurnButton.setPreferredSize(new Dimension(100,100));
		endTurnButton.setBackground(Color.decode("#C70000"));
		endTurnButton.addActionListener(this);
		endTurnButton.setActionCommand("endTurn");
		endTurnButton.setEnabled(false);

		
		useCardButton = new JButton ("Use Card");
		useCardButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		useCardButton.setPreferredSize(new Dimension(100,100));
		useCardButton.setBackground(Color.decode("#C70000"));
		useCardButton.addActionListener(this);
		useCardButton.setActionCommand("useCard");
		useCardButton.setEnabled(true);

		menuButton = new JButton ("Menu");
		menuButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		menuButton.setPreferredSize(new Dimension(100,100));
		menuButton.setBackground(Color.decode("#C70000"));
		menuButton.addActionListener(this);
		menuButton.setActionCommand("openMenu");
		menuButton.setEnabled(false);
		
		
		startGameButton = new JButton ("Start Game");
		startGameButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		startGameButton.setPreferredSize(new Dimension(100,100));
		startGameButton.setBackground(Color.decode("#C70000"));
		startGameButton.addActionListener(this);
		startGameButton.setActionCommand("startGame");
		startGameButton.setEnabled(true);
		
		
		
		
		
		/*
		 * Generic buttons for later features. In "InitiateActionPanel" method
		 */
		payRentButton = new JButton ("Pay Rent");
		payRentButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		payRentButton.setPreferredSize(new Dimension(100,100));
		payRentButton.setBackground(Color.decode("#C70000"));
		payRentButton.addActionListener(this);
		payRentButton.setActionCommand("payRent");
		payRentButton.setEnabled(false);
		
		mortgageButton = new JButton ("Mortgage");
		mortgageButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		mortgageButton.setPreferredSize(new Dimension(100,100));
		mortgageButton.setBackground(Color.decode("#C70000"));
		mortgageButton.addActionListener(this);
		mortgageButton.setActionCommand("mortgage");
		mortgageButton.setEnabled(false);
		
		specialMoveButton = new JButton ("Special Move");
		specialMoveButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		specialMoveButton.setPreferredSize(new Dimension(100,100));
		specialMoveButton.setBackground(Color.decode("#C70000"));
		specialMoveButton.addActionListener(this);
		specialMoveButton.setActionCommand("specialMove");
		specialMoveButton.setEnabled(false);
		
		triplesButton = new JButton ("Triples");
		triplesButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		triplesButton.setPreferredSize(new Dimension(100,100));
		triplesButton.setBackground(Color.decode("#C70000"));
		triplesButton.addActionListener(this);
		triplesButton.setActionCommand("triples");
		triplesButton.setEnabled(false);
		
		
		
		buildBuildingButton = new JButton ("Build Building");
		buildBuildingButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		buildBuildingButton.setPreferredSize(new Dimension(100,100));
		buildBuildingButton.setBackground(Color.decode("#C70000"));
		buildBuildingButton.addActionListener(this);
		buildBuildingButton.setActionCommand("buildBuilding");
		buildBuildingButton.setEnabled(false);
		
		
		hurricaneButton = new JButton ("Hurricane");
		hurricaneButton.setFont(new Font("ARIAL",Font.PLAIN,15));
		hurricaneButton.setPreferredSize(new Dimension(100,100));
		hurricaneButton.setBackground(Color.decode("#C70000"));
		hurricaneButton.addActionListener(this);
		hurricaneButton.setActionCommand("hurricane");
		hurricaneButton.setEnabled(false);
		
		
		
		
		
		
		squareSelector = new JComboBox();
		squareSelector.setBackground(Color.decode("#BFDBAE"));
		squareSelector.setFont(new Font("ARIAL",Font.PLAIN,15));
		squareSelector.setPreferredSize(new Dimension(200,50));
		squareSelector.setBackground(Color.decode("#C70000"));
		squareSelector.addActionListener(this);
		
	
		
		colorSelector = new JComboBox();
		colorSelector.setBackground(Color.decode("#BFDBAE"));
		colorSelector.setFont(new Font("ARIAL",Font.PLAIN,15));
		colorSelector.setPreferredSize(new Dimension(200,50));
		colorSelector.setBackground(Color.decode("#C70000"));
		colorSelector.addActionListener(this);
		colorAdder(colorSelector);
		
		cardSelector = new JComboBox();
		cardSelector.setBackground(Color.decode("#BFDBAE"));
		cardSelector.setFont(new Font("ARIAL",Font.PLAIN,15));
		cardSelector.setPreferredSize(new Dimension(200,50));
		cardSelector.setBackground(Color.decode("#C70000"));
		cardSelector.addActionListener(this);
		cardAdder(cardSelector);
		actionPanel.add(cardSelector);
		
		playerSelector = new JComboBox();
		playerSelector.setBackground(Color.decode("#BFDBAE"));
		playerSelector.setFont(new Font("ARIAL",Font.PLAIN,15));
		playerSelector.setPreferredSize(new Dimension(200,50));
		playerSelector.setBackground(Color.decode("#C70000"));
		playerSelector.addActionListener(this);
		playerAdder(playerSelector);
	
		
		
	
		squareTypeTextField = new JTextField();
		squareTypeTextField.setBackground(Color.decode("#BFDBAE"));
		squareTypeTextField.setFont(new Font("ARIAL",Font.PLAIN,15));
		squareTypeTextField.setPreferredSize(new Dimension(200,50));
		squareTypeTextField.setBackground(Color.decode("#C70000"));
		actionPanel.add(squareTypeTextField);
		
		
		actionPanel.add(squareSelector);
		squareAdder(squareSelector);
		actionPanel.add(colorSelector);
		actionPanel.add(playerSelector);
		actionPanel.add(squareTypeTextField);
		
		
		
		
		actionPanel.add(startGameButton);
		actionPanel.add(buyButton);
		actionPanel.add(rollDiceButton);
		actionPanel.add(endTurnButton);
		actionPanel.add(menuButton);
		actionPanel.add(useCardButton);
		actionPanel.add(payRentButton);
		actionPanel.add(mortgageButton);
		actionPanel.add(specialMoveButton);
		actionPanel.add(triplesButton);
		actionPanel.add(buildBuildingButton);
		actionPanel.add(hurricaneButton);
		
		hurricaneButton.setEnabled(true);
		
		
		this.add(actionPanel);
		
	}


	private void initiateGameLogPanel() {
		gameLogPanel = new JPanel();
		gameLogPanel.setBackground(Color.decode("#BFDBAE"));
		Border border = BorderFactory.createTitledBorder("GAME LOG");
		gameLogPanel.setBorder(border);
		gameLogTextArea = new JTextArea();
		gameLogPanel.setPreferredSize(new Dimension(this.panelWidth - 10, this.panelHeight/(3)));
		

		
		
		gameLogTextArea.setBackground(Color.decode("#BFDBAE"));
		//gameLogTextArea.setPreferredSize(new Dimension(this.panelWidth - 10, this.panelHeight/(2 + 1/2)));
		gameLogTextArea.setEditable(false);
		gameLogTextArea.setCaretPosition(gameLogTextArea.getDocument().getLength());
		//gameLogPanel.add(gameLogTextArea);
		
		
		JScrollPane scroll = new JScrollPane(gameLogTextArea);
		//scroll.setPreferredSize(new Dimension(this.panelWidth - 10, this.panelHeight/(3 + 1/2)));
		scroll.setPreferredSize(gameLogPanel.getPreferredSize());
		//scroll.setPreferredSize(new Dimension(this.panelWidth - 10, this.panelHeight/1 + (1/2)));
		//scroll.setPreferredSize(new Dimension(this.panelWidth - 10, 600));
		//scroll.setHorizontalScrollBar(null);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBar(null);
		JScrollBar vertical = scroll.getVerticalScrollBar();
		vertical.setValue( vertical.getMaximum() );
		scroll.setVerticalScrollBar(vertical);
		gameLogPanel.add(scroll);
		this.add(gameLogPanel);
	}



	private void initiatePlayerStatusPanel() {
		
		playerStatusPanel = new JPanel();
		playerStatusPanel.setBackground(Color.decode("#BFDBAE"));
		Border border = BorderFactory.createTitledBorder("PLAYER STATUS");
		playerStatusPanel.setBorder(border);
		playerStatusTextArea = new JTextArea();
		playerStatusTextArea.setBackground(Color.decode("#BFDBAE"));
		playerStatusTextArea.setPreferredSize(new Dimension(this.panelWidth - 10, this.panelHeight/5));
		playerStatusTextArea.setEditable(false);
		playerStatusPanel.add(playerStatusTextArea);
		this.add(playerStatusPanel);
		
	}





	




	private void initPanelGUI() {
		this.setPreferredSize(new Dimension(panelWidth,panelHeight));
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(Color.decode("#BFDBAE"));
		
		
	}


	
	public void log(String message) {
		
		this.gameLogTextArea.append("\n"+ message + "\n");
	}
	
	public void clearLog() {
		this.gameLogTextArea.setText("");
	}
	
 
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("startGame")) {
			this.startGameButton.disable();
			this.monopolyGameFrame.repaint();
			MonopolyGameController.getInstance().startTheGameButtonPressed(monopolyGameFrame.getTitle());
		}
		
		
		else if (e.getActionCommand().equals("rollDice")){
			
			MonopolyGameController.getInstance();
			try {
				MonopolyGameController.rollDiceButtonPressed();
				this.showCurrentPlayerStatus();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		
		}else if(e.getActionCommand().equals("endTurn")) {

			MonopolyGameController.getInstance();
			MonopolyGameController.endTurnButtonPressed();
			this.showCurrentPlayerStatus();
			
		}else if(e.getActionCommand().equals("buy")){
			
			MonopolyGameController.getInstance().buyButtonPressed();
			
		}else if (e.getActionCommand().equals("useCard")) {
			
			String selectedCard = (String) cardSelector.getSelectedItem();
			MonopolyGameController.getInstance().useCardButtonPressed(selectedCard);
			
					
		}else if(e.getActionCommand().equals("openMenu")) {

			this.menuButton.setEnabled(false);
			menuFrame = new MenuFrame();
			menuFrame.setAlwaysOnTop(true);
			
		}else if(e.getActionCommand().equals("payRent")) {

			MonopolyGameController.getInstance().payRentButtonPressed();
			
		}
		
		else if(e.getActionCommand().equals("specialMove")) {

			MonopolyGameController.getInstance().specialMoveButtonPressed();
			
		}
		
		else if(e.getActionCommand().equals("triples")) {

			MonopolyGameController.getInstance().triplesButtonPressed();
			
		}

		else if(e.getActionCommand().equals("mortgage")) {

			MonopolyGameController.getInstance().mortgageButtonPressed();
			
		}
		
		else if(e.getActionCommand().equals("buildBuilding")) {
			
			MonopolyGameController.getInstance().buildBuildingPressed();
		
			
		}
		else if(e.getActionCommand().equals("hurricane")) {
			
			MonopolyGameController.getInstance().hurricaneButtonPressed();
		
			
		}
		
		
		
	}
	

	public void cardAdder(JComboBox<String> loadCombo2) {
		MonopolyGameController.getInstance();
		
		ArrayList<Card> playerCards = MonopolyGameController.getCurrentPlayer().getCards();
		if(!playerCards.isEmpty()) {
			for (Card c: playerCards) {
				loadCombo2.addItem(c.getName());
			}
		}
	}
	
	
	
	public void playerAdder(JComboBox<String> loadCombo2) {
		MonopolyGameController.getInstance();
		//MonopolyGameController.getPreviouslySavedGames();
		
		for(Player s : MonopolyGameController.getPlayersList()) {
			MonopolyGameController.getInstance();
			loadCombo2.addItem(s.getName());
			}
	}
	
	public void colorAdder(JComboBox<String> loadCombo2) {
		MonopolyGameController.getInstance();
		
		for(String s : MonopolyGameController.getCurrentPlayer().getColorGroup().keySet()) {
			MonopolyGameController.getInstance();
			loadCombo2.addItem(s);
			}
	}
	
	public void squareAdder(JComboBox<String> loadCombo2) {
		MonopolyGameController.getInstance();
		ArrayList<Square> sL = MonopolyGameController.getBoard().getSquareList();
		if(!sL.isEmpty()) {
			for(Square s : MonopolyGameController.getBoard().getSquareList()) {
				MonopolyGameController.getInstance();
				loadCombo2.addItem(s.getName());
				
				}
		}
		}
		
	/*
	
	public String getSquareTypeText() {
		// TODO Auto-generated method stub
		return squareTypeTextField.getText();
		
	}
*/

	public String getColorTypeCombo() {
		// TODO Auto-generated method stub
		return colorSelector.getSelectedItem().toString();
	}


	public Square getSquaresFromSelector() {
		// TODO Auto-generated method stub
		
		//NOT SO SURE
		
		return (Square) squareSelector.getSelectedItem();
	}
	
	public int getSquaresIndexFromSelector() {
		return squareSelector.getSelectedIndex();
	}
	
/*
 * All the Button Combinations for Game
 */
	
	public void switchButtonsToStartStateForPlayerInTurn() {
		this.menuButton.setEnabled(true);
		this.useCardButton.setEnabled(true);
		this.rollDiceButton.setEnabled(true);
		this.buyButton.setEnabled(false);
		this.endTurnButton.setEnabled(false);		
		this.startGameButton.setEnabled(false);
		this.mortgageButton.setEnabled(false);
		this.payRentButton.setEnabled(false);
		this.specialMoveButton.setEnabled(false);
		this.triplesButton.setEnabled(false);
	}

	public void switchButtonsToStartStateForPlayerNotInTurn() {
		
		
		this.useCardButton.setEnabled(true);
		this.buyButton.setEnabled(false);
		this.endTurnButton.setEnabled(false);
		this.rollDiceButton.setEnabled(false);
		this.menuButton.setEnabled(false);
		this.startGameButton.setEnabled(false);
		this.specialMoveButton.setEnabled(false);
		this.mortgageButton.setEnabled(false);
		this.triplesButton.setEnabled(false);
	}


	
	public void switchButtonsToAfterRollDiceState() {
		this.rollDiceButton.setEnabled(false);
		this.endTurnButton.setEnabled(true);
		this.mortgageButton.setEnabled(true);
	}


	public void switchButtonsToAfterEndTurnPressed() {
		this.buildBuildingButton.setEnabled(false);
		this.mortgageButton.setEnabled(false);
		this.specialMoveButton.setEnabled(false);
		this.buyButton.setEnabled(false);
		this.endTurnButton.setEnabled(false);
		this.useCardButton.setEnabled(true);
		this.rollDiceButton.setEnabled(false);
		this.menuButton.setEnabled(false);
		this.startGameButton.setEnabled(false);
		this.triplesButton.setEnabled(false);
	} 


	public void switchButtonsToPlayerInTurnState() {
		this.rollDiceButton.setEnabled(true);
		this.menuButton.setEnabled(true);
		this.mortgageButton.setEnabled(true);
		this.specialMoveButton.setEnabled(false);
		this.buildBuildingButton.setEnabled(true);
	}
	
	
	

	public void switchToBuyState() {
		this.buyButton.setEnabled(true);
		this.endTurnButton.setEnabled(true);
		this.useCardButton.setEnabled(true);
		
	}



	public void switchButtonsToAfterBuyState() {
		
		this.buyButton.setEnabled(false);
		this.rollDiceButton.setEnabled(false);
	}


	public void allowNotCurrentPlayerToNotBuy() {
		
		this.buyButton.setEnabled(false);
		this.endTurnButton.setEnabled(false);
		this.useCardButton.setEnabled(true);
	}


	public void disableInteractions() {
		this.useCardButton.setEnabled(true);
		this.buildBuildingButton.setEnabled(false);
		this.buyButton.setEnabled(false);
		this.endTurnButton.setEnabled(false);
		this.payRentButton.setEnabled(false);
		this.mortgageButton.setEnabled(false);
		this.specialMoveButton.setEnabled(false);
		this.startGameButton.setEnabled(false);
		this.menuButton.setEnabled(false);
		this.rollDiceButton.setEnabled(false);
		this.triplesButton.setEnabled(false);
		this.mortgageButton.setEnabled(false);
	}

	public void switchButtonsToPauseState() {
		this.menuButton.setEnabled(false);
		this.rollDiceButton.setEnabled(false);
		
	}
	
	
	public void switchButtonsToResumeState() {
		this.menuButton.setEnabled(true);
		this.rollDiceButton.setEnabled(true);
		this.useCardButton.setEnabled(true);
		this.mortgageButton.setEnabled(true);
	}


	public void allowCurrentPlayerToPayRent() {
		this.payRentButton.setEnabled(true);
		this.endTurnButton.setEnabled(false);
		this.rollDiceButton.setEnabled(false);
		
	}


	public void switchButtonsToAfterRentState() {
		this.payRentButton.setEnabled(false);
		this.rollDiceButton.setEnabled(false);
		
	}


	public void switchButtonsToPlayAgainState() {
		
		this.buyButton.setEnabled(false);
		this.endTurnButton.setEnabled(false);
		this.useCardButton.setEnabled(true);
		this.payRentButton.setEnabled(false);
		this.mortgageButton.setEnabled(false);
		this.rollDiceButton.setEnabled(true);
		
	}


	public void switchButtonsToEndTurnState() {
		
		//this.buyButton.setEnabled(false);
		this.endTurnButton.setEnabled(true);
		this.useCardButton.setEnabled(true);
		this.payRentButton.setEnabled(false);
		this.mortgageButton.setEnabled(false);
		this.rollDiceButton.setEnabled(false);
		this.specialMoveButton.setEnabled(false);
	}


	public void switchButtonsToSpecialMoveState() {
		
		//this.buyButton.setEnabled(false);
		this.endTurnButton.setEnabled(false);
		this.useCardButton.setEnabled(true);
		this.payRentButton.setEnabled(false);
		this.mortgageButton.setEnabled(false);
		this.specialMoveButton.setEnabled(true);
		this.startGameButton.setEnabled(false);
		this.rollDiceButton.setEnabled(false);
		
	}


	public String getSelectedSquareFromUser() {
		return (String) this.squareSelector.getSelectedItem();
	}


	public void switchButtonsToTriplesState() {
	
		//this.buyButton.setEnabled(false);
		this.endTurnButton.setEnabled(false);
		this.useCardButton.setEnabled(true);
		this.payRentButton.setEnabled(false);
		this.mortgageButton.setEnabled(false);
		this.specialMoveButton.setEnabled(false);
		this.startGameButton.setEnabled(false);
		this.rollDiceButton.setEnabled(false);
		this.triplesButton.setEnabled(true);
	}


	public void updatePlayersCardComboBox() {
		cardAdder(cardSelector);
		
	}


	public void switchButtonsToAfterTriplesState() {
		
		
		this.triplesButton.setEnabled(false);

	}


	public void closeEndTurn() {
		this.endTurnButton.setEnabled(false);
		
	}


	public JButton getEndTurnButton() {
		// TODO Auto-generated method stub
		return this.endTurnButton;
	}


	public String getSelectedSquareType() {
		
		return this.squareTypeTextField.getText();
	}


	public String getSelectedColorType() {
		
		return (String)colorSelector.getSelectedItem();
	}
	
	

	
	
	
	
	
	
	

}
