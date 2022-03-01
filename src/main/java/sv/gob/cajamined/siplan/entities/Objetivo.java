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
	@Column(name = "id_obj")
	private Integer idObj;

	@Column(name = "descripcion_obj", length = 500, nullable = false)
	private String descripcionObj;

	@Column(name = "estrategico_obj", nullable = false)
	private Boolean estrategicoObj;

	@Column(name = "fecha_creacion_obj", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionObj;

	@Column(name = "usuario_creacion_obj", nullable = false, length = 300)
	private String usuarioCreacionObj;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_org", referencedColumnName = "id_org", foreignKey = @ForeignKey(name = "fk_objetivo_organizacion"))
	private Organizacion organizacion;
}
