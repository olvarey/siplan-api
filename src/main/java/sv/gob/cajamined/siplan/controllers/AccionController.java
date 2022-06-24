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

import sv.gob.cajamined.siplan.entities.Accion;
import sv.gob.cajamined.siplan.repositories.AccionRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class AccionController {

	@Autowired
	private AccionRepo accionRepo;

	@GetMapping(value = "acciones")
	private List<Accion> getAllAnios() {
		return accionRepo.findByOrderByIdAccionAsc();
	}

	@GetMapping(value = "acciones/{idAccion}")
	private Optional<Accion> getAnioById(@PathVariable Long idAccion) {
		return accionRepo.findById(idAccion);
	}

	@PostMapping(value = "acciones")
	public Accion createAnio(@RequestBody Accion accion) {
		return accionRepo.save(accion);
	}

	@DeleteMapping(value = "acciones")
	public void deleteAnio(@RequestBody Accion accion) {
		accionRepo.delete(accion);
	}
}
