package ui;

public class SquareHolder {
	
	private double x;
	private double y;
	private static double width;
	private static double height;
	private String squareName;
	
	
	
	
	public SquareHolder(String squareName, double x, double y) {
		this.squareName = squareName;
		this.x = x;
		this.y = y;
	}
	
	
	public String getSquareName() {
		return squareName;
	}
	
	public void setSquareName(String squareName) {
		this.squareName = squareName;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	

}
