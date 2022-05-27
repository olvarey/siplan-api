package sv.gob.cajamined.siplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.gob.cajamined.siplan.entities.Usuario;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsuario(String usuario);
}
