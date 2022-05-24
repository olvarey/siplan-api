package sv.gob.cajamined.siplan;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import sv.gob.cajamined.siplan.entities.Rol;
import sv.gob.cajamined.siplan.entities.Usuario;
import sv.gob.cajamined.siplan.repositories.RolRepo;
import sv.gob.cajamined.siplan.repositories.UsuarioRepo;

@SpringBootApplication
public class SiplanApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiplanApiApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UsuarioRepo usuarioRepo, RolRepo rolRepo) {
		return args -> {
			Rol rol1 = rolRepo.save(new Rol(null, "ROLE_USER"));
			Rol rol2 = rolRepo.save(new Rol(null, "ROLE_MANAGER"));
			Rol rol3 = rolRepo.save(new Rol(null, "ROLE_ADMIN"));
			Usuario user1 = usuarioRepo.save(new Usuario(null, "Melvin Reyes", "olvarey", "123456", new ArrayList<>()));
			user1.getRoles().add(rol1);
			user1.getRoles().add(rol2);
			user1.getRoles().add(rol3);
			usuarioRepo.save(user1);
		};
	}

}
