package sv.gob.cajamined.siplan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sv.gob.cajamined.siplan.entities.*;
import sv.gob.cajamined.siplan.repositories.*;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SiplanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiplanApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UsuarioRepo usuarioRepo, RolRepo rolRepo, OrganizacionRepo organizacionRepo, TipoObjetivoRepo tipoObjetivoRepo, ObjetivoRepo objetivoRepo) {
        return args -> {
            Rol rol1 = rolRepo.save(new Rol(null, "ROLE_USER"));
            Rol rol2 = rolRepo.save(new Rol(null, "ROLE_MANAGER"));
            Rol rol3 = rolRepo.save(new Rol(null, "ROLE_ADMIN"));
            Usuario user1 = usuarioRepo.save(new Usuario(null, "Oswaldo Reyes", "olvarey", "123456", new ArrayList<>()));
            Usuario user2 = usuarioRepo.save(new Usuario(null, "Melvin Reyes", "mreyes", "130584", new ArrayList<>()));
            user1.getRoles().add(rol1);
            user1.getRoles().add(rol2);
            user1.getRoles().add(rol3);
            user2.getRoles().add(rol1);
            usuarioRepo.save(user1);
            usuarioRepo.save(user2);

            Organizacion org1 = organizacionRepo.save(new Organizacion(null, "Caja Mutual de los Empleados del MINED", "Descripción", "Misión", "Visión", new ArrayList<>(), new ArrayList<>()));
            Organizacion org2 = organizacionRepo.save(new Organizacion(null, "Ministerio de Educación", "Descripción", "Misión", "Visión", new ArrayList<>(), new ArrayList<>()));

            TipoObjetivo tipo1 = tipoObjetivoRepo.save(new TipoObjetivo(null, "Tipo Obj 1", null));
            TipoObjetivo tipo2 = tipoObjetivoRepo.save(new TipoObjetivo(null, "Tipo Obj 2", null));

            Objetivo obj1 = new Objetivo();
            obj1.setIdObjetivo(null);
            obj1.setNombreObjetivo("Objetivo 1");
            obj1.setDescripcionObjetivo("Descripción objetivo");
            obj1.setFechaCreacionObjetivo(new Date());
            obj1.setTipoObjetivo(tipo1);
            obj1.setOrganizacion(org1);
            obj1.setUsuarioCreacionObjetivo("mreyes");
            objetivoRepo.save(obj1);
        };
    }
}
