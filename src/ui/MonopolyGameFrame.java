package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.ClientEventListener;
import domain.MonopolyGameController;
import domain.squares.Square;
import ui.animation.Animator;
import ui.animation.PawnImage;



@SuppressWarnings("serial")
public class MonopolyGameFrame extends JFrame implements ClientEventListener   {
	
	

	private JPanel boardPanel;
	private JPanel controlPanel;
	
	
	public int BOARD_PANEL_WIDTH;
	public int BOARD_PANEL_HEIGHT;
	
	private int CONTROL_PANEL_WIDTH;
	private int CONTROL_PANEL_HEIGHT;

	
	private  DieGraphics firstRegularDieGraphic;
	private  DieGraphics secondRegularDieGraphic;
	private  DieGraphics speedDieGraphic;
	
	
	private JLabel firstRegularDieLabel;
	private JLabel secondRegularDieLabel;
	private JLabel speedDieLabel;
	
	private ArrayList<PawnImage> pawnImages;

	private SquareHolderHandler squareHolderHandler;
	public MenuFrame menuFrame;

	private Animator animator;

	static MonopolyGameFrame gameFrameInstance;
	

	public MonopolyGameFrame() {	
		super();	
		squareHolderHandler = new SquareHolderHandler();
		
		
		
		initFrameGUI();
		initAndAddPanels();
		initDie();

		squareHolderHandler.initSquareHolderList();
		squareHolderHandler.squareHolderListAndCoordinateListMatcher();
		
		initAnimator();
		initPawnImages(); 
		this.squareHolderHandler.printAllSquares();
		
		setVisible(true);

	} 
	
	
	



	private void initAnimator() {
		animator = new Animator();
		animator.setBounds(0, 0, BOARD_PANEL_WIDTH, BOARD_PANEL_HEIGHT);	
		animator.setOpaque(false);
		this.getLayeredPane().add(animator);
		//animator.run();
		animator.setVisible(true);
		
	}






	public void initPawnImages() {
		pawnImages = new ArrayList<PawnImage>();	
		MonopolyGameController.getInstance();
		ArrayList<String> pawnNames = MonopolyGameController.getPawnNames();
		
		SquareHolder initialSquareHolder = this.getSquareHolders().get(0); //Go Square
		int initialPointX = (int)initialSquareHolder.getX();
		int initialPointY = (int)initialSquareHolder.getY();
		
		int locationDelta = 0;
		for(String pawnName: pawnNames) {
			Point startPoint = new Point(initialPointX + 30*locationDelta,initialPointY);
			PawnImage currentPawnImage = new PawnImage(startPoint, 40, pawnName);
			animator.addDrawable(currentPawnImage);
			this.pawnImages.add(currentPawnImage);
			locationDelta++;
		}

	}

	

 

	private void initDie() {
		firstRegularDieGraphic = new DieGraphics("diceone.jpg",BOARD_PANEL_WIDTH/2 -60,BOARD_PANEL_HEIGHT/2 - 60);
		secondRegularDieGraphic = new DieGraphics("diceone.jpg",BOARD_PANEL_WIDTH/2,BOARD_PANEL_HEIGHT/2);
		speedDieGraphic = new DieGraphics("dicemrmonopoly.jpg",BOARD_PANEL_WIDTH/2+60,BOARD_PANEL_HEIGHT/2 + 60);

		firstRegularDieLabel = new JLabel(firstRegularDieGraphic);
		secondRegularDieLabel = new JLabel (secondRegularDieGraphic);
		speedDieLabel = new JLabel(speedDieGraphic);
		
		
		this.getLayeredPane().add(firstRegularDieLabel);
		this.getLayeredPane().add(secondRegularDieLabel);
		this.getLayeredPane().add(speedDieLabel);
		
		
	
		
		firstRegularDieLabel.setBounds(0, 0, 2000,2000);
		secondRegularDieLabel.setBounds(0, 0, 2000,2000);
		speedDieLabel.setBounds(0, 0, 2000,2000);
		
		firstRegularDieGraphic.createRegularDie();
		secondRegularDieGraphic.createRegularDie();
		speedDieGraphic.createSpeedDie();


	}

	
	
	
	
	private void initAndAddPanels() {
		
		//BOARD_PANEL_WIDTH 	= 3 * (this.getSize().width) / 5;
		BOARD_PANEL_WIDTH 	= 680;
		//BOARD_PANEL_WIDTH 	= 1020;
		//BOARD_PANEL_HEIGHT 	= this.getSize().height - 30;
		BOARD_PANEL_HEIGHT = 680;
		//BOARD_PANEL_HEIGHT = 1020;
		CONTROL_PANEL_WIDTH = this.getSize().width - BOARD_PANEL_WIDTH - 30;
		CONTROL_PANEL_HEIGHT = this.getSize().height - 30;
		
		boardPanel = new BoardPanel(new ImageIcon("UltimateMonopolyBoard.jpg").getImage(),BOARD_PANEL_WIDTH,BOARD_PANEL_HEIGHT);
		controlPanel 	=	new ControlPanel(CONTROL_PANEL_WIDTH,CONTROL_PANEL_HEIGHT, this);	
	
		
		
		this.getContentPane().add(boardPanel);
		this.add(controlPanel);
		

		this.squareHolderHandler.boardDivider((BoardPanel) boardPanel);
		
		
		repaint();
	}


	

	
	private void initFrameGUI() {
		FlowLayout generalGameFrameLayout = new FlowLayout();
		generalGameFrameLayout.setAlignment(FlowLayout.LEFT);
		this.setLayout(generalGameFrameLayout);
		//this.setResizable(false);
		getContentPane().setPreferredSize(new Dimension(1280, 720));
		
		/*
		
		String operationSystemName = System.getProperty("os.name").toLowerCase();
		if(operationSystemName.equals("mac os x")) {
			
			getContentPane().setPreferredSize(new Dimension(1280, 720));
			
		} else {
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setUndecorated(true);
		}
		*/
		
		pack();
		//getContentPane().setSize(new Dimension(getWidth(), getHeight()));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	
	
	
	public void rollDiceAnimation() {
		MonopolyGameController.getInstance();
		int sd=MonopolyGameController.getCup().getResults().get(2).getValue();
		if(sd==111) {
			sd=4;
		}
		if(sd==100) {
			sd=6;
		}
		MonopolyGameController.getInstance();
		firstRegularDieGraphic.changeDieImage(firstRegularDieGraphic.regularDieArray[MonopolyGameController.getCup().getResults().get(0).getValue()]);
		MonopolyGameController.getInstance();
		secondRegularDieGraphic.changeDieImage(secondRegularDieGraphic.regularDieArray[MonopolyGameController.getCup().getResults().get(1).getValue()]);
		speedDieGraphic.changeDieImage(speedDieGraphic.speedDieArray[sd]);
		repaint();

	}
	
	
	
	 
	
	
	public void teleportPawnImage(String pawnImageName, String sourceSquareName, String targetSquareName, int targetSquareIndex) {
		
		
		
		for(PawnImage pI: pawnImages) {
			
			if(pI.getImageName() == pawnImageName) {
				
				//SquareHolder sourceSquareHolder = squareHolderHandler.getSquareHolderByName(sourceSquareName);
				SquareHolder targetSquareHolder = squareHolderHandler.getSquareHolderList().get(targetSquareIndex);
				
				//pI.move(sourceSquareHolder, targetSquareHolder);
				
				
				pI.moveTo(targetSquareHolder);
				
				//this.repaint();
				return;
			
			}
			
		}
		
		System.out.println("teleportPawnImage method in game frame cannot find pawnImageName called " + pawnImageName + " in pawnImages list" );
			}
		
	
	
	

	public void writeOnGameLog(String message) {
		
		
		((ControlPanel) this.getControlPanel()).log(message);
		
		
	
	}
	
	
	
	
	public JPanel getBoardPanel() {
		return boardPanel;
	}


	public JPanel getControlPanel() {
		return controlPanel;
	}
	
	public MenuFrame getMenuFrame() {
		return menuFrame;
	}

	
	
	
	
	
	public ArrayList<SquareHolder> getSquareHolders() {
		
		return this.squareHolderHandler.getSquareHolderList();
	}
	
	
	
	
	
	
	public static MonopolyGameFrame getInstance() {

		if (gameFrameInstance == null) {
		
			gameFrameInstance = new MonopolyGameFrame();
			
		}

		return gameFrameInstance;
	}


/*
	public void switchToStartTheGameState() {
	
		((ControlPanel) controlPanel).switchToStartTheGameState();
		
		
	}



	public void switchToEndTurnState() {
		
		((ControlPanel) controlPanel).switchToEndTurnState();
		
		
	}



	
*/

	
	
	
	public void switchToBuyState() {
		// TODO Auto-generated method stub
		((ControlPanel) controlPanel).switchToBuyState();
	}
	
	
	
	public void clearGameLog() {
		((ControlPanel) controlPanel).clearLog();
	}





	//Decode client messages in here!
	@Override
	public void onClientEvent(String message) {
		
		
	}
	
	
	/*
	public String pickSquareTypeText() {
		return ((ControlPanel) controlPanel).getSquareTypeText();
		
	}
*/





	public String pickColorTypeCombo() {
		// TODO Auto-generated method stub
		return ((ControlPanel) controlPanel).getColorTypeCombo();
		
	}






	public Square getSquaresForSubway() {
		// TODO Auto-generated method stub
		return ((ControlPanel) controlPanel).getSquaresFromSelector();
	}
	
	
	public int getSquaresIndexForSubway() {
		return ((ControlPanel) controlPanel).getSquaresIndexFromSelector();
	}
	
	
	
	









	public void switchButtonsToStartStateForPlayerInTurn() {
		
		((ControlPanel) controlPanel).switchButtonsToStartStateForPlayerInTurn();
	}






	public void switchButtonsToStartStateForPlayerNotInTurn() {
		
		((ControlPanel) controlPanel).switchButtonsToStartStateForPlayerNotInTurn();
	}






	public void switchButtonsToAfterRollDiceState() {
		((ControlPanel) controlPanel).switchButtonsToAfterRollDiceState();
		
	}



 


	public void startRollDiceAnimation() {
		rollDiceAnimation();
	}
	


	public void switchButtonsToAfterEndTurnPressed() {
		((ControlPanel) controlPanel).switchButtonsToAfterEndTurnPressed();
		
	}






	public void switchButtonsToPlayerInTurnState() {
		((ControlPanel) controlPanel).switchButtonsToPlayerInTurnState();
		
	}






	public void switchButtonsToAfterBuyState() {
		((ControlPanel) controlPanel).switchButtonsToAfterBuyState();
		
	}






	public void allowNotCurrentPlayerToNotBuy() {
		((ControlPanel) controlPanel).allowNotCurrentPlayerToNotBuy();
		
	}






	public void showPlayerStatus() {
		((ControlPanel) controlPanel).showCurrentPlayerStatus();
		
	}






	public void disableInteractions() {
		((ControlPanel) controlPanel).disableInteractions();
		
	}






	public void switchGameToPauseState() {
		//JOptionPane.showMessageDialog(this, "Game is Paused");
		this.disable();
		
	}






	public void switchGameToResumeState() {
		//JOptionPane.showMessageDialog(this, "Game is Continuing Now");
		this.enable();
		
	}
	
	
	public void switchToPauseState() {
		this.disable();
		((ControlPanel) controlPanel).switchButtonsToPauseState();

	}

	public void switchToResumeState() {
		this.enable();
		((ControlPanel) controlPanel).switchButtonsToResumeState();
	}






	public void allowCurrentPlayerToPayRent() {
		((ControlPanel) controlPanel).allowCurrentPlayerToPayRent();
		
	}






	public void switchButtonsToAfterRentState() {
		((ControlPanel) controlPanel).switchButtonsToAfterRentState();
		
	}






	public void switchButtonsToPlayAgainState() {
		((ControlPanel) controlPanel).switchButtonsToPlayAgainState();
		
	}






	public void switchButtonsToEndTurnState() {
		((ControlPanel) controlPanel).switchButtonsToEndTurnState();
		
	}






	public void switchButtonsToSpecialMoveState() {
		((ControlPanel) controlPanel).switchButtonsToSpecialMoveState();
		
	}






	public void giveInvalidPressOfUseCardButtonError() {
		
		JOptionPane.showMessageDialog(this, "You Don't Have Any Cards To Use");
		
	}






	public void informPlayerToSelectDesiredSquare() {

		JOptionPane.showMessageDialog(this, "You rolled triples! Select a Square, Then Press the \"Special Move\" Button After To Go!");
	}






	public String getSelectedSquareFromUser() {
		
		return ((ControlPanel) controlPanel).getSelectedSquareFromUser();
	}






	public void switchButtonsToTriplesState() {
		((ControlPanel) controlPanel).switchButtonsToTriplesState();
		
	}






	public void updatePlayerScreen() {
		
		this.showPlayerStatus();
		((ControlPanel) controlPanel).updatePlayersCardComboBox();
	
		
		
		
	}






	public void switchButtonsToAfterTriplesState() {
		((ControlPanel) controlPanel).switchButtonsToAfterTriplesState();
		
	}






	public void closeEndTurn() {
		((ControlPanel) controlPanel).closeEndTurn();
		
	}






	public void riseDialog(String string) {
		JOptionPane.showMessageDialog(this,string);
		
	}






	public JButton getEndTurnButton() {
		
		return ((ControlPanel) controlPanel).getEndTurnButton();
		
	}






	public String getSelectedSquareType() {
		// TODO Auto-generated method stub
		return ((ControlPanel) controlPanel).getSelectedSquareType();
	}






	public String getSelectedColorType() {
		// TODO Auto-generated method stub
		return ((ControlPanel) controlPanel).getSelectedColorType();
	}







	
	
	
	}







	
	
	
	
	
	
	


