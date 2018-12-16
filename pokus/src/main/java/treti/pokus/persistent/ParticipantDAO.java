package treti.pokus.persistent;

import java.util.ArrayList;
import java.util.List;

import treti.pokus.entity.Participant;
import treti.pokus.entity.Physician;

public class ParticipantDAO {
	
	private long lastId = 0;
	private List<Participant> participants = new ArrayList<>();
	
	
	public ParticipantDAO() {
		// TODO Auto-generated constructor stub
	
	Participant p = new Participant();
	p.setName("Andrej");
	p.setSurname("Kiska");
	p.setEmail("prezident@prezident.sk");
	p.setInsuranceID("123");
	this.addParticipant(p);
	
	Participant p1 = new Participant();
	p1.setName("Andrej");
	p1.setSurname("Danko");
	p1.setEmail("predseda@nrsr.sk");
	p1.setInsuranceID("456");
	this.addParticipant(p1);
	}
	
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
	
	// find by surname ///
	public List<Participant> findPhysicianByInsuranceId(String id) {
		List<Participant> novy = new ArrayList<>();
		for (Participant participant : participants) {
			if (participant.getInsuranceID().equals(id)) {
				novy.add(participant);
			}
		}
		return novy;
	}
	// find by insuranceID ///
	public List<Participant> findPhysicianBySurname(String s) {
		List<Participant> novy = new ArrayList<>();
		for (Participant participant : participants) {
			if (participant.getSurname().equals(s)) {
				novy.add(participant);
			}
		}
		return novy;
	}
	

}
