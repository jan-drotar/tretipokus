package treti.pokus;

import java.util.ArrayList;
import java.util.List;

public class PhysicianDAO {
	
	// CREATE
	// READ
	// UPDATE
	// DELETE
	
	private long lastId = 0;
	private List<Physician> physicians = new ArrayList<>();
	
	// CREATE
	public void addPhysician(Physician p) {
		if(p!=null) {
			p.setId(++lastId);
			physicians.add(p);
		}
	}
	// READ
	public List<Physician> getAll(){
		return physicians;
	}

}
