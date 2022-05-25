package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
