package treti.pokus.interfaces;

import java.util.List;

import treti.pokus.entity.Donation;
import treti.pokus.enumy.BloodType;

public interface DonationDao {

	void addDonation(Donation donation);

	List<Donation> getAll();
	
	void save(Donation donation);
//	TODO
	///////////////////////////////// find compatible for whole blood
	///////////////////////////////// find copmatible for plasme
	///////////////////////////////// find untested

}