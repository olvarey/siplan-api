package sv.gob.cajamined.siplan.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.gob.cajamined.siplan.entities.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsuario(String usuario);

	List<Usuario> findByOrderByIdUsuarioAsc();
}
