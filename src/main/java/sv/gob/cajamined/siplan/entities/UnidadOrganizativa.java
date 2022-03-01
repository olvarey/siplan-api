package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	@Column(name = "id_unidad_org")
	private Integer idUnidadOrg;

	@Column(name = "nombre_unidad_org", nullable = false, length = 500)
	private String nombreUnidadOrg;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_org", referencedColumnName = "id_org", foreignKey = @ForeignKey(name = "fk_unidad_org_organizacion"))
	private Organizacion organizacion;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_unidad_superior", referencedColumnName = "id_unidad_org", foreignKey = @ForeignKey(name = "fk_unidad_org_unidad_org"))
	private UnidadOrganizativa unidadSuperior;
}
