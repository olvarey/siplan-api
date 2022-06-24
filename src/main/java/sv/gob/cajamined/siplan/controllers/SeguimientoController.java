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

import sv.gob.cajamined.siplan.entities.Seguimiento;
import sv.gob.cajamined.siplan.repositories.SeguimientoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class SeguimientoController {

	@Autowired
	private SeguimientoRepo seguimientoRepo;

	@GetMapping(value = "seguimientos")
	private List<Seguimiento> getAllAnios() {
		return seguimientoRepo.findByOrderByIdSeguimientoAsc();
	}

	@GetMapping(value = "seguimientos/{idSeguimiento}")
	private Optional<Seguimiento> getAnioById(@PathVariable Long idSeguimiento) {
		return seguimientoRepo.findById(idSeguimiento);
	}

	@PostMapping(value = "seguimientos")
	public Seguimiento createAnio(@RequestBody Seguimiento seguimiento) {
		return seguimientoRepo.save(seguimiento);
	}

	@DeleteMapping(value = "seguimientos")
	public void deleteAnio(@RequestBody Seguimiento seguimiento) {
		seguimientoRepo.delete(seguimiento);
	}
}
