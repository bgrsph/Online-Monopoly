package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import domain.MonopolyGameController;

public class MenuFrame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton loadButton;
	private JButton saveButton;
	private JButton pauseButton;
	private JButton resumeButton;
	private JPanel menuPanel;
	public LoadSaveFrame loadSaveFrame;
	




	public MenuFrame() {
		super("Setup");
		initMenuFrameObjects();
		pack();
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "loadGame":
			loadSaveFrame = new LoadSaveFrame();
			
		
			break;
			
		case "pauseGame":
			MonopolyGameController.getInstance().pauseGame();
			MonopolyGameFrame.getInstance().switchToPauseState();
			break;
			
		case "saveGame":
			loadSaveFrame = new LoadSaveFrame();
			break;
			
			
		case "resumeGame":
			MonopolyGameController.getInstance().resumeGame();
			MonopolyGameFrame.getInstance().switchToResumeState();
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
		
		
		pauseButton = new JButton("Pause");
		pauseButton.addActionListener(this);
		pauseButton.setActionCommand("pauseGame");
		
		resumeButton = new JButton("Resume");
		resumeButton.addActionListener(this);
		resumeButton.setActionCommand("resumeGame");
		
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.decode("#BFDBAE"));
		Border border = BorderFactory.createTitledBorder("Menu Panel");
		menuPanel.setBorder(border);
		
		menuPanel.add(loadButton);
		menuPanel.add(saveButton);
		menuPanel.add(pauseButton);
		menuPanel.add(resumeButton);
		
		this.add(menuPanel);
	}

}
