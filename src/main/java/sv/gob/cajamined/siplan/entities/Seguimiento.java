package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sv.gob.cajamined.siplan.enums.Mes;

@Entity
@Table(name = "seguimiento", schema = "siplan", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "id_accion", "mes" }, name = "unique_accion_mes") })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seguimiento implements Serializable {

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

	@Enumerated(EnumType.STRING)
	@Column(name = "mes", length = 100, nullable = false)
	private Mes mes;

	@Column(name = "fecha_ejecucion_seguimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaEjecucionSeguimiento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_accion", referencedColumnName = "id_accion", foreignKey = @ForeignKey(name = "fk_seguimiento_accion"))
	private Accion accion;

}
