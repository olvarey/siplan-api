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

import sv.gob.cajamined.siplan.entities.TipoObjetivo;
import sv.gob.cajamined.siplan.repositories.TipoObjetivoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class TipoObjetivoController {

	@Autowired
	private TipoObjetivoRepo tipoObjetivoRepo;

	@GetMapping(value = "tipos-objetivo")
	private List<TipoObjetivo> getAllTiposObjetivos() {
		return tipoObjetivoRepo.findByOrderByIdTipoObjetivoAsc();
	}

	@GetMapping(value = "tipos-objetivo/{idTipoObjetivo}")
	private Optional<TipoObjetivo> getOrganizacionById(@PathVariable Long idTipoObjetivo) {
		return tipoObjetivoRepo.findById(idTipoObjetivo);
	}

	@PostMapping(value = "tipos-objetivo")
	public TipoObjetivo createOrganizacion(@RequestBody TipoObjetivo tipoObjetivo) {
		return tipoObjetivoRepo.save(tipoObjetivo);
	}

	@DeleteMapping(value = "tipos-objetivo")
	public void deleteOrganizacion(@RequestBody TipoObjetivo tipoObjetivo) {
		tipoObjetivoRepo.delete(tipoObjetivo);
	}
}
