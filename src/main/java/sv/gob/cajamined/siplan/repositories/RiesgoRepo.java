package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.gob.cajamined.siplan.entities.Riesgo;

public interface RiesgoRepo extends JpaRepository<Riesgo, Long> {

  public List<Riesgo> findByOrderByIdRiesgoAsc();
}
