package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "eje", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Eje implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_eje")
  private Long idEje;

  @Column(name = "nombre_eje", length = 300, nullable = false)
  private String nombreEje;

  @Column(name = "descripcion_eje", length = 500)
  private String descripcionEje;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_objetivo", referencedColumnName = "id_objetivo", foreignKey = @ForeignKey(name = "fk_eje_objetivo"))
  private Objetivo objetivo;

  @OneToMany(mappedBy = "eje", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Resultado> resultadoList;
}
