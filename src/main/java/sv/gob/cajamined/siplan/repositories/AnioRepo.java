package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.Anio;

@Repository
public interface AnioRepo extends JpaRepository<Anio, Long> {
	List<Anio> findByOrderByIdAnioAsc();
}
