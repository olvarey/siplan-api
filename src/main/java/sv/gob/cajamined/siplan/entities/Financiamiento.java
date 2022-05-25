package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "financiamiento", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Financiamiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_financiamiento")
	private Long idFinanciamiento;
	@Basic(optional = false)

	@Column(name = "nombre_financiamiento", length = 300, nullable = false)
	private String nombreFinanciamiento;

	@OneToMany(mappedBy = "financiamiento", cascade = CascadeType.ALL)
	private List<Accion> accionList;
}
