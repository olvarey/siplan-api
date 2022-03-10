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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "indicador", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Indicador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_indicador")
	private Long idIndicador;

	@Column(name = "nombre_indicador", nullable = false, length = 300)
	private String nombreIndicador;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_indicador", referencedColumnName = "id_tipo_indicador", foreignKey = @ForeignKey(name = "fk_indicador_tipo_indicador"))
	private TipoIndicador tipoIndicador;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida", foreignKey = @ForeignKey(name = "fk_indicador_unidad_medida"))
	private UnidadMedida unidadMedida;

	@OneToMany(mappedBy = "indicador", cascade = CascadeType.ALL)
	private List<Resultado> resultadoList;
}
