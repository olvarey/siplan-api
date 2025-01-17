package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estrategia_riesgo", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstrategiaRiesgo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_estrategia_riesgo")
  private Long idEstrategiaRiesgo;

  @Column(name = "nombre_estrategia_riesgo", length = 300, nullable = false)
  private String nombreEstrategiaRiesgo;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_riesgo", referencedColumnName = "id_riesgo", foreignKey = @ForeignKey(name = "fk_estrategia_riesgo_riesgo"))
  private Riesgo riesgo;
}
