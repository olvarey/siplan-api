package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import sv.gob.cajamined.siplan.enums.ExposicionDescripcion;
import sv.gob.cajamined.siplan.enums.FrecuenciaDescripcion;
import sv.gob.cajamined.siplan.enums.ImpactoDescripcion;

@Entity
@Table(name = "riesgo", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Riesgo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_riesgo")
    private Long idRiesgo;

    @Column(name = "descripcion_riesgo", length = 500, nullable = false)
    private String descripcionRiesgo;

    @Enumerated(EnumType.STRING)
    @Column(name = "frecuencia_descripcion", length = 100, nullable = false)
    private FrecuenciaDescripcion frecuenciaDescripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "impacto_descripcion", length = 100, nullable = false)
    private ImpactoDescripcion impactoDescripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "exposicion_descripcion", length = 100, nullable = false)
    private ExposicionDescripcion exposicionDescripcion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_codigo_riesgo", referencedColumnName = "id_codigo_riesgo", foreignKey = @ForeignKey(name = "fk_riesgo_codigo_riesgo"))
    private CodigoRiesgo codigoRiesgo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_categoria_riesgo", referencedColumnName = "id_categoria_riesgo", foreignKey = @ForeignKey(name = "fk_riesgo_categoria_riesgo"))
    private CategoriaRiesgo categoriaRiesgo;

    @OneToMany(mappedBy = "riesgo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EstrategiaRiesgo> estrategiaRiesgoList;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_objetivo", referencedColumnName = "id_objetivo", foreignKey = @ForeignKey(name = "fk_riesgo_objetivo"))
    private Objetivo objetivo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_unidad_responsable", referencedColumnName = "id_unidad_organizativa", foreignKey = @ForeignKey(name = "fk_riesgo_unidad_organizativa"))
    private UnidadOrganizativa unidadOrganizativa;
}
