package treti.pokus.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import treti.pokus.Notifikation;
import treti.pokus.enumy.BloodType;
import treti.pokus.enumy.Gender;
import treti.pokus.enumy.Role;

public class Participant {
	private Long id; 
	private Role role; 
	private BloodType bloodType; 
	private String name; 
	private String surname; 
	private String insuranceID; 
	private String email; 
	private String password; 
	private LocalDate dateOfBirth; 
	private Gender gender; 
	private double weight; 
	private LocalDate dateOfLastDonation; // setuje lekar 
	private int countOfDonations; // setuje lekar
	private boolean approved; // setuje lekar ked setne donation/
	private List<Notifikation> listOfNotifikations = new ArrayList<>();
	//age
	//remaining days

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public LocalDate getDateOfLastDonation() {
		return dateOfLastDonation;
	}

	public void setDateOfLastDonation(LocalDate dateOfLastDonation) {
		this.dateOfLastDonation = dateOfLastDonation;
	}

	public int getCountOfDonations() {
		return countOfDonations;
	}

	public void setCountOfDonations(int countOfDonations) {
		this.countOfDonations = countOfDonations;
	}

	public List<Notifikation> getListOfNotifikations() {
		return listOfNotifikations;
	}

	public void setListOfNotifikations(List<Notifikation> listOfNotifikations) {
		this.listOfNotifikations = listOfNotifikations;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", role=" + role + ", bloodType=" + bloodType + ", name=" + name + ", surname="
				+ surname + ", insuranceID=" + insuranceID + ", email=" + email + ", password=" + password
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", weight=" + weight + ", dateOfLastDonation="
				+ dateOfLastDonation + ", countOfDonations=" + countOfDonations + ", approved=" + approved
				+ ", listOfNotifikations=" + listOfNotifikations + "]";
	}

	
	
	
	

}
