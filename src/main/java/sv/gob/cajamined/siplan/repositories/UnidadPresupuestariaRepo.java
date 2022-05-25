package sv.gob.cajamined.siplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.cajamined.siplan.entities.UnidadPresupuestaria;

@Repository
public interface UnidadPresupuestariaRepo extends JpaRepository<UnidadPresupuestaria, Long> {

}
