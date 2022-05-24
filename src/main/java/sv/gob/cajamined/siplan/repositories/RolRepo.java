package sv.gob.cajamined.siplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.gob.cajamined.siplan.entities.Rol;

public interface RolRepo extends JpaRepository<Rol, Long> {
	Rol findBynombreRol(String nombreRol);
}
