package domain.cards;

import java.io.Serializable;

public abstract class Card implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isDisposable;
	private String type;
	
	public Card(String cardType, boolean isDisposible) {
		this.type = cardType;
		this.isDisposable = isDisposible;
	}
 
	
	public abstract void useCard();
	
	public String getName() {
		return this.getClass().getSimpleName();
	}


	public boolean isDisposable() {
		return isDisposable;
	}


	public void setDisposable(boolean isDisposable) {
		this.isDisposable = isDisposable;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String  toString() {
		
		return "[" + this.getName() + "]"; 
	}
	
}


