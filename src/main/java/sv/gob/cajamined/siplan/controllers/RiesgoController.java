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

import sv.gob.cajamined.siplan.entities.Riesgo;
import sv.gob.cajamined.siplan.enums.ExposicionDescripcion;
import sv.gob.cajamined.siplan.enums.FrecuenciaDescripcion;
import sv.gob.cajamined.siplan.enums.ImpactoDescripcion;
import sv.gob.cajamined.siplan.repositories.RiesgoRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class RiesgoController {

  @Autowired
  private RiesgoRepo riesgoRepo;

  @GetMapping(value = "riesgos")
  private List<Riesgo> getAllRiesgos() {
    return riesgoRepo.findByOrderByIdRiesgoAsc();
  }

  @GetMapping(value = "riesgos/{idRiesgo}")
  private Optional<Riesgo> getRiesgoById(@PathVariable Long idRiesgo) {
    return riesgoRepo.findById(idRiesgo);
  }

  @PostMapping(value = "riesgos")
  public Riesgo createRiesgo(@RequestBody Riesgo riesgo) {
    return riesgoRepo.save(riesgo);
  }

  @DeleteMapping(value = "riesgos")
  public void deleteRiesgo(@RequestBody Riesgo riesgo) {
    riesgoRepo.delete(riesgo);
  }

  @GetMapping(value = "riesgos/frecuencias")
  public FrecuenciaDescripcion[] frecuencias() {
    return FrecuenciaDescripcion.values();
  }

  @GetMapping(value = "riesgos/impactos")
  public ImpactoDescripcion[] impactos() {
    return ImpactoDescripcion.values();
  }

  @GetMapping(value = "riesgos/exposiciones")
  public ExposicionDescripcion[] exposiciones() {
    return ExposicionDescripcion.values();
  }
}
