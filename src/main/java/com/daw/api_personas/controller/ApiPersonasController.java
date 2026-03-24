package com.daw.api_personas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.api_personas.Service.PersonaService;
import com.daw.api_personas.entity.Persona;

@RestController
@RequestMapping("/personas")
public class ApiPersonasController {

    private PersonaService servicio;

    public ApiPersonasController(PersonaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Persona> listar() {
        System.out.println("Patata");
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Persona obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @PostMapping
    public Persona crear(@RequestBody Persona p) {
        return servicio.guardar(p);
    }

    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @RequestBody Persona datos) {
        Persona p = servicio.obtener(id);
        p.setNombre(datos.getNombre());
        p.setApellidos(datos.getApellidos());
        p.setEdad(datos.getEdad());
        return servicio.guardar(p);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        servicio.borrar(id);
    }

    // Buscar por nombre
    @GetMapping("/nombre/{nombre}")
    public List<Persona> buscarPorNombre(@PathVariable String nombre) {
        return servicio.buscarPorNombre(nombre);
    }

    // Buscar por apellidos
    @GetMapping("/apellidos/{apellidos}")
    public List<Persona> buscarPorApellidos(@PathVariable String apellidos) {
        return servicio.buscarPorApellidos(apellidos);
    }

    // Listar menores de edad
    @GetMapping("/menores")
    public List<Persona> menores() {
        return servicio.menoresEdad(18);
    }

    // Listar mayores de edad
    @GetMapping("/mayores")
    public List<Persona> mayores() {
        return servicio.mayoresEdad(18);
    }

    @PostMapping("/crearlista")
    public List<Persona> crearLista(@RequestBody List<Persona> personas) {
        return personas.stream()
                .map(persona -> servicio.guardar(persona))
                .toList();
    }
}
