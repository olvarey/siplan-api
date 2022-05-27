package sv.gob.cajamined.siplan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sv.gob.cajamined.siplan.entities.Usuario;
import sv.gob.cajamined.siplan.repositories.UsuarioRepo;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepo usuarioRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepo.findByUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		usuario.getRoles().forEach(rol -> {
			authorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		});

		return new User(usuario.getUsuario(), usuario.getContrasenia(), authorities);
	}
}
