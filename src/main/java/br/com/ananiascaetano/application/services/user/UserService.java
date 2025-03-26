package br.com.ananiascaetano.application.services.user;

import br.com.ananiascaetano.domain.entities.user.User;
import br.com.ananiascaetano.expections.EntityNotFoundException;
import br.com.ananiascaetano.infrastructure.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import br.com.ananiascaetano.constants.ErrorMessages;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean usernameAlreadyExist(String username) {
        Optional<User> userExist = userRepository.findByUsername(username);
        return userExist.isPresent();
    }
    
    public User findByUsernameForAuthentication(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new AuthenticationException(ErrorMessages.AUTHENTICATION_FAIL) {
                });
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(ErrorMessages.USERNAME_NOT_FOUND) {
        });
    }
}
