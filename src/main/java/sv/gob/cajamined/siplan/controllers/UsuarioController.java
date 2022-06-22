package sv.gob.cajamined.siplan.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.gob.cajamined.siplan.authentication.AuthenticationRequest;
import sv.gob.cajamined.siplan.authentication.AuthenticationResponse;
import sv.gob.cajamined.siplan.entities.Usuario;
import sv.gob.cajamined.siplan.repositories.UsuarioRepo;
import sv.gob.cajamined.siplan.services.MyUserDetailsService;
import sv.gob.cajamined.siplan.util.JwtUtil;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class UsuarioController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UsuarioRepo usuarioRepo;

	@GetMapping(value = "usuarios")
	private List<Usuario> getAllRoles() {
		return usuarioRepo.findByOrderByIdUsuarioAsc();
	}

	@GetMapping(value = "usuarios/{idUsuario}")
	private Optional<Usuario> getUsuarioById(@PathVariable Long idUsuario) {
		return usuarioRepo.findById(idUsuario);
	}

	@PostMapping(value = "usuarios")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return usuarioRepo.save(usuario);
	}

	@DeleteMapping(value = "usuarios")
	public void deleteUsuario(@RequestBody Usuario usuario) {
		usuarioRepo.delete(usuario);
	}

	@PostMapping(value = "authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Usuario ó contraseña incorrectos", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final Collection<String> roles = new ArrayList<>();
		userDetails.getAuthorities().forEach(rol -> {
			roles.add(rol.getAuthority());
		});

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt, roles));
	}
}
