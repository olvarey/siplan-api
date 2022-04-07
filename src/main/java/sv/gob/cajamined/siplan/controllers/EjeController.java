package sv.gob.cajamined.siplan.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.gob.cajamined.siplan.entities.Eje;
import sv.gob.cajamined.siplan.repositories.EjeRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
public class EjeController {

	@Autowired
	private EjeRepo ejeRepo;

	@GetMapping(value = "ejes")
	private List<Eje> getAllEjes() {
		return ejeRepo.findAll();
	}

	@GetMapping(value = "ejes/{idEje}")
	private Optional<Eje> getEjeById(@PathVariable Long idEje) {
		return ejeRepo.findById(idEje);
	}

}
