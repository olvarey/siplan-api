package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "periodo", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Periodo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_periodo")
	private Long idPeriodo;

	@Column(name = "anio_inicio", nullable = false)
	private Long anioInicio;

	@Column(name = "anio_fin", nullable = false)
	private Long anioFin;

	@Column(name = "nombre_periodo", length = 300, nullable = false)
	private String nombrePeriodo;

	@OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL)
	private List<Anio> anioList;
}
