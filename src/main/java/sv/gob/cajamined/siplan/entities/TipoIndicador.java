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
@Table(name = "tipo_indicador", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoIndicador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_indicador")
	private Long idTipoIndicador;

	@Column(name = "nombre_tipo_indicador", nullable = false, length = 300)
	private String nombreIndicador;

	@OneToMany(mappedBy = "tipoIndicador", cascade = CascadeType.ALL)
	private List<Indicador> indicadorList;

}
