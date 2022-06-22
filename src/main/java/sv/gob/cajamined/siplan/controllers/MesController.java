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

import sv.gob.cajamined.siplan.entities.Mes;
import sv.gob.cajamined.siplan.repositories.MesRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class MesController {

	@Autowired
	private MesRepo mesRepo;

	@GetMapping(value = "meses")
	private List<Mes> getAllMeses() {
		return mesRepo.findByOrderByIdMesAsc();
	}

	@GetMapping(value = "meses/{idMes}")
	private Optional<Mes> getMesById(@PathVariable Long idMes) {
		return mesRepo.findById(idMes);
	}

	@PostMapping(value = "meses")
	public Mes createMes(@RequestBody Mes mes) {
		return mesRepo.save(mes);
	}

	@DeleteMapping(value = "meses")
	public void deleteMes(@RequestBody Mes mes) {
		mesRepo.delete(mes);
	}
}
