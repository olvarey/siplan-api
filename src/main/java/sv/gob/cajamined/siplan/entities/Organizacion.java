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
@Table(name = "organizacion", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organizacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_organizacion")
	private Long idOrganizacion;

	@Column(name = "nombre_organizacion", nullable = false, length = 500)
	private String nombreOrganizacion;

	@Column(name = "descripcion_organizacion", length = 500)
	private String descripcionOrganizacion;

	@Column(name = "mision_organizacion", length = 500)
	private String misionOrganizacion;

	@Column(name = "vision_organizacion", length = 500)
	private String visionOrganizacion;

	@OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Objetivo> objetivoList;

	@OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<UnidadOrganizativa> unidadOrganizativaList;

}
