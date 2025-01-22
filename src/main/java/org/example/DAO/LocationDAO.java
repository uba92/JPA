package org.example.DAO;

import org.example.Location;

import java.util.List;

public interface LocationDAO {

    void save(Location location);

    Location findById(Long id);

    void deleteById(Long id);

    List<Location> findAll();
}
