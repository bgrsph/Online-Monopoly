package ui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;



public class DieGraphics implements Icon{
	
	public String[] regularDieArray;
	public String[] speedDieArray;
		
	private ImageParser imageParser;
	private int a;
	private int b;

	
	public DieGraphics(String die, int a,int b){
		Image img = new ImageIcon(die).getImage(); //To get the icons of the dice 
		this.imageParser = new ImageParser(img);
		this.a = a;
		this.b = b;
	}
	
	
	
	
	public int getIconWidth() {
		return 50;
	}

	public int getIconHeight() {
		return 170;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		imageParser.draw(g2, this.a, this.b);
	}

	public void changeDieImage(String img) {
		imageParser.changeImage(new ImageIcon(img).getImage());
	}
	
	public void createRegularDie() {
		regularDieArray = new String[8];
		regularDieArray[0] = "diceone.jpg";
		regularDieArray[1] = "diceone.jpg";
		regularDieArray[2] = "dicetwo.jpg";
		regularDieArray[3] = "dicethree.jpg";
		regularDieArray[4] = "dicefour.jpg";
		regularDieArray[5] = "dicefive.jpg";
		regularDieArray[6] = "dicesix.jpg";
		
	}
	
	public void createSpeedDie() {
		speedDieArray = new String[8];
		speedDieArray[0] = "diceone.jpg";
		speedDieArray[1] = "diceone.jpg";
		speedDieArray[2] = "dicetwo.jpg";
		speedDieArray[3] = "dicethree.jpg";
		speedDieArray[4] = "dicemrmonopoly.jpg";
		speedDieArray[5] = "dicemrmonopoly.jpg";
		speedDieArray[6] = "dicebus.jpg";
	
	}
	

	
	public class ImageParser {

		private Image image;
		
		
		public ImageParser(Image i) {
			this.image = i;
		}
		
		public int getWidth() {
			return image.getWidth(null);
		}
		
		public int getHeight() {
			return image.getHeight(null);
		}
		
		public void draw(Graphics2D g2,int x,int y) {
			g2.drawImage(image,x,y, null);
		}

		public void changeImage(Image image) {
			this.image = image;
		}
		
	}

}
