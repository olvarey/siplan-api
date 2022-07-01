package sv.gob.cajamined.siplan.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum FODA {
    FORTALEZA(1, "FORTALEZA"),
    OPORTUNIDAD(2, "OPORTUNIDAD"),
    DEBILIDAD(3, "DEBILIDAD"),
    AMENAZA(4, "AMENAZA");

    private int idFODA;
    private String cuadrante;
}
