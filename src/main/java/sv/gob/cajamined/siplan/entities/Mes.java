package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mes", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_mes", nullable = false)
	private Long idMes;

	@Column(name = "nombre_mes", length = 300, nullable = false)
	private String nombreMes;

	@OneToMany(mappedBy = "mes", cascade = CascadeType.ALL)
	private List<Seguimiento> seguimientoList;

}
