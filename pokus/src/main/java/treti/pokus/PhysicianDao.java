package treti.pokus;

import java.util.List;

public interface PhysicianDao {
	void add(Physician physician);

	void save(Physician physician);

	void delete(long id);

	List<Physician> getAll();

}
