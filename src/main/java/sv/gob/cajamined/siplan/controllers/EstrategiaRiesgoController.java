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

import sv.gob.cajamined.siplan.entities.EstrategiaRiesgo;
import sv.gob.cajamined.siplan.repositories.EstrategiaRiesgoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class EstrategiaRiesgoController {

	@Autowired
	private EstrategiaRiesgoRepo estrategiaRiesgoRepo;

	@GetMapping(value = "estrategias-riesgo")
	private List<EstrategiaRiesgo> getAllEstrategiasRiesgo() {
		return estrategiaRiesgoRepo.findByOrderByIdEstrategiaRiesgo();
	}

	@GetMapping(value = "estrategias-riesgo/{idEstrategiaRiesgo}")
	private Optional<EstrategiaRiesgo> getEstrategiaRiesgoById(@PathVariable Long idEstrategiaRiesgo) {
		return estrategiaRiesgoRepo.findById(idEstrategiaRiesgo);
	}

	@PostMapping(value = "estrategias-riesgo")
	public EstrategiaRiesgo createEstrategiaRiesgo(@RequestBody EstrategiaRiesgo estrategiaRiesgo) {
		return estrategiaRiesgoRepo.save(estrategiaRiesgo);
	}

	@DeleteMapping(value = "estrategias-riesgo")
	public void deleteEstrategiaRiesgo(@RequestBody EstrategiaRiesgo estrategiaRiesgo) {
		estrategiaRiesgoRepo.delete(estrategiaRiesgo);
	}
}
