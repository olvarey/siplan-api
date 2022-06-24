package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "seguimiento", schema = "siplan", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "id_accion", "id_mes" }, name = "unique_accion_mes") })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seguimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_seguimiento")
	private Long idSeguimiento;

	@Column(name = "detalle_seguimiento", length = 500, nullable = false)
	private String detalleSeguimiento;

	@Column(name = "presupuesto_ejecutado", nullable = false)
	private double presupuestoEjecutado;

	@Column(name = "numero_acciones_mensuales", nullable = false)
	private Long numeroAccionesMensuales;

	@Column(name = "ejecutado")
	private Boolean ejecutado;
	
	@Column(name = "fecha_ejecucion_seguimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaEjecucionSeguimiento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_accion", referencedColumnName = "id_accion", foreignKey = @ForeignKey(name = "fk_seguimiento_accion"))
	private Accion accion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_mes", referencedColumnName = "id_mes", foreignKey = @ForeignKey(name = "fk_seguimiento_mes"))
	private Mes mes;

}
