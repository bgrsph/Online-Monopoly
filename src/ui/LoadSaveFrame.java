package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import domain.MonopolyGameController;

public class LoadSaveFrame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton loadButton;
	private JButton saveButton;

	private JPanel menuPanel;
	
	private JComboBox loadCombo;
	
	private JTextArea newSaveGameFillerArea;
	
	private ArrayList<File> previouslySavedGames = new ArrayList<File>();
	private boolean gitIgnoreChecker;
	private boolean dotProjectChecker;
	private boolean jpgChecker;
	private boolean dotClassPathChecker;
	private boolean dotDSStoreChecker;
	private boolean wavChecker;




	public LoadSaveFrame() {
		super("Setup");
		
		initMenuFrameObjects();
		pack();
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "loadGame":
			MonopolyGameController.getInstance();
			MonopolyGameController.loadGame(loadCombo.getSelectedItem().toString());
//			MonopolyGameController.loadGame("debugSaveFile");

			//MonopolyGameFrame.getInstance().repaint();
//			for(File f: previouslySavedGames) {
//				if(f.getName().equals(loadCombo.getSelectedItem().toString())) {
//					MonopolyGameController.loadGame(loadCombo.getSelectedItem().toString());
//				}
//			}
		
			this.setVisible(false);
			break;
			
		
			
		case "saveGame":
			MonopolyGameController.getInstance();
			MonopolyGameController.saveGame(newSaveGameFillerArea.getText());
			System.out.println("Game is saved");
			
			this.setVisible(false);
			
			break;
			
			
		}
		
	}
	
	
	
	public void initMenuFrameObjects() {
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.getContentPane().setBackground(Color.decode("#BFDBAE"));
		
		
		loadButton = new JButton("Load");
		
		loadButton.addActionListener(this);
		loadButton.setActionCommand("loadGame");
		
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		saveButton.setActionCommand("saveGame");
		
		loadCombo = new JComboBox();
		savedGameAdder(loadCombo);
		loadCombo.setSize(100,50);
		
		newSaveGameFillerArea = new JTextArea("Enter File Name");
		newSaveGameFillerArea.setSize(100,50);
		newSaveGameFillerArea.setVisible(true);
		

		menuPanel = new JPanel();
		menuPanel.setBackground(Color.decode("#BFDBAE"));
		Border border = BorderFactory.createTitledBorder("Load and Save Panel");
		menuPanel.setBorder(border);
		
		menuPanel.add(loadButton);
		menuPanel.add(saveButton);
		menuPanel.add(newSaveGameFillerArea);
		menuPanel.add(loadCombo);
		
		
		this.add(menuPanel);
	}
	
	public void previouslySavedGameAdder(JComboBox loadCombo2) {
//		String path = ("C:\\Users\\OrÁun\\git\\302_2018_project_ecayl");
		
		String path = new File("").getAbsolutePath();
	    System.out.println(path);
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		
		for(File file : listOfFiles) {
			if(file.isFile()) {
				
				jpgChecker = file.getName().endsWith(".jpg");
				gitIgnoreChecker = file.getName().endsWith(".gitignore");
				dotProjectChecker = file.getName().endsWith(".project");
				dotClassPathChecker = file.getName().endsWith(".classpath");
				dotDSStoreChecker = file.getName().endsWith(".DS_Store");
				wavChecker = file.getName().endsWith(".wav");
				
				if(!jpgChecker && !gitIgnoreChecker && !dotProjectChecker && !dotClassPathChecker && !dotDSStoreChecker && !wavChecker) {	
				previouslySavedGames.add(file);
				loadCombo2.addItem(file.getName());
				
				}
			}
		}
	}
	
	
	public void savedGameAdder(JComboBox loadCombo2) {
		MonopolyGameController.getInstance();
		//MonopolyGameController.getPreviouslySavedGames();
		previouslySavedGameAdder(loadCombo2);
		for(String s : MonopolyGameController.getSaveMap().keySet()) {
			MonopolyGameController.getInstance();
			loadCombo2.addItem(s);
			}
	}

}
