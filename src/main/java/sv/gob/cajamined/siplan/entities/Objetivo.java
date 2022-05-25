package sv.gob.cajamined.siplan.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

	@Column(name = "fecha_creacion_objetivo", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionObjetivo;

	@Column(name = "usuario_creacion_objetivo", nullable = false, length = 300)
	private String usuarioCreacionObjetivo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_organizacion", referencedColumnName = "id_organizacion", foreignKey = @ForeignKey(name = "fk_objetivo_organizacion"))
	@JsonBackReference
	private Organizacion organizacion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_objetivo", referencedColumnName = "id_tipo_objetivo", foreignKey = @ForeignKey(name = "fk_objetivo_tipo_objetivo"))
	@JsonBackReference
	private TipoObjetivo tipoObjetivo;

	@OneToMany(mappedBy = "objetivo", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Eje> ejeList;

//	@ManyToMany(mappedBy = "objetivoSet")
//	private Set<Plan> planSet;
}
