package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.SeguimientoRiesgo;

@Repository
public interface SeguimientoRiesgoRepo extends JpaRepository<SeguimientoRiesgo, Long> {

  List<SeguimientoRiesgo> findByOrderByIdSeguimientoRiesgoAsc();
}
