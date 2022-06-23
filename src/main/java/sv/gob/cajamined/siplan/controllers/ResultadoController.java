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

import sv.gob.cajamined.siplan.entities.Resultado;
import sv.gob.cajamined.siplan.repositories.ResultadoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class ResultadoController {

	@Autowired
	private ResultadoRepo resultadoRepo;

	@GetMapping(value = "resultados")
	private List<Resultado> getAllResultados() {
		return resultadoRepo.findByOrderByIdResultadoAsc();
	}

	@GetMapping(value = "resultados/{idResultado}")
	private Optional<Resultado> getResultadoById(@PathVariable Long idResultado) {
		return resultadoRepo.findById(idResultado);
	}

	@PostMapping(value = "resultados")
	public Resultado createResultado(@RequestBody Resultado resultado) {
		return resultadoRepo.save(resultado);
	}

	@DeleteMapping(value = "resultados")
	public void deleteResultado(@RequestBody Resultado resultado) {
		resultadoRepo.delete(resultado);
	}

}
