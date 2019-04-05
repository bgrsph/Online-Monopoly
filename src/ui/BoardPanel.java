package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel {

	int boardWidth;
	int boardHeight;
	Image img;
	JLabel imageLabel;
	

	
	public BoardPanel(String img, int width, int height) {
			
	    this(new ImageIcon(img).getImage(),width, height);
	   
	  }

	public BoardPanel(Image image, int width, int height) {
		
		this.img = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);;
	    Dimension size = new Dimension(width, height);
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);

	  
	}
	
	

	public void paintComponent(Graphics g) {
		    g.drawImage(img, 0, 0, null);
		  
		
		  }
	
	

}


