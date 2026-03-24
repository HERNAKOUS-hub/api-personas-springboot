package com.daw.api_personas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daw.api_personas.entity.Persona;
import com.daw.api_personas.repository.PersonaRepository;

@Service
public class PersonaService {

    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> listar() {
        return personaRepository.findAll();

    }

    public Persona obtener(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public Persona guardar(Persona p) {
        return personaRepository.save(p);
    }

    public void actualizar(Long id, Persona datos) {
        Persona p = obtener(id);
        if (p != null) {
            p.setNombre(datos.getNombre());
            p.setApellidos(datos.getApellidos());
            p.setEdad(datos.getEdad());
            guardar(p);
        }
    }

    public void borrar(Long id) {
        personaRepository.deleteById(id);
    }

    public List<Persona> buscarPorNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    public List<Persona> buscarPorApellidos(String apellidos) {
        return personaRepository.findByApellidos(apellidos);
    }
    
    public List<Persona> menoresEdad(int edad) {
        return personaRepository.findByEdadLessThan(edad);
    }

    public List<Persona> mayoresEdad(int edad) {
        return personaRepository.findByEdadGreaterThan(edad);
    }

    

}
