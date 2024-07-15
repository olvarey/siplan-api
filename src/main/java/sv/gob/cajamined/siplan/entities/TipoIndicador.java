package sv.gob.cajamined.siplan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipo_indicador", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoIndicador implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_tipo_indicador")
  private Long idTipoIndicador;

  @Column(name = "nombre_tipo_indicador", nullable = false, length = 300)
  private String nombreIndicador;

  @OneToMany(mappedBy = "tipoIndicador", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Indicador> indicadorList;

}
