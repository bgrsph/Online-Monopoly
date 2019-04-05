
package domain;

import java.io.Serializable;

public class Pawn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;




	/*
	 * CONSTRUCTOR
	 */
	public Pawn(String name) {
		
		super();
		this.name = name;

	}
	
	
	@Override
	public String toString() {
		
		return "\nPawn Name: " + name;
	
}
	/*
	 * GETTERS AND SETTERS
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
