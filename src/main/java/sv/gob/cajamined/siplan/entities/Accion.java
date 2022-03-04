package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accion", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_accion")
	private Long idAccion;

	@Column(name = "nombre_accion", length = 300, nullable = false)
	private String nombreAccion;

	@Column(name = "descripcion_accion", length = 500)
	private String descripcionAccion;

	@Column(name = "presupuesto_asignado_accion")
	private double presupuestoAsignadoAccion;

	@Column(name = "nombre_responsable_accion", length = 500)
	private String nombreResponsableAccion;

	@Column(name = "numero_acciones_anual_accion", nullable = false)
	private Integer numeroAccionesAnualAccion;

	@Column(name = "observacion", length = 500)
	private String observacion;

	@Column(name = "fecha_creacion_accion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionAccion;

	@Column(name = "usuario_creacion_accion", nullable = false, length = 300)
	private String usuarioCreacionAccion;

}
