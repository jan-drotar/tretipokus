package treti.pokus;

import java.util.ArrayList;
import java.util.List;

import treti.pokus.entity.Participant;
import treti.pokus.entity.Physician;
import treti.pokus.interfaces.ParticipantDao;

public class ParticipantMemoryDao implements ParticipantDao {
	
	private long lastId = 0;
	private List<Participant> participants = new ArrayList<Participant>();
	
	
	public ParticipantMemoryDao() {
	Participant p = new Participant();
	p.setName("Andrej");
	p.setSurname("Kiska");
	p.setEmail("prezident@prezident.sk");
	p.setInsuranceId("123");
	this.addParticipant(p);
	
	Participant p1 = new Participant();
	p1.setName("Andrej");
	p1.setSurname("Danko");
	p1.setEmail("predseda@nrsr.sk");
	p1.setInsuranceId("456");
	this.addParticipant(p1);
	}
	
	// CREATE
	@Override
	public void addParticipant(Participant p) {
		if(p!=null) {
			p.setId(++lastId);
			participants.add(p);
		}
	}
	// READ
	@Override
	public List<Participant> getAll(){
		return participants;
	}
	
	// find by surname ///
	@Override
	public List<Participant> findPhysicianByInsuranceId(String id) {
		List<Participant> novy = new ArrayList<Participant>();
		for (Participant participant : participants) {
			if (participant.getInsuranceId().equals(id)) {
				novy.add(participant);
			}
		}
		return novy;
	}
	// find by insuranceID ///
	@Override
	public List<Participant> findPhysicianBySurname(String s) {
		List<Participant> novy = new ArrayList<Participant>();
		for (Participant participant : participants) {
			if (participant.getSurname().equals(s)) {
				novy.add(participant);
			}
		}
		return novy;
	}
	// chcem idecko
	public long getLastId() {
		return this.lastId;
	}

}
