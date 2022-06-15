package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unidad_organizativa", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadOrganizativa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidad_organizativa")
	private Long idUnidadOrganizativa;

	@Column(name = "nombre_unidad_organizativa", nullable = false, length = 500)
	private String nombreUnidadOrganizativa;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_organizacion", referencedColumnName = "id_organizacion", foreignKey = @ForeignKey(name = "fk_unidad_org_organizacion"))
	@JsonIgnoreProperties("unidadOrganizativaList")
	private Organizacion organizacion;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_unidad_superior", referencedColumnName = "id_unidad_organizativa", foreignKey = @ForeignKey(name = "fk_unidad_org_unidad_org"))
	private UnidadOrganizativa unidadSuperior;
}
