package sv.gob.cajamined.siplan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.gob.cajamined.siplan.entities.Objetivo;
import sv.gob.cajamined.siplan.repositories.ObjetivoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
public class ObjetivoController {

	@Autowired
	private ObjetivoRepo objetivoRepo;

	@GetMapping(value = "objetivos")
	private List<Objetivo> getAllObjetivos() {
		return objetivoRepo.findAll();
	}

	@GetMapping(value = "objetivos/{idObjetivo}")
	private Objetivo getObjetivoById(@PathVariable Long idObjetivo) {
		return objetivoRepo.getById(idObjetivo);
	}

	@PostMapping(value = "objetivos")
	public void saveObjetivo(@RequestBody Objetivo nuevoObjetivo) {
		objetivoRepo.save(nuevoObjetivo);
	}
}
