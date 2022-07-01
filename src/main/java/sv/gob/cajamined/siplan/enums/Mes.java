package sv.gob.cajamined.siplan.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum Mes {
    ENERO(1, "ENERO"),
    FEBRERO(2, "FEBRERO"),
    MARZO(3, "MARZO"),
    ABRIL(4, "ABRIL"),
    MAYO(5, "MAYO"),
    JUNIO(6, "JUNIO"),
    JULIO(7, "JULIO"),
    AGOSTO(8, "AGOSTO"),
    SEPTIEMBRE(9, "SEPTIEMBRE"),
    OCTUBRE(10, "OCTUBRE"),
    NOVIEMBRE(11, "NOVIEMBRE"),
    DICIEMBRE(12, "DICIEMBRE");

    private int idMes;
    private String nombreMes;

}
