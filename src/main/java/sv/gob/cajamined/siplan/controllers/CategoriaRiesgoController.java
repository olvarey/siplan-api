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

import sv.gob.cajamined.siplan.entities.CategoriaRiesgo;
import sv.gob.cajamined.siplan.repositories.CategoriaRiesgoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class CategoriaRiesgoController {

	@Autowired
	private CategoriaRiesgoRepo categoriaRiesgoRepo;

	@GetMapping(value = "categorias-riesgo")
	private List<CategoriaRiesgo> getAllCategoriasRiesgo() {
		return categoriaRiesgoRepo.findByOrderByIdCategoriaRiesgoAsc();
	}

	@GetMapping(value = "categorias-riesgo/{idCategoriaRiesgo}")
	private Optional<CategoriaRiesgo> getCategoriaRiesgoById(@PathVariable Long idCategoriaRiesgo) {
		return categoriaRiesgoRepo.findById(idCategoriaRiesgo);
	}

	@PostMapping(value = "categorias-riesgo")
	public CategoriaRiesgo createCategoriaRiesgo(@RequestBody CategoriaRiesgo categoriaRiesgo) {
		return categoriaRiesgoRepo.save(categoriaRiesgo);
	}

	@DeleteMapping(value = "categorias-riesgo")
	public void deleteCategoriaRiesgo(@RequestBody CategoriaRiesgo categoriaRiesgo) {
		categoriaRiesgoRepo.delete(categoriaRiesgo);
	}
}
