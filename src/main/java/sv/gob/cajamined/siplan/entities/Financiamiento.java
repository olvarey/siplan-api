package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
