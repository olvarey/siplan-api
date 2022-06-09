package sv.gob.cajamined.siplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.cajamined.siplan.entities.TipoIndicador;

@Repository
public interface TipoIndicadorRepo extends JpaRepository<TipoIndicador, Long> {
    List<TipoIndicador> findByOrderByIdTipoIndicadorAsc();

}
