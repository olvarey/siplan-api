package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.Financiamiento;

@Repository
public interface FinanciamientoRepo extends JpaRepository<Financiamiento, Long> {
	List<Financiamiento> findByOrderByIdFinanciamientoAsc();
}
