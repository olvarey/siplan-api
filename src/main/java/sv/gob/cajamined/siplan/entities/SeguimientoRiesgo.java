package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sv.gob.cajamined.siplan.enums.Mes;

@Entity
@Table(name = "seguimiento_riesgo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeguimientoRiesgo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguimiento_riesgo")
    private Long idSeguimientoRiesgo;

    @Column(name = "detalle_seguimiento_riesgo", length = 500, nullable = false)
    private String detalleSeguimientoRiesgo;

    @Column(name = "presupuesto_ejecutado")
    private double presupuestoEjecutado;

    @Column(name = "numero_acciones_mensuales")
    private Long numeroAccionesMensuales;

    @Column(name = "ejecutado")
    private Boolean ejecutado;

    @Enumerated(EnumType.STRING)
    @Column(name = "mes", length = 100, nullable = false)
    private Mes mes;

}
