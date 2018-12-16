package treti.pokus.persistent;

import java.util.ArrayList;
import java.util.List;

import treti.pokus.entity.Participant;

public class ParticipantDAO {
	
	// CREATE
	// READ
	// UPDATE
	// DELETE
	
	private long lastId = 0;
	private List<Participant> participants = new ArrayList<>();
	
	// CREATE
	public void addParticipant(Participant p) {
		if(p!=null) {
			p.setId(++lastId);
			participants.add(p);
		}
	}
	// READ
	public List<Participant> getAll(){
		return participants;
	}
	// find by surname //////////////////////////////////////////////
	// find by insuranceID //////////////////////////////////////////
	

}
