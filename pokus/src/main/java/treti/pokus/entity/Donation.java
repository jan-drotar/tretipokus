package treti.pokus.entity;

import java.time.LocalDate;

import treti.pokus.enumy.DonationType;

public class Donation {
	
	private Long id;
	private DonationType donationType;
	private Long idDonor;
	private Long idRecipient;
	private Long idPhysician;
	private boolean tested;
	private boolean approved;
	private LocalDate registered;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DonationType getDonationType() {
		return donationType;
	}
	public void setDonationType(DonationType donationType) {
		this.donationType = donationType;
	}
	public Long getIdDonor() {
		return idDonor;
	}
	public void setIdDonor(Long idDonor) {
		this.idDonor = idDonor;
	}
	public Long getIdRecipient() {
		return idRecipient;
	}
	public void setIdRecipient(Long idRecipient) {
		this.idRecipient = idRecipient;
	}
	
	public Long getIdPhysician() {
		return idPhysician;
	}
	public void setIdPhysician(Long idPhysician) {
		this.idPhysician = idPhysician;
	}
	public boolean isTested() {
		return tested;
	}
	public void setTested(boolean tested) {
		this.tested = tested;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public LocalDate getRegistered() {
		return registered;
	}
	public void setRegistered(LocalDate registered) {
		this.registered = registered;
	}
	@Override
	public String toString() {
		return "Donation [id=" + id + ", donationType=" + donationType + ", idDonor=" + idDonor + ", idRecipient="
				+ idRecipient + ", idPhysician=" + idPhysician + ", tested=" + tested + ", approved=" + approved
				+ ", registered=" + registered + "]";
	}
	
	
	

}
