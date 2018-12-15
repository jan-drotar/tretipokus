package treti.pokus;

import java.util.List;

public interface PhysicianDao {
 Physician findById(Integer id);
 List<Physician> findByName(String name);
 List<Physician> findBySurname(String surName);
 void add(Physician physician);
 void delete(Physician physician);
}
