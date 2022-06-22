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

import sv.gob.cajamined.siplan.entities.LineaTrabajo;
import sv.gob.cajamined.siplan.repositories.LineaTrabajoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class LineaTrabajoController {

	@Autowired
	private LineaTrabajoRepo lineaTrabajoRepo;

	@GetMapping(value = "lineas-trabajo")
	private List<LineaTrabajo> getAllLineasTrabajo() {
		return lineaTrabajoRepo.findByOrderByIdLineaTrabajoAsc();
	}

	@GetMapping(value = "lineas-trabajo/{idLineaTrabajo}")
	private Optional<LineaTrabajo> getLineaTrabajoById(@PathVariable Long idLineaTrabajo) {
		return lineaTrabajoRepo.findById(idLineaTrabajo);
	}

	@PostMapping(value = "lineas-trabajo")
	public LineaTrabajo createLineaTrabajo(@RequestBody LineaTrabajo lineaTrabajo) {
		return lineaTrabajoRepo.save(lineaTrabajo);
	}

	@DeleteMapping(value = "lineas-trabajo")
	public void deleteLineaTrabajo(@RequestBody LineaTrabajo lineaTrabajo) {
		lineaTrabajoRepo.delete(lineaTrabajo);
	}
}
