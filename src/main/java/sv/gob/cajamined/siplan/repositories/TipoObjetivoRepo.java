package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.TipoObjetivo;

@Repository
public interface TipoObjetivoRepo extends JpaRepository<TipoObjetivo, Long> {
	List<TipoObjetivo> findByOrderByIdTipoObjetivoAsc();
}
