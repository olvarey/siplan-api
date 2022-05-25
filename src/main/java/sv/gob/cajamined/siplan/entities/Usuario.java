package sv.gob.cajamined.siplan.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "usuario", schema = "siplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "nombre_usuario", length = 300, nullable = false)
	private String nombreUsuario;

	@Column(name = "usuario", length = 100, nullable = false)
	private String usuario;

	@Column(name = "contrasenia", length = 100, nullable = false)
	private String contrasenia;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", schema = "siplan", joinColumns = @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_usuario_rol_usuario")), inverseJoinColumns = @JoinColumn(name = "id_rol", foreignKey = @ForeignKey(name = "fk_usuario_rol_rol")))
	private Collection<Rol> roles;
}