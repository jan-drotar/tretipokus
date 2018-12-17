package treti.pokus.memoryDao;

import java.util.ArrayList;
import java.util.List;

import treti.pokus.entity.Donation;
import treti.pokus.enumy.DonationType;
import treti.pokus.interfaces.DonationDao;

public class DonationMemoryDao implements DonationDao {

	// UPDATE
	// DELETE

	private long lastId = 0;
	private List<Donation> donations = new ArrayList<Donation>();

	public DonationMemoryDao() {
		Donation d = new Donation();
		d.setDonationType(DonationType.WHOLE_BLOOD);
		this.addDonation(d);
		Donation d2 = new Donation();
		d2.setDonationType(DonationType.PLASMA);
		this.addDonation(d2);
	}

	// CREATE
	@Override
	public void addDonation(Donation d) {
		if (d != null) {
			d.setId(++lastId);
			donations.add(d);
		}
	}

	// READ
	@Override
	public List<Donation> getAll() {
		return donations;
	}
	///////////////////////////////// find compatible for whole blood
	///////////////////////////////// find copmatible for plasme
	///////////////////////////////// find untested

	@Override
	public void save(Donation donation) {
		// TODO Auto-generated method stub

	}

}
