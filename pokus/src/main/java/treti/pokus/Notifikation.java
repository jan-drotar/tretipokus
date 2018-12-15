package treti.pokus;

public class Notifikation {
	
	private int id;
	private String lekar;
	private String sprava;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setLekar(String lekar) {
		this.lekar = lekar;
	}
	public void setSprava(String sprava) {
		this.sprava = sprava;
	}
	@Override
	public String toString() {
		return "(" + id + ") \"" + sprava + "\" " + lekar;
	}
	
	

}
