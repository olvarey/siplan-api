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
@Table(name = "plan", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plan")
	private Long idPlan;

	@Column(name = "nombre_plan", length = 300, nullable = false)
	private String nombrePlan;

	@Column(name = "descripcion_plan", length = 500, nullable = false)
	private String descripcionPlan;

	@Column(name = "fecha_creacion_plan", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionPlan;

	@Column(name = "usuario_creacion_plan", nullable = false, length = 300)
	private String usuarioCreacionPlan;

//	@ManyToMany
//	@JoinTable(name = "plan_objetivo", schema = "siplan", joinColumns = @JoinColumn(name = "id_plan", foreignKey = @ForeignKey(name = "fk_plan_objetivo_plan")), inverseJoinColumns = @JoinColumn(name = "id_objetivo", foreignKey = @ForeignKey(name = "fk_plan_objetivo_objetivo")))
//	private Set<Objetivo> objetivoSet;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_plan", referencedColumnName = "id_tipo_plan", foreignKey = @ForeignKey(name = "fk_plan_tipo_plan"))
	private TipoPlan tipoPlan;

}
