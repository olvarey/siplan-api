package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.Eje;

@Repository
public interface EjeRepo extends JpaRepository<Eje, Long> {

  List<Eje> findByOrderByIdEjeAsc();
}
