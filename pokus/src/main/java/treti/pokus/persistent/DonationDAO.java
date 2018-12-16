package treti.pokus.persistent;

import java.util.ArrayList;
import java.util.List;

import treti.pokus.entity.Donation;

public class DonationDAO {
	
	// CREATE
	// READ
	// UPDATE
	// DELETE
	
	private long lastId = 0;
	private List<Donation> donations = new ArrayList<>();
	
	// CREATE
	public void addDonation(Donation d) {
		if(d!=null) {
			d.setId(++lastId);
			donations.add(d);
		}
	}
	// READ
	public List<Donation> getAll(){
		return donations;
	}
	///////////////////////////////// find compatible for whole blood
	///////////////////////////////// find copmatible for plasme
	///////////////////////////////// find untested

}
