package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "unidad_medida", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadMedida implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidad_medida")
	private Long idUnidadMedida;

	@Column(name = "nombre_unidad_medida", nullable = false, length = 300)
	private String nombreUnidadMedida;

	@OneToMany(mappedBy = "unidadMedida", cascade = CascadeType.ALL)
	private List<Indicador> indicadorList;

}
