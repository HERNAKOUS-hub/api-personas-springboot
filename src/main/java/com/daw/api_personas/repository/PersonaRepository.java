package com.daw.api_personas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.api_personas.entity.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    List<Persona> findByNombre(String nombre);

    List<Persona> findByApellidos(String apellidos);

    List<Persona> findByEdadGreaterThan(int edad);

    List<Persona> findByEdadLessThan(int edad);


}
