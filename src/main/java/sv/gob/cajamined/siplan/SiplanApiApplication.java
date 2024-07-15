package sv.gob.cajamined.siplan;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sv.gob.cajamined.siplan.entities.Objetivo;
import sv.gob.cajamined.siplan.entities.Organizacion;
import sv.gob.cajamined.siplan.entities.Rol;
import sv.gob.cajamined.siplan.entities.TipoObjetivo;
import sv.gob.cajamined.siplan.entities.Usuario;
import sv.gob.cajamined.siplan.repositories.ObjetivoRepo;
import sv.gob.cajamined.siplan.repositories.OrganizacionRepo;
import sv.gob.cajamined.siplan.repositories.RolRepo;
import sv.gob.cajamined.siplan.repositories.TipoObjetivoRepo;
import sv.gob.cajamined.siplan.repositories.UsuarioRepo;

@SpringBootApplication
public class SiplanApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SiplanApiApplication.class, args);
  }

  @Bean
  CommandLineRunner run(UsuarioRepo usuarioRepo, RolRepo rolRepo, OrganizacionRepo organizacionRepo,
    TipoObjetivoRepo tipoObjetivoRepo, ObjetivoRepo objetivoRepo) {
    return args -> {
      Rol rol1 = rolRepo.save(new Rol(null, "ROLE_USER"));
      Rol rol2 = rolRepo.save(new Rol(null, "ROLE_MANAGER"));
      Rol rol3 = rolRepo.save(new Rol(null, "ROLE_ADMIN"));
      Usuario user1 = usuarioRepo
        .save(new Usuario(null, "Oswaldo Reyes", "olvarey", "123456", new ArrayList<>()));
      Usuario user2 = usuarioRepo.save(
        new Usuario(null, "Melvin Reyes", "mreyes", "130584", new ArrayList<>()));
      user1.getRoles().add(rol1);
      user1.getRoles().add(rol2);
      user1.getRoles().add(rol3);
      user2.getRoles().add(rol1);
      usuarioRepo.save(user1);
      usuarioRepo.save(user2);

      Organizacion org1 = organizacionRepo.save(
        new Organizacion(null, "Caja Mutual de los Empleados del MINED",
          "Descripción", "Misión", "Visión", new ArrayList<>(), new ArrayList<>()));
      Organizacion org2 = organizacionRepo.save(
        new Organizacion(null, "Ministerio de Educación", "Descripción",
          "Misión", "Visión", new ArrayList<>(), new ArrayList<>()));

      TipoObjetivo tipo1 = tipoObjetivoRepo.save(new TipoObjetivo(null, "Tipo Obj 1", null));
      TipoObjetivo tipo2 = tipoObjetivoRepo.save(new TipoObjetivo(null, "Tipo Obj 2", null));

      Objetivo obj1 = new Objetivo();
      obj1.setIdObjetivo(null);
      obj1.setNombreObjetivo("Objetivo 1");
      obj1.setDescripcionObjetivo("Descripción objetivo");
      obj1.setTipoObjetivo(tipo1);
      obj1.setOrganizacion(org1);

      objetivoRepo.save(obj1);
    };
  }
}
