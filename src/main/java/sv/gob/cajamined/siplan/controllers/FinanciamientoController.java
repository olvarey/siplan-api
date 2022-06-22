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

import sv.gob.cajamined.siplan.entities.Financiamiento;
import sv.gob.cajamined.siplan.repositories.FinanciamientoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class FinanciamientoController {

	@Autowired
	private FinanciamientoRepo financiamientoRepo;

	@GetMapping(value = "financiamientos")
	private List<Financiamiento> getAllAnios() {
		return financiamientoRepo.findByOrderByIdFinanciamientoAsc();
	}

	@GetMapping(value = "financiamientos/{idFinanciamiento}")
	private Optional<Financiamiento> getAnioById(@PathVariable Long idFinanciamiento) {
		return financiamientoRepo.findById(idFinanciamiento);
	}

	@PostMapping(value = "financiamientos")
	public Financiamiento createAnio(@RequestBody Financiamiento financiamiento) {
		return financiamientoRepo.save(financiamiento);
	}

	@DeleteMapping(value = "financiamientos")
	public void deleteAnio(@RequestBody Financiamiento financiamiento) {
		financiamientoRepo.delete(financiamiento);
	}
}
