package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.Objetivo;
import sv.gob.cajamined.siplan.entities.Organizacion;

@Repository
public interface ObjetivoRepo extends JpaRepository<Objetivo, Long> {

	List<Objetivo> findByOrganizacionIdOrganizacion(Long idOrganizacion);

	List<Objetivo> findByOrganizacionIdOrganizacionAndTipoObjetivoIdTipoObjetivo(Long idOrganizacion, Long idTipoObjetivo);

	List<Objetivo> findByTipoObjetivoIdTipoObjetivo(Long idTipoObjetivo);
}
