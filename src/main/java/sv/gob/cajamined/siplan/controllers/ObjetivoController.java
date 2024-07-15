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

import sv.gob.cajamined.siplan.entities.Objetivo;
import sv.gob.cajamined.siplan.repositories.ObjetivoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class ObjetivoController {

  @Autowired
  private ObjetivoRepo objetivoRepo;

  @GetMapping(value = "objetivos")
  private List<Objetivo> getAllObjetivos() {
    return objetivoRepo.findByOrderByIdObjetivoAsc();
  }

  @GetMapping(value = "objetivos/{idObjetivo}")
  private Optional<Objetivo> getObjetivoById(@PathVariable Long idObjetivo) {
    return objetivoRepo.findById(idObjetivo);
  }

  @GetMapping(value = "objetivos/tipos-objetivo/{idTipoObjetivo}")
  private List<Objetivo> getObjetivosByTipoObjetivo(@PathVariable Long idTipoObjetivo) {
    return objetivoRepo.findByTipoObjetivoIdTipoObjetivo(idTipoObjetivo);
  }

  @GetMapping(value = "organizaciones/{idOrganizacion}/objetivos")
  private List<Objetivo> getObjetivosByOrganizacion(@PathVariable Long idOrganizacion) {
    return objetivoRepo.findByOrganizacionIdOrganizacion(idOrganizacion);
  }

  @PostMapping(value = "objetivos")
  public void saveObjetivo(@RequestBody Objetivo objetivo) {
    objetivoRepo.save(objetivo);
  }

  @DeleteMapping(value = "objetivos")
  public void deleteObjetivo(@RequestBody Objetivo objetivo) {
    objetivoRepo.delete(objetivo);
  }
}
