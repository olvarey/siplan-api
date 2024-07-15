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

import sv.gob.cajamined.siplan.entities.Eje;
import sv.gob.cajamined.siplan.repositories.EjeRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class EjeController {

  @Autowired
  private EjeRepo ejeRepo;

  @GetMapping(value = "ejes")
  private List<Eje> getAllEjes() {
    return ejeRepo.findByOrderByIdEjeAsc();
  }

  @GetMapping(value = "ejes/{idEje}")
  private Optional<Eje> getEjeById(@PathVariable Long idEje) {
    return ejeRepo.findById(idEje);
  }

  @PostMapping(value = "ejes")
  public Eje createEje(@RequestBody Eje eje) {
    return ejeRepo.save(eje);
  }

  @DeleteMapping(value = "ejes")
  public void deleteEje(@RequestBody Eje eje) {
    ejeRepo.delete(eje);
  }

}
