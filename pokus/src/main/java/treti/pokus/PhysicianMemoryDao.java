package treti.pokus;

import java.util.ArrayList;
import java.util.List;

public class PhysicianMemoryDao implements PhysicianDao {

	private long lastId = 0;
	private List<Physician> physicians = new ArrayList<>();

//		public PhysicianEditController() {
//			Physician physician1 = new Physician();
//			physician1.setId(10l);
//			physician1.setName("John");
//			physician1.setSurname("Button");
//			physician1.setPassword("heslo1");
//			physicians.add(physician1);
//			Physician physician2 = new Physician();
//			physician2.setId(100l);
//			physician2.setName("Marek");
//			physician2.setSurname("Bumarek");
//			physician2.setPassword("heslo2");
//			physicians.add(physician2);
//		}

	// CREATE
	public void add(Physician physician) {
		if (physician != null) {
			physician.setId(++lastId);
			physicians.add(physician);
		}
	}

	// READ
	public List<Physician> getAll() {
		return physicians;
	}
	// count
	public int physicianCount() {
		return physicians.size();
	}

	public Physician findPhysicianById(Integer id) {
		for (int i = 0; i < physicians.size(); i++) {
//			if (physicians.get(i).getId() == id)
				return physicians.get(i);
		}
		return null;
	}

	@Override
	public Physician findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Physician> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Physician> findBySurname(String surName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Physician physician) {
		// TODO Auto-generated method stub
		
	}
	

}
