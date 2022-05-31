package sv.gob.cajamined.siplan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.gob.cajamined.siplan.entities.Organizacion;
import sv.gob.cajamined.siplan.repositories.OrganizacionRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class OrganizacionController {

    @Autowired
    private OrganizacionRepo organizacionRepo;

    @GetMapping(value = "organizaciones")
    private List<Organizacion> getAllOrganizaciones() {
        return organizacionRepo.findAll();
    }

    @GetMapping(value = "organizaciones/{idOrganizacion}")
    private Optional<Organizacion> getOrganizacionById(@PathVariable Long idOrganizacion) {
        return organizacionRepo.findById(idOrganizacion);
    }

    @PostMapping(value = "organizaciones")
    public Organizacion createOrganizacion(@RequestBody Organizacion organizacion) {
        return organizacionRepo.save(organizacion);
    }
}
