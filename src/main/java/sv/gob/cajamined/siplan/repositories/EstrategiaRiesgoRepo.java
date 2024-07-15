package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.EstrategiaRiesgo;

@Repository
public interface EstrategiaRiesgoRepo extends JpaRepository<EstrategiaRiesgo, Long> {

  List<EstrategiaRiesgo> findByOrderByIdEstrategiaRiesgo();
}
