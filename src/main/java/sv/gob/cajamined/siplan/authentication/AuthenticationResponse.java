package sv.gob.cajamined.siplan.authentication;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AuthenticationResponse {

	@Getter
	private final String access_token;

	@Getter
	private final Collection<String> roles;

}
