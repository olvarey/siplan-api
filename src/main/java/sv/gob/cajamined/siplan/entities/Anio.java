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
