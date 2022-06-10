package sv.gob.cajamined.siplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.cajamined.siplan.entities.UnidadMedida;

import java.util.List;

@Repository
public interface UnidadMedidaRepo extends JpaRepository<UnidadMedida, Long> {
    List<UnidadMedida> findByOrderByIdUnidadMedidaAsc();
}
