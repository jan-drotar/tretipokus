package treti.pokus.persistent;

import java.util.List;

import treti.pokus.entity.Physician;

public interface PhysicianDao {
	void add(Physician physician);

	void update(Physician physician);

	void delete(long id);

	List<Physician> getAll();

}
