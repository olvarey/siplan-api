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
	@Column(name = "id_org")
	private Integer idOrg;

	@Column(name = "nombre_org", nullable = false, length = 500)
	private String nombreOrg;

	@Column(name = "descripcion_org", columnDefinition = "text")
	private String descripcionOrg;

	@Column(name = "mision_org", columnDefinition = "text not null")
	private String misionOrg;

	@Column(name = "vision_org", columnDefinition = "text not null")
	private String visionOrg;

	@OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
	private List<Objetivo> objetivoList;

	@OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
	private List<UnidadOrganizativa> unidadOrganizativaList;

}
