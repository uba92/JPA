package org.example.DAO;

import org.example.Persona;

import java.util.List;

public interface PersonaDAO {
    void save(Persona persona);

    Persona findById(Long id);

    void deleteById(Long id);

    List<Persona> findAll();
}
