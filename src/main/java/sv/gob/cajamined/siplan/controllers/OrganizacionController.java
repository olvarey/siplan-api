package sv.gob.cajamined.siplan.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.gob.cajamined.siplan.entities.Organizacion;
import sv.gob.cajamined.siplan.repositories.OrganizacionRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class OrganizacionController {

	@Autowired
	private OrganizacionRepo organizacionRepo;

	@GetMapping(value = "organizaciones")
	private List<Organizacion> getAllOrganizaciones() {
		return organizacionRepo.findByOrderByIdOrganizacionAsc();
	}

	@GetMapping(value = "organizaciones/{idOrganizacion}")
	private Optional<Organizacion> getOrganizacionById(@PathVariable Long idOrganizacion) {
		return organizacionRepo.findById(idOrganizacion);
	}

	@PostMapping(value = "organizaciones")
	public Organizacion createOrganizacion(@RequestBody Organizacion organizacion) {
		return organizacionRepo.save(organizacion);
	}

	@DeleteMapping(value = "organizaciones")
	public void deleteOrganizacion(@RequestBody Organizacion organizacion) {
		organizacionRepo.delete(organizacion);
	}
}
