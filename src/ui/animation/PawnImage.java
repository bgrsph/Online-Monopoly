package ui.animation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ui.SquareHolder;

@SuppressWarnings("serial")
public class PawnImage implements Drawable {

	  private Path myPath;
	    private Point myPosition;
	    private int size;
	    private Image pawnImage;
	    public boolean isSupposedToMove;
	    private Point targetPosition;
	    private String imageName;
	    
	    /** 
	     *  Constructor, simply save the initial values.
	    */
	    public PawnImage(Point startPosition, int size, String pawnImageName) {
	    	this.size = size;
	    	this.imageName = pawnImageName;
	    	this.myPosition = startPosition;
	        this.pawnImage = this.getPawnImage(pawnImageName);
	        this.isSupposedToMove = false;
	    }
	@Override
	public void draw(Graphics g) {

		if (isSupposedToMove) {

			if (myPath != null && myPath.hasMoreSteps())
				myPosition = myPath.nextPosition();

			else {
				//int numberOfSteps = (int) (10.0 + (Math.random() * 100.0)); // Random for now. Should be at least 10 for
																			// visibility
				int numberOfSteps = 50;
				if (myPosition != targetPosition) {
					myPath = new StraightLinePath((int) myPosition.getX(), (int) myPosition.getY(),
							(int) targetPosition.getX(), (int) targetPosition.getY(), numberOfSteps);
					myPosition = myPath.nextPosition();
				} else {
					//this.isSupposedToMove = false;
				}
			}

			g.drawImage(pawnImage, (int) myPosition.getX(), (int) myPosition.getY(), this.size, this.size, null);

		} else {

			g.drawImage(pawnImage, (int) myPosition.getX(), (int) myPosition.getY(), this.size, this.size, null);

		}
	}

	public void moveTo(SquareHolder targetSquare) {
		this.isSupposedToMove = true;
		this.targetPosition = new Point((int)targetSquare.getX(),(int)targetSquare.getY());

	}
	

	public String getImageName() {
		return imageName;
	}
	  public Image getPawnImage(String imageName) {
			BufferedImage pawnImage = null;
			try {
				System.out.println("Generating the pawnImage according to name: " + imageName);
				System.out.println();
				pawnImage = ImageIO.read(new File("pawnImages/" + imageName.trim() + ".png"));

			} catch (IOException e) {

				e.printStackTrace();
			}

			Image scaledPawnImage = pawnImage.getScaledInstance(this.size, this.size, Image.SCALE_SMOOTH);
			return scaledPawnImage;
	    }

	

}
