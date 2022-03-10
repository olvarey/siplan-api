package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seguimiento", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seguimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SeguimientoPK idSeguimientoPK;

	@Column(name = "detalle_seguimiento", length = 500, nullable = false)
	private String detalleSeguimiento;

	@Column(name = "presupuesto_ejecutado", nullable = false)
	private double presupuestoEjecutado;

	@Column(name = "ejecutado")
	private Boolean ejecutado;

	@Column(name = "numero_acciones_mensuales", nullable = false)
	private Long numeroAccionesMensuales;

	@Column(name = "fecha_creacion_seguimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionSeguimiento;

	@Column(name = "usuario_creacion_seguimiento", nullable = false, length = 300)
	private String usuarioCreacionSeguimiento;

	@Column(name = "fecha_edicion_seguimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaEdicionSeguimiento;

	@Column(name = "usuario_edicion_seguimiento", length = 300)
	private String usuarioEdicionSeguimiento;

	@Column(name = "fecha_ejecucion_seguimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaEjecucionSeguimiento;

	@ManyToOne
	@MapsId("idAccion")
	@JoinColumn(name = "id_accion", referencedColumnName = "id_accion", foreignKey = @ForeignKey(name = "fk_seguimiento_accion"))
	private Accion accion;

	@ManyToOne
	@MapsId("idMes")
	@JoinColumn(name = "id_mes", referencedColumnName = "id_mes", foreignKey = @ForeignKey(name = "fk_seguimiento_mes"))
	private Mes mes;

}
