package sv.gob.cajamined.siplan.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipo_objetivo", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoObjetivo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_objetivo")
	private Long idTipoObjetivo;

	@Column(name = "nombre_tipo_objetivo", length = 300, nullable = false)
	private String nombreTipoObjetivo;

	@OneToMany(mappedBy = "tipoObjetivo", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Objetivo> objetivoList;

}
