package br.com.ananiascaetano.application.services.user;

import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.domain.entities.user.User;
import br.com.ananiascaetano.infrastructure.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User findByUsernameForAuthentication(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new AuthenticationException(ErrorMessages.AUTHENTICATION_FAIL) {
                });
    }
}
