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

import sv.gob.cajamined.siplan.entities.Anio;
import sv.gob.cajamined.siplan.repositories.AnioRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class AnioController {

  @Autowired
  private AnioRepo anioRepo;

  @GetMapping(value = "anios")
  private List<Anio> getAllAnios() {
    return anioRepo.findByOrderByIdAnioAsc();
  }

  @GetMapping(value = "anios/{idAnio}")
  private Optional<Anio> getAnioById(@PathVariable Long idAnio) {
    return anioRepo.findById(idAnio);
  }

  @PostMapping(value = "anios")
  public Anio createAnio(@RequestBody Anio anio) {
    return anioRepo.save(anio);
  }

  @DeleteMapping(value = "anios")
  public void deleteAnio(@RequestBody Anio anio) {
    anioRepo.delete(anio);
  }
}
