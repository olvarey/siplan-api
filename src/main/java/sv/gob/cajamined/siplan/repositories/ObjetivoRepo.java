package sv.gob.cajamined.siplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.cajamined.siplan.entities.Objetivo;

import java.util.List;

@Repository
public interface ObjetivoRepo extends JpaRepository<Objetivo, Long> {

	List<Objetivo> findByTipoObjetivoIdTipoObjetivo(Long idTipoObjetivo);

	List<Objetivo> findByOrganizacionIdOrganizacion(Long idOrganizacion);

}
