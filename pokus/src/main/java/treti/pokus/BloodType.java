package treti.pokus;

public enum BloodType {

	A_POS("A+"), 
	A_NEG("A-"), 
	B_POS("B+"), 
	B_NEG("B-"), 
	AB_POS("AB+"), 
	AB_NEG("AB-"), 
	O_POS("0+"), 
	O_NEG("0-");

	private String label;

	private BloodType(String s) {
		this.label = s;
	}
	
	public String getText() {
	    return this.label;
	  }

	public static BloodType fromString(String text) {
	    for (BloodType b : BloodType.values()) {
	      if (b.label.equals(text)) {
	        return b;
	      }
	    }
	    return null;
	  }
}
