package treti.pokus;

public enum Gender {
	MALE("male"),
	FEMALE("female");
	
	private String label;

	private Gender(String s) {
		this.label = s;
	}
	
	public String getText() {
	    return this.label;
	  }

	public static Gender fromString(String text) {
	    for (Gender b : Gender.values()) {
	      if (b.label.equals(text)) {
	        return b;
	      }
	    }
	    return null;
	  }

}
