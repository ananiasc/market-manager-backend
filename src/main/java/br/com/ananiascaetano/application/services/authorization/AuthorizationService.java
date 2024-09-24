package br.com.ananiascaetano.application.services.authorization;

import br.com.ananiascaetano.application.services.user.UserService;
import br.com.ananiascaetano.domain.entities.user.User;
import br.com.ananiascaetano.domain.entities.user.UserDetailsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthorizationService implements UserDetailsService {
	private final UserService userService;
	private final ModelMapper model = new ModelMapper();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsernameForAuthentication(username);
		return model.map(user, UserDetailsImpl.class);
	}
}
