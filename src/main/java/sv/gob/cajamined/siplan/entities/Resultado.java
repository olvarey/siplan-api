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
@Table(name = "resultado", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resultado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resultado")
	private Long idResultado;

	@Column(name = "nombre_resultado", length = 500, nullable = false)
	private String nombreResultado;

	@Column(name = "descripcion_resultado", length = 500)
	private String descripcionResultado;

	@Column(name = "nombre_responsable_resultado", length = 500)
	private String nombreResponsableResultado;

	@Column(name = "fecha_creacion_resultado")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionResultado;

	@Column(name = "usuario_creacion_resultado", nullable = false, length = 300)
	private String usuarioCreacionResultado;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_eje", referencedColumnName = "id_eje", foreignKey = @ForeignKey(name = "fk_eje_resultado"))
	@JsonBackReference
	private Eje eje;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_indicador", referencedColumnName = "id_indicador", foreignKey = @ForeignKey(name = "fk_resultado_indicador"))
	@JsonBackReference
	private Indicador indicador;

	@OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<AnioResultado> anioResultadoList;

}
