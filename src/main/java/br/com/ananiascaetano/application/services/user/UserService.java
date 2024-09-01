package br.com.ananiascaetano.application.services.user;

import br.com.ananiascaetano.domain.entities.user.User;
import br.com.ananiascaetano.infrastructure.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean usernameAlreadyExist(String username) {
        UserDetails userExist = userRepository.findByUsername(username);
        return userExist != null;
    }
}
