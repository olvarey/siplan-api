package sv.gob.cajamined.siplan.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sv.gob.cajamined.siplan.enums.Mes;

@Entity
@Table(name = "seguimiento_riesgo", schema = "siplan", uniqueConstraints = {
  @UniqueConstraint(columnNames = {"id_estrategia_riesgo",
    "mes"}, name = "unique_estrategia_riesgo_mes")})
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

  @Column(name = "fecha_ejecucion_seguimiento")
  @Temporal(TemporalType.DATE)
  private Date fechaEjecucionSeguimiento;

  @Enumerated(EnumType.STRING)
  @Column(name = "mes", length = 100, nullable = false)
  private Mes mes;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_estrategia_riesgo", referencedColumnName = "id_estrategia_riesgo", foreignKey = @ForeignKey(name = "fk_seguimiento_estrategia_riesgo"))
  private EstrategiaRiesgo estrategiaRiesgo;
}
