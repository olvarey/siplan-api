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
@Table(name = "categoria_riesgo", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaRiesgo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_categoria_riesgo")
  private Long idCategoriaRiesgo;

  @Column(name = "nombre_categoria_riesgo", length = 300, nullable = false)
  private String nombreCategoriaRiesgo;

  @OneToMany(mappedBy = "categoriaRiesgo", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Riesgo> riesgoList;
}
