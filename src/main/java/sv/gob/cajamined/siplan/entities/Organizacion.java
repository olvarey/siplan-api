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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(value = { "objetivoList", "unidadOrganizativaList" })
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
	private List<Objetivo> objetivoList;

	@OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
	private List<UnidadOrganizativa> unidadOrganizativaList;

}
