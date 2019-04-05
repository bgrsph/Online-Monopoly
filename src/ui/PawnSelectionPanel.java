package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PawnSelectionPanel extends JPanel implements ActionListener {

	final int NUMBER_OF_PAWN_IMAGES = 12;

	private String selectedPawnImageName;
	private boolean isPawnSelected = false;
	private ArrayList<JButton> pawnImageButtons;

	public PawnSelectionPanel() {
		super(new GridLayout(2, 6));
		this.setBackground(Color.decode("#BFDBAE"));
		initAndDrawPawnImageButtons();

	}

	/*
	 * Initiates all the buttons. Reads project folder for pawn images Modifies all
	 * the buttons such that every button is representing a pawn image
	 */
	private void initAndDrawPawnImageButtons() {

		pawnImageButtons = new ArrayList<JButton>();

		for (int i = 0; i < NUMBER_OF_PAWN_IMAGES; i++) {
			pawnImageButtons.add(new JButton());
		} 

		for (int i = 0; i < NUMBER_OF_PAWN_IMAGES; i++) {

			JButton currentPawnButton = pawnImageButtons.get(i);

			currentPawnButton.setSize(50, 50);
			currentPawnButton.addActionListener(this);
			currentPawnButton.setActionCommand("pawn" + i);

			// read pawn image from the project directory
			BufferedImage pawnImage = null;
			try {
				pawnImage = ImageIO.read(new File("pawnImages/pawn" + i + ".png"));
				
			} catch (IOException e) {

				e.printStackTrace();
			}

			// resize the image to fit into button size. This method can be applied to any
			// object
			Image scaledPawnImage = pawnImage.getScaledInstance(currentPawnButton.getWidth(),
					currentPawnButton.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledPawnImageIcon = new ImageIcon(scaledPawnImage);
			currentPawnButton.setIcon(scaledPawnImageIcon);

			// add current button to panel
			this.add(currentPawnButton);

		}

	}

	public void setSelectedPawnImageName(String selectedPawnImageName) {
		this.selectedPawnImageName = selectedPawnImageName;
	}

	public String getSelectedPawnImageName() {

		return selectedPawnImageName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "pawn0":
			setSelectedPawnImageName("pawn0");
			this.pawnImageButtons.get(0).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn1":
			setSelectedPawnImageName("pawn1");
			this.pawnImageButtons.get(1).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn2":
			setSelectedPawnImageName("pawn2");
			this.pawnImageButtons.get(2).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn3":
			setSelectedPawnImageName("pawn3");
			this.pawnImageButtons.get(3).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn4":
			setSelectedPawnImageName("pawn4");
			this.pawnImageButtons.get(4).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn5":
			setSelectedPawnImageName("pawn5");
			this.pawnImageButtons.get(5).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn6":
			setSelectedPawnImageName("pawn6");
			this.pawnImageButtons.get(6).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn7":
			setSelectedPawnImageName("pawn7");
			this.pawnImageButtons.get(7).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn8":
			setSelectedPawnImageName("pawn8");
			this.pawnImageButtons.get(8).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn9":
			setSelectedPawnImageName("pawn9");
			this.pawnImageButtons.get(9).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn10":
			setSelectedPawnImageName("pawn10");
			this.pawnImageButtons.get(10).setEnabled(false);
			isPawnSelected = true;
			break;

		case "pawn11":
			setSelectedPawnImageName("pawn11");
			this.pawnImageButtons.get(11).setEnabled(false);
			isPawnSelected = true;
			break;

		default:
			System.out.println("PawnImageButtonProblem");
			break;

		}

	}

	public boolean isPawnSelected() {
		
		return this.isPawnSelected;
	}
	
	public void disableAllPawns() {
		
		for(JButton pawnButton : pawnImageButtons) {
			pawnButton.setEnabled(false);
		}
	}
	
	public void enableAllPawns() {
		
		for(JButton pawnButton : pawnImageButtons) {
			pawnButton.setEnabled(true);
			
			
		}
	}
	
}










