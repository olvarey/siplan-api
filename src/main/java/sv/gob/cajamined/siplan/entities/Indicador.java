package sv.gob.cajamined.siplan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "indicador", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Indicador implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_indicador")
    private Long idIndicador;

    @Column(name = "nombre_indicador", nullable = false, length = 300)
    private String nombreIndicador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_indicador", referencedColumnName = "id_tipo_indicador", foreignKey = @ForeignKey(name = "fk_indicador_tipo_indicador"))
    private TipoIndicador tipoIndicador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida", foreignKey = @ForeignKey(name = "fk_indicador_unidad_medida"))
    private UnidadMedida unidadMedida;

    @OneToMany(mappedBy = "indicador", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Resultado> resultadoList;
}
