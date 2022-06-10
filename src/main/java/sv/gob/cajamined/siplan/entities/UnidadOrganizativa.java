package sv.gob.cajamined.siplan.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_organizacion", referencedColumnName = "id_organizacion", foreignKey = @ForeignKey(name = "fk_unidad_org_organizacion"))
//	@JsonBackReference
	private Organizacion organizacion;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_unidad_superior", referencedColumnName = "id_unidad_organizativa", foreignKey = @ForeignKey(name = "fk_unidad_org_unidad_org"))
	//@JsonBackReference
	private UnidadOrganizativa unidadSuperior;
}
