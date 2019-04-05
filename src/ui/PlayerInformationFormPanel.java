package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PlayerInformationFormPanel extends JPanel {
	
	  private Component[] fields;
	  private String[] labels = { "Player Name", "Number of Players", "Server IP" };
	  
	  private JTextField playerNameTextField;
	  private JTextField numberOfPlayersTextField;
	  private JTextField serverIPAddressTextField;
	  
	  private JComboBox<Integer> numberOfPlayersComboBox;
	  
	  private JLabel playerNameLabel;
	  private JLabel numberOfPlayersLabel;
	  private JLabel serverIPAddressLabel;
	  
	  private JPanel labelPanel;
	  private JPanel fieldPanel;
	  private JPanel subFieldPanel;
	  
	  private PawnSelectionPanel pawnSelectionPanel;
	  int[] numArray = new int[] {2,3,4,5,6,7,8,9,10,11,12};

	  
	 

	
	 public PlayerInformationFormPanel() {
		    super(new BorderLayout());
		    setBackground(Color.decode("#BFDBAE"));
		    
		    labelPanel = new JPanel(new GridLayout(labels.length, 1));
		    fieldPanel = new JPanel(new GridLayout(labels.length, 1));
		    subFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		    
		    
		    
		    labelPanel.setBackground(Color.decode("#BFDBAE"));
		    fieldPanel.setBackground(Color.decode("#BFDBAE"));
		    subFieldPanel.setBackground(Color.decode("#BFDBAE"));

		  
		    
		    initLabelsAndTextFields();
		    
		    initPawns();
		   
		    
		    
		    this.add(labelPanel, BorderLayout.WEST);
		    this.add(fieldPanel, BorderLayout.CENTER);
		 
		   
		  }
	
	 
	 private void initPawns() {
		
		 pawnSelectionPanel = new PawnSelectionPanel();
		 this.add(pawnSelectionPanel,BorderLayout.SOUTH);
		
	}


	@SuppressWarnings("deprecation")
	private void initLabelsAndTextFields() {


		
		  playerNameTextField 		= new JTextField();
		  numberOfPlayersComboBox 	= new JComboBox<Integer>();
		  serverIPAddressTextField	= new JTextField();
		  
		  playerNameLabel 			= new JLabel(labels[0], JLabel.RIGHT);
		  numberOfPlayersLabel 		= new JLabel(labels[1], JLabel.RIGHT);
		  serverIPAddressLabel 		= new JLabel(labels[2], JLabel.RIGHT);
		
		
		  
		  
		  for(int i = 2; i <= 12; i++) {
			  numberOfPlayersComboBox.addItem(i);
		  }
		  
		  
	
		  
		  
		  playerNameTextField.setColumns(30);
		
		  serverIPAddressTextField.setColumns(30);
		  
		  //for now, disable the serverIPAddress
		  serverIPAddressTextField.disable();
		  serverIPAddressTextField.setText("Disabled since network is not implemented.");
		  serverIPAddressTextField.setEditable(false);
		  
		  playerNameLabel.setLabelFor(playerNameTextField);
		  numberOfPlayersLabel.setLabelFor(numberOfPlayersComboBox);
		  serverIPAddressLabel.setLabelFor(serverIPAddressTextField);
		  
		  labelPanel.add(playerNameLabel);
		  labelPanel.add(numberOfPlayersLabel);
		  labelPanel.add(serverIPAddressLabel);
		  
		  
		  fields = new Component[labels.length];
		  fields[0] = playerNameTextField;
		  fields[1] = numberOfPlayersComboBox;
		  fields[2] = serverIPAddressTextField;
		  

		  for(int i = 0; i < labels.length; i++) {
			  
			  subFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		      subFieldPanel.setBackground(Color.decode("#BFDBAE"));
		      subFieldPanel.add(fields[i]);
		      fieldPanel.add(subFieldPanel);
			  
		  }
		  
	}
	
	
	
	


	public JTextField getPlayerNameTextField() {
		return playerNameTextField;
	}


	public JTextField getNumberOfPlayersTextField() {
		return numberOfPlayersTextField;
	}


	public JTextField getServerIPAddressTextField() {
		return serverIPAddressTextField;
	}
	
	
	
	public String getPlayerName() {
		return this.getPlayerNameTextField().getText();
	}
	
	public String getNumberOfPlayers() {
		return this.numberOfPlayersComboBox.getSelectedItem().toString();
	}
	
	public String getServerIPAddress() {
		return this.getServerIPAddressTextField().getText();
	}


	public String getSelectedPawnImageName() {
		
		return this.getPawnSelectionPanel().getSelectedPawnImageName();
	}
	
	public PawnSelectionPanel getPawnSelectionPanel() {
		return this.pawnSelectionPanel;
	}
	
	@SuppressWarnings("deprecation")
	public void switchToPlayerNumberSelectionState() {
		
		this.playerNameTextField.setEditable(false);
		playerNameTextField.disable();
		playerNameTextField.setText("Select number of players first.");
		this.getPawnSelectionPanel().disableAllPawns();
		
		
	}


	@SuppressWarnings("deprecation")
	public void switchToPlayerNameAndPawnSelectionState() {
		
		this.getPawnSelectionPanel().enableAllPawns();
		
		this.playerNameTextField.setEditable(true);
		playerNameTextField.enable();
		playerNameTextField.setText("");
		this.numberOfPlayersComboBox.setEnabled(false);

	}


	public void switchToStartGameState() {
		
		this.getPawnSelectionPanel().disableAllPawns();
		this.playerNameTextField.setEditable(false);
		playerNameTextField.disable();
		
	}
	
	
	











}
