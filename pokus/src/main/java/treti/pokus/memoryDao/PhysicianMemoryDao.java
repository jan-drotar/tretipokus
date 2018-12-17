package treti.pokus.memoryDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import treti.pokus.entity.Physician;
import treti.pokus.interfaces.PhysicianDao;

public class PhysicianMemoryDao implements PhysicianDao {

	private long lastId = 0;
	private List<Physician> physicians = new ArrayList<>();

	public PhysicianMemoryDao() {
		Physician physician1 = new Physician();
		physician1.setId(10l);
		physician1.setName("John");
		physician1.setSurname("Button");
		physician1.setPassword("heslo1");
		physicians.add(physician1);
		Physician physician2 = new Physician();
		physician2.setId(100l);
		physician2.setName("Marek");
		physician2.setSurname("Bumarek");
		physician2.setPassword("heslo2");
		physicians.add(physician2);
		System.out.println(physicians.toString());
	}

	public void add(Physician physician) {
		if (physician != null) {
			physician.setId(++lastId);
			physicians.add(physician);
		}
	}

	public List<Physician> getAll() {
		return physicians;
	}

	public int physicianCount() {
		return physicians.size();
	}

	public Physician findPhysicianById(Long id) {
		for (int i = 0; i < physicians.size(); i++) {
			if (physicians.get(i).getId() == id)
				return physicians.get(i);
		}
		return null;
	}

	@Override
	public void save(Physician physician) {
		if (physician != null) {
			if (physician.getId() == null) {
				add(physician);
			} else {
				for (int i = 0; i < physicians.size(); i++) {
					if (physicians.get(i).getId().equals(physician.getId())) {
						physicians.set(i, physician);
						break;
					}
				}
			}
		}
	}

	@Override
	public void delete(long id) {
		Iterator<Physician> it = physicians.iterator();
		while (it.hasNext()) {
			Physician p = it.next();
			if (p.getId().equals(id)) {
				it.remove();
				return;
			}
		}
	}

}

