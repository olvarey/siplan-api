package sv.gob.cajamined.siplan.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import sv.gob.cajamined.siplan.entities.Rol;
import sv.gob.cajamined.siplan.entities.Usuario;
import sv.gob.cajamined.siplan.repositories.RolRepo;
import sv.gob.cajamined.siplan.repositories.UsuarioRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@Slf4j
public class UsuarioController implements UserDetailsService {

	@Autowired
	private UsuarioRepo usuarioRepo;

	@Autowired
	private RolRepo rolRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Usuario usuarioLogueado = usuarioRepo.findByUsuario(usuario);
		if (usuarioLogueado == null) {
			log.info("Usuario no encontrado en la base de datos");
			throw new UsernameNotFoundException("Usuario no encontrado en la base de datos");
		} else {
			log.info("Usuario {} encontrado en la base de datos", usuarioLogueado);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		usuarioLogueado.getRoles().forEach(rol -> {
			authorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		});
		return new User(usuarioLogueado.getUsuario(), usuarioLogueado.getContrasenia(), authorities);
	}

	@GetMapping(value = "usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		return ResponseEntity.ok().body(usuarioRepo.findAll());
	}

	@PostMapping(value = "usuario/crear")
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api-siplan/v1/usuario/crear")
				.toUriString());
		usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
		return ResponseEntity.created(uri).body(usuarioRepo.save(usuario));
	}

	@PostMapping(value = "rol/crear")
	public ResponseEntity<Rol> saveRol(@RequestBody Rol rol) {
		URI uri = URI.create(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("/api-siplan/v1/rol/crear").toUriString());
		return ResponseEntity.created(uri).body(rolRepo.save(rol));
	}
}
