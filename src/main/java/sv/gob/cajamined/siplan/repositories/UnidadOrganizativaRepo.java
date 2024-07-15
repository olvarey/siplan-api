package sv.gob.cajamined.siplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.cajamined.siplan.entities.UnidadOrganizativa;

import java.util.List;

@Repository
public interface UnidadOrganizativaRepo extends JpaRepository<UnidadOrganizativa, Long> {

  List<UnidadOrganizativa> findByOrderByIdUnidadOrganizativaAsc();
}
