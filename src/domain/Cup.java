package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Cup implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FaceVal> results;
	private int numberOfCopies;
	private int totalFaceValue;
	public static boolean isRolled=false;
	public Cup() {
		this.results=new ArrayList<>();
	}
	


	public void rollDice(int x) {
		results.clear();
		RegularDie rDie = new RegularDie();
		SpeedDie sDie = new SpeedDie();
//		
//		results.add(FaceVal.TWO);
//		results.add(FaceVal.FIVE);
//		results.add(FaceVal.TWO);

		
		if (x == 2) {
			for (int i = 0; i < 2; i++) {
				results.add(rDie.faceVal());
				totalFaceValue += results.get(i).getValue();
			}
			results.add(sDie.faceVal());
			if (sDie.faceVal().getValue() < 4) {
				totalFaceValue += sDie.getFaceValue();
				
			} else if (sDie.faceVal().equals(FaceVal.MRMONOPOLY)) {
				// Player.move(totalFaceValue);
				// Player.doSpeedAction(MrMonopoly);
			} else if (sDie.faceVal().equals(FaceVal.BUSICON)) {
				// Player.move(totalFaceValue);
				// Player.doSpeedAction(BusIcon);
			}
		}

		else if (x == 3) {
			
			for (int i = 0; i < 3; i++) {
				results.add(rDie.faceVal());
				totalFaceValue += results.get(i).getValue();
			}

		}
		isRolled = true;
	}
	
	
	
	public String toString() {
		return "Cup: " + results;
	}



	public ArrayList<FaceVal> getResults() {
		return results;
	}



	public void setResults(ArrayList<FaceVal> results) {
		this.results = results;
	}



	public int getTotalFaceValue() {
		return totalFaceValue;
	}



	private void setTotalFaceValue(int totalFaceValue) {
		this.totalFaceValue = totalFaceValue;
	}
	
	public boolean isSpecial() {
		if(this.results.contains(FaceVal.BUSICON)||this.results.contains(FaceVal.MRMONOPOLY)) {
			return true;
		}
		return false;
	}
	
	public boolean isDouble() {
		if (results.get(0).getValue() == results.get(1).getValue() && this.isTriple()==false) return true;
		else return false;
	}
	
	public boolean isTriple() {
		if (results.get(0).getValue() == results.get(1).getValue() && results.get(0).getValue()== results.get(2).getValue()) return true;
		else return false;
	}
}
