package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
 
public class SpeedDie extends Die {
	private int faceValue;
	ArrayList<FaceVal> faceVals = new ArrayList<FaceVal>(
	Arrays.asList(FaceVal.ONE, FaceVal.TWO, FaceVal.THREE, FaceVal.BUSICON, FaceVal.MRMONOPOLY, FaceVal.BUSICON));

	
	public FaceVal faceVal() {
		Random r = new Random();
		return faceVals.get(r.nextInt(6));

	}

	

		
	
	
}
