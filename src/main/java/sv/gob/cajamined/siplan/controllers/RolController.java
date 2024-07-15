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

import sv.gob.cajamined.siplan.entities.Rol;
import sv.gob.cajamined.siplan.repositories.RolRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class RolController {

  @Autowired
  private RolRepo rolRepo;

  @GetMapping(value = "roles")
  private List<Rol> getAllRoles() {
    return rolRepo.findByOrderByIdRolAsc();
  }

  @GetMapping(value = "roles/{idRol}")
  private Optional<Rol> getRolById(@PathVariable Long idRol) {
    return rolRepo.findById(idRol);
  }

  @PostMapping(value = "roles")
  public Rol createRol(@RequestBody Rol rol) {
    return rolRepo.save(rol);
  }

  @DeleteMapping(value = "roles")
  public void deleteRol(@RequestBody Rol rol) {
    rolRepo.delete(rol);
  }
}
