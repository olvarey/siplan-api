package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	private Integer idResultado;

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
	private Eje eje;

}
