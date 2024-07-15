package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rol", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_rol")
  private Long idRol;

  @Column(name = "nombre_rol", length = 300, nullable = false)
  private String nombreRol;
}
