package sv.gob.cajamined.siplan.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class AuthenticationResponse {

	@Getter
	private final String access_token;

}
