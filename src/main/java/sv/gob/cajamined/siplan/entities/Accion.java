package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

	@ManyToOne(optional = false)
	@JoinColumns(foreignKey = @ForeignKey(name = "fk_accion_anio_resultado"), value = {
			@JoinColumn(name = "id_anio", referencedColumnName = "id_anio"),
			@JoinColumn(name = "id_resultado", referencedColumnName = "id_resultado") })
	private AnioResultado anioResultado;

	@OneToMany(mappedBy = "accion", cascade = CascadeType.ALL)
	private List<Seguimiento> seguimientoList;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_financiamiento", referencedColumnName = "id_financiamiento", foreignKey = @ForeignKey(name = "fk_accion_financiamiento"))
	private Financiamiento financiamiento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_linea_trabajo", referencedColumnName = "id_linea_trabajo", foreignKey = @ForeignKey(name = "fk_accion_linea_trabajo"))
	private LineaTrabajo lineaTrabajo;
}
