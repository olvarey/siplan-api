package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.CodigoRiesgo;

@Repository
public interface CodigoRiesgoRepo extends JpaRepository<CodigoRiesgo, Long> {

  List<CodigoRiesgo> findByOrderByIdCodigoRiesgoAsc();
}
