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

import sv.gob.cajamined.siplan.entities.UnidadPresupuestaria;
import sv.gob.cajamined.siplan.repositories.UnidadPresupuestariaRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class UnidadPresupuestariaController {

	@Autowired
	private UnidadPresupuestariaRepo unidadPresupuestariaRepo;

	@GetMapping(value = "unidades-presupuestarias")
	private List<UnidadPresupuestaria> getAllUnidadesPresupuestarias() {
		return unidadPresupuestariaRepo.findByOrderByIdUnidadPresupuestariaAsc();
	}

	@GetMapping(value = "unidades-presupuestarias/{idUnidadPresupuestaria}")
	private Optional<UnidadPresupuestaria> getUnidadPresupuestariaById(@PathVariable Long idUnidadPresupuestaria) {
		return unidadPresupuestariaRepo.findById(idUnidadPresupuestaria);
	}

	@PostMapping(value = "unidades-presupuestarias")
	public UnidadPresupuestaria createUnidadPresupuestaria(@RequestBody UnidadPresupuestaria unidadPresupuestaria) {
		return unidadPresupuestariaRepo.save(unidadPresupuestaria);
	}

	@DeleteMapping(value = "unidades-presupuestarias")
	public void deleteUnidadPresupuestaria(@RequestBody UnidadPresupuestaria unidadPresupuestaria) {
		unidadPresupuestariaRepo.delete(unidadPresupuestaria);
	}
}
