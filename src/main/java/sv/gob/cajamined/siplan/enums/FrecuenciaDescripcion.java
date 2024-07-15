package sv.gob.cajamined.siplan.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum FrecuenciaDescripcion {
  BAJA(1, "BAJA"),
  MODERADA(2, "MODERADA"),
  ALTA(3, "ALTA");

  private int idFrecuencia;
  private String nombreFrecuencia;
}
