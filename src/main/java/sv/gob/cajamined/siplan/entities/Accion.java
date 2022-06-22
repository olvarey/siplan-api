package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.Date;
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

	@Column(name = "numero_acciones_anuales_accion", nullable = false)
	private Integer numeroAccionesAnualesAccion;

	@Column(name = "observacion", length = 500)
	private String observacion;

	@Column(name = "fecha_creacion_accion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionAccion;

	@Column(name = "usuario_creacion_accion", nullable = false, length = 300)
	private String usuarioCreacionAccion;

	@OneToMany(mappedBy = "accion", cascade = CascadeType.ALL)
	private List<Seguimiento> seguimientoList;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_financiamiento", referencedColumnName = "id_financiamiento", foreignKey = @ForeignKey(name = "fk_accion_financiamiento"))
	private Financiamiento financiamiento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_linea_trabajo", referencedColumnName = "id_linea_trabajo", foreignKey = @ForeignKey(name = "fk_accion_linea_trabajo"))
	private LineaTrabajo lineaTrabajo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_resultado", referencedColumnName = "id_resultado", foreignKey = @ForeignKey(name = "fk_accion_resultado"))
	private Resultado resultado;
}
