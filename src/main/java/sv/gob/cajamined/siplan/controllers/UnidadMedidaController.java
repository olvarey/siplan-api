package sv.gob.cajamined.siplan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.gob.cajamined.siplan.entities.UnidadMedida;
import sv.gob.cajamined.siplan.repositories.UnidadMedidaRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class UnidadMedidaController {

  @Autowired
  private UnidadMedidaRepo unidadMedidaRepo;

  @GetMapping(value = "unidades-medida")
  private List<UnidadMedida> getAllUnidadesMedida() {
    return unidadMedidaRepo.findByOrderByIdUnidadMedidaAsc();
  }

  @GetMapping(value = "unidades-medida/{idUnidadMedida}")
  private Optional<UnidadMedida> getUnidadMedidaById(@PathVariable Long idUnidadMedida) {
    return unidadMedidaRepo.findById(idUnidadMedida);
  }

  @PostMapping(value = "unidades-medida")
  public UnidadMedida createUnidadMedida(@RequestBody UnidadMedida unidadMedida) {
    return unidadMedidaRepo.save(unidadMedida);
  }

  @DeleteMapping(value = "unidades-medida")
  public void deleteUnidadMedida(@RequestBody UnidadMedida unidadMedida) {
    unidadMedidaRepo.delete(unidadMedida);
  }
}
