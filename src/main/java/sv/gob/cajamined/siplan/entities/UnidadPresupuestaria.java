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
@Table(name = "unidad_presupuestaria", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadPresupuestaria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidad_presupuestaria")
	private Long idUnidadPresupuestaria;

	@Column(name = "nombre_unidad_presupuestaria", length = 300, nullable = false)
	private String nombreUnidadPresupuestaria;

}
