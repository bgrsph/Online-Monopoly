package domain;
   
public enum FaceVal {
	BUSICON(100), MRMONOPOLY(111), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);
	  
	private final int value; 
	
	FaceVal(int value) { 
		 this.value = value;
		 }
	
	 public int getValue() { 
		 return value; 
		 }
	  
	 
	 public static FaceVal fromIntegerToFaceVal(int x) {
		 
		 switch(x) {
		 
		 case 100:  return BUSICON; 
		 case 111:  return MRMONOPOLY;
		 case 1:  return ONE;
		 case 2:  return TWO;
		 case 3:  return THREE;
		 case 4:  return FOUR;
		 case 5:  return FIVE;
		 case 6:  return SIX;
		 default: return SIX;
			 
		 }
	 }
		 
}
  