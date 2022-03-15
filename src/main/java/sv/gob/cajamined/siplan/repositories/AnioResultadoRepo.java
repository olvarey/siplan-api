package sv.gob.cajamined.siplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.cajamined.siplan.entities.AnioResultado;
import sv.gob.cajamined.siplan.entities.AnioResultadoPK;

@Repository
public interface AnioResultadoRepo extends JpaRepository<AnioResultado, AnioResultadoPK> {

}
