package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anio_resultado", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnioResultado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AnioResultadoPK idAnioResultadoPK;

	@Column(name = "activo", nullable = false)
	private Boolean activo;

	@ManyToOne
	@MapsId("idAnio")
	@JoinColumn(name = "id_anio", referencedColumnName = "id_anio", foreignKey = @ForeignKey(name = "fk_anio_resultado_anio"))
	private Anio anio;

	@ManyToOne
	@MapsId("idResultado")
	@JoinColumn(name = "id_resultado", referencedColumnName = "id_resultado", foreignKey = @ForeignKey(name = "fk_anio_resultado_resultado"))
	private Resultado resultado;

	@OneToMany(mappedBy = "anioResultado", cascade = CascadeType.ALL)
	private List<Accion> accionList;

}
