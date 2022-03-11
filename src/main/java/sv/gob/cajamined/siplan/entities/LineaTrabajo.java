package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "linea_trabajo", schema = "siplan", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"id_linea_trabajo", "id_unidad_presupuestaria" }, name = "unique_linea_trabajo_unidad_presupuestaria") })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineaTrabajo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_linea_trabajo")
	private Long idLineaTrabajo;

	@Column(name = "nombre_linea_trabajo", length = 300, nullable = false)
	private String nombreLineaTrabajo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_unidad_presupuestaria", referencedColumnName = "id_unidad_presupuestaria", foreignKey = @ForeignKey(name = "fk_linea_trabajo_unidad_presupuestaria"))
	private UnidadPresupuestaria unidadPresupuestaria;

	@OneToMany(mappedBy = "lineaTrabajo", cascade = CascadeType.ALL)
	private List<Accion> accionList;

}
