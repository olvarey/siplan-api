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

import sv.gob.cajamined.siplan.entities.SeguimientoRiesgo;
import sv.gob.cajamined.siplan.repositories.SeguimientoRiesgoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class SeguimientoRiesgoController {

	@Autowired
	private SeguimientoRiesgoRepo seguimientoRiesgoRepo;

	@GetMapping(value = "seguimientos-riesgo")
	private List<SeguimientoRiesgo> getAllSeguimientosRiesgo() {
		return seguimientoRiesgoRepo.findByOrderByIdSeguimientoRiesgoAsc();
	}

	@GetMapping(value = "seguimientos-riesgo/{idSeguimientoRiesgo}")
	private Optional<SeguimientoRiesgo> getSeguimientoRiesgoById(@PathVariable Long idSeguimientoRiesgo) {
		return seguimientoRiesgoRepo.findById(idSeguimientoRiesgo);
	}

	@PostMapping(value = "seguimientos-riesgo")
	public SeguimientoRiesgo createSeguimientoRiesgo(@RequestBody SeguimientoRiesgo seguimientoRiesgo) {
		return seguimientoRiesgoRepo.save(seguimientoRiesgo);
	}

	@DeleteMapping(value = "seguimientos-riesgo")
	public void deleteSeguimientoRiesgo(@RequestBody SeguimientoRiesgo seguimientoRiesgo) {
		seguimientoRiesgoRepo.delete(seguimientoRiesgo);
	}
}
