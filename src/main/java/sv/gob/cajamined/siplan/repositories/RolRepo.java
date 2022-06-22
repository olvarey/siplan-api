package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.gob.cajamined.siplan.entities.Rol;

public interface RolRepo extends JpaRepository<Rol, Long> {
	Rol findByNombreRol(String nombreRol);

	List<Rol> findByOrderByIdRolAsc();
}
