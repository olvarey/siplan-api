package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidad_organizativa")
	private Long idUnidadOrganizativa;

	@Column(name = "nombre_unidad_organizativa", nullable = false, length = 500)
	private String nombreUnidadOrganizativa;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_organizacion", referencedColumnName = "id_organizacion", foreignKey = @ForeignKey(name = "fk_unidad_org_organizacion"))
	private Organizacion organizacion;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_unidad_superior", referencedColumnName = "id_unidad_organizativa", foreignKey = @ForeignKey(name = "fk_unidad_org_unidad_org"))
	private UnidadOrganizativa unidadSuperior;

	@OneToMany(mappedBy = "unidadOrganizativa", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Riesgo> riesgoList;
}
