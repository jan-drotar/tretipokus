package treti.pokus.enumy;

public enum DonationType {
	WHOLE_BLOOD("Whole Blood"),
	PLASMA("Plasma");
	
	private String label;

	private DonationType(String s) {
		this.label = s;
	}
	
	public String getText() {
	    return this.label;
	  }

	public static DonationType fromString(String text) {
	    for (DonationType b : DonationType.values()) {
	      if (b.label.equals(text)) {
	        return b;
	      }
	    }
	    return null;
	  }
}
