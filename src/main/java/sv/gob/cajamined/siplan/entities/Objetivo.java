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
@Table(name = "objetivo", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Objetivo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_objetivo")
	private Long idObjetivo;

	@Column(name = "nombre_objetivo", length = 300, nullable = false)
	private String nombreObjetivo;

	@Column(name = "descripcion_objetivo", length = 500)
	private String descripcionObjetivo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_organizacion", referencedColumnName = "id_organizacion", foreignKey = @ForeignKey(name = "fk_objetivo_organizacion"))
	// @JsonBackReference
	private Organizacion organizacion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_objetivo", referencedColumnName = "id_tipo_objetivo", foreignKey = @ForeignKey(name = "fk_objetivo_tipo_objetivo"))
	// @JsonBackReference
	private TipoObjetivo tipoObjetivo;

	@OneToMany(mappedBy = "objetivo", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Eje> ejeList;

//	@ManyToMany(mappedBy = "objetivoSet")
//	private Set<Plan> planSet;
}
