package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anio", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Anio implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_anio")
  private Long idAnio;

  @Column(name = "valor_anio", nullable = false)
  private Long valorAnio;

  @OneToMany(mappedBy = "anio", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Resultado> resultadoList;
}
