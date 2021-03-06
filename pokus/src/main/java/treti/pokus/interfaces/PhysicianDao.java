package treti.pokus.interfaces;

import java.util.List;

import treti.pokus.entity.Physician;

public interface PhysicianDao {
	
	void add(Physician physician);

	void save(Physician physician);

	void delete(long id);

	List<Physician> getAll();

}
