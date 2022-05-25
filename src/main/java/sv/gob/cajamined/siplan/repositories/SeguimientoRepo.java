package sv.gob.cajamined.siplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.cajamined.siplan.entities.Seguimiento;
import sv.gob.cajamined.siplan.entities.SeguimientoPK;

@Repository
public interface SeguimientoRepo extends JpaRepository<Seguimiento, SeguimientoPK> {

}
