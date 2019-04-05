package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

 
public class RegularDie extends Die {
	private int faceValue;
	ArrayList<FaceVal> faceVals = new ArrayList<FaceVal>(
			Arrays.asList(FaceVal.ONE, FaceVal.TWO, FaceVal.THREE, FaceVal.FOUR, FaceVal.FIVE, FaceVal.SIX));

	public FaceVal faceVal() {
		Random r = new Random();
		return faceVals.get(r.nextInt(6));
		
		
	}
}
