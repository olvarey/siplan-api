package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "tipo_plan", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoPlan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_plan")
	private Long idTipoPlan;

	@Column(name = "nombre_tipo_plan", length = 300, nullable = false)
	private String nombreTipoPlan;

	@OneToMany(mappedBy = "tipoPlan", cascade = CascadeType.ALL)
	private List<Plan> planList;

}
