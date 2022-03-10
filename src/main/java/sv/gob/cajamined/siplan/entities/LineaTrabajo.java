package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "linea_trabajo", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineaTrabajo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_linea_trabajo")
	private Long idLineaTrabajo;

	@Column(name = "nombre_linea_trabajo", length = 300, nullable = false)
	private String nombreLineaTrabajo;

}
