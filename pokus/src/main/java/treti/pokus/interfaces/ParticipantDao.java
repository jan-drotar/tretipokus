package treti.pokus.interfaces;

import java.util.List;

import treti.pokus.entity.Participant;

public interface ParticipantDao {

	// CREATE
	void addParticipant(Participant p);

	// READ
	List<Participant> getAll();

	// find by surname ///
	List<Participant> findPhysicianByInsuranceId(String id);

	// find by insuranceID ///
	List<Participant> findPhysicianBySurname(String s);

}