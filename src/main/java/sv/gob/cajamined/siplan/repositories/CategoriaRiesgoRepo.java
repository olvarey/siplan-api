package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.CategoriaRiesgo;

@Repository
public interface CategoriaRiesgoRepo extends JpaRepository<CategoriaRiesgo, Long> {

  List<CategoriaRiesgo> findByOrderByIdCategoriaRiesgoAsc();
}
