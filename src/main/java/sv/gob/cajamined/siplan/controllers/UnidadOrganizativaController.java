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

import sv.gob.cajamined.siplan.entities.UnidadOrganizativa;
import sv.gob.cajamined.siplan.repositories.UnidadOrganizativaRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class UnidadOrganizativaController {

  @Autowired
  private UnidadOrganizativaRepo unidadOrganizativaRepo;

  @GetMapping(value = "unidades-organizativas")
  private List<UnidadOrganizativa> getAllUnidadesOrganizativas() {
    return unidadOrganizativaRepo.findByOrderByIdUnidadOrganizativaAsc();
  }

  @GetMapping(value = "unidades-organizativas/{idUnidadOrganizativa}")
  private Optional<UnidadOrganizativa> getUnidadOrganizativaById(
    @PathVariable Long idUnidadOrganizativa) {
    return unidadOrganizativaRepo.findById(idUnidadOrganizativa);
  }

  @PostMapping(value = "unidades-organizativas")
  public UnidadOrganizativa createUnidadOrganizativa(
    @RequestBody UnidadOrganizativa unidadOrganizativa) {
    return unidadOrganizativaRepo.save(unidadOrganizativa);
  }

  @DeleteMapping(value = "unidades-organizativas")
  public void deleteUnidadOrganizativa(@RequestBody UnidadOrganizativa unidadOrganizativa) {
    unidadOrganizativaRepo.delete(unidadOrganizativa);
  }
}
