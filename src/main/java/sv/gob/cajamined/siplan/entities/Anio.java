package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "anio", schema = "siplan", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "id_anio", "id_periodo" }, name = "unique_anio_periodo") })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Anio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_anio")
	private Long idAnio;

	@Column(name = "valor_anio", nullable = false)
	private Long valorAnio;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo", foreignKey = @ForeignKey(name = "fk_anio_periodo"))
	private Periodo periodo;

	@OneToMany(mappedBy = "anio", cascade = CascadeType.ALL)
	private List<AnioResultado> anioResultadoList;

}
