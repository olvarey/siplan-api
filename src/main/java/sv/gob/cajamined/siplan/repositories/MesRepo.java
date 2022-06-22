package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.Mes;

@Repository
public interface MesRepo extends JpaRepository<Mes, Long> {
	List<Mes> findByOrderByIdMesAsc();
}
