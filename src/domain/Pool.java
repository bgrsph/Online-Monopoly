package domain;

import java.io.Serializable;

public class Pool implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double amountPoolMoney;
	
	public Pool() {
		this.amountPoolMoney = 0;
	}
	
	
	public void splitMoneyAndDecreaseMoney() {
		
		double splittedMoney;
		if(amountPoolMoney % 2 == 0) {
			splittedMoney = amountPoolMoney / 2;	
		}
		double roundedMoney = Math.round(amountPoolMoney);
		splittedMoney = roundedMoney / 2;
		amountPoolMoney = amountPoolMoney - splittedMoney;
	}
	
	public double getPoolMoney() {
		return amountPoolMoney;
	}
	
	public void setPoolMoney(double fee) {
		amountPoolMoney = fee;
	}


	@Override
	public String toString() {
		return "Pool: " + amountPoolMoney;
	}


	public void increaseMoney(int i) {
		amountPoolMoney += i;
		
	}
	

	
	
}