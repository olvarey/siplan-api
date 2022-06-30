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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "codigo_riesgo", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodigoRiesgo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_codigo_riesgo")
    private Long idCodigoRiesgo;

    @Column(name = "nombre_codigo_riesgo", length = 300, nullable = false)
    private String nombreCodigoRiesgo;

    @OneToMany(mappedBy = "codigoRiesgo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Riesgo> riesgoList;
}
