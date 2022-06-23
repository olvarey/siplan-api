package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.Resultado;

@Repository
public interface ResultadoRepo extends JpaRepository<Resultado, Long> {
	List<Resultado> findByOrderByIdResultadoAsc();
}
