package sv.gob.cajamined.siplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.gob.cajamined.siplan.entities.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	Usuario findByUsuario(String usuario);
}
