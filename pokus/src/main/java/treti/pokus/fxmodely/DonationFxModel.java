package treti.pokus.fxmodely;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import treti.pokus.entity.Donation;
import treti.pokus.enumy.DonationType;

public class DonationFxModel {
	
//donationType
	StringProperty donationType = new SimpleStringProperty();
	
	public String getDonationType() {
		return donationType.get();
	}
	public void setDonationType(String n) {
		this.donationType.set(n);
	}
	public StringProperty donationTypeProperty() {
		return donationType;
	}

	public Donation getDonation() {
		if (getDonationType() == null|| getDonationType().trim().isEmpty()) {
			return null;
		} else {
			Donation d = new Donation();
			d.setDonationType(DonationType.fromString(getDonationType()));
			d.setRegistered(LocalDate.now());
			return d;
		}
	}

}
