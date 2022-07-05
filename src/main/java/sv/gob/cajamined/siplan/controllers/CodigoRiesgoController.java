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

import sv.gob.cajamined.siplan.entities.CodigoRiesgo;
import sv.gob.cajamined.siplan.repositories.CodigoRiesgoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class CodigoRiesgoController {

	@Autowired
	private CodigoRiesgoRepo codigoRiesgoRepo;

	@GetMapping(value = "codigos-riesgo")
	private List<CodigoRiesgo> getAllCodigosRiesgo() {
		return codigoRiesgoRepo.findByOrderByIdCodigoRiesgoAsc();
	}

	@GetMapping(value = "codigos-riesgo/{idCodigoRiesgo}")
	private Optional<CodigoRiesgo> getCodigoRiesgoById(@PathVariable Long idCodigoRiesgo) {
		return codigoRiesgoRepo.findById(idCodigoRiesgo);
	}

	@PostMapping(value = "codigos-riesgo")
	public CodigoRiesgo createCodigoRiesgo(@RequestBody CodigoRiesgo codigoRiesgo) {
		return codigoRiesgoRepo.save(codigoRiesgo);
	}

	@DeleteMapping(value = "codigos-riesgo")
	public void deleteCodigoRiesgo(@RequestBody CodigoRiesgo codigoRiesgo) {
		codigoRiesgoRepo.delete(codigoRiesgo);
	}
}
