package br.com.ananiascaetano.application.services.user;

import br.com.ananiascaetano.domain.entities.user.User;
import br.com.ananiascaetano.expections.EntityNotFoundException;
import br.com.ananiascaetano.expections.UsernameAlreadyExistException;
import br.com.ananiascaetano.infrastructure.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import br.com.ananiascaetano.constants.ErrorMessages;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        if(usernameAlreadyExist(user.getUsername())) {
            throw new UsernameAlreadyExistException(ErrorMessages.USERNAME_ALREADY_EXIST);
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

    private boolean usernameAlreadyExist(String username) {
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

    private boolean usernameAlreadyExistWithOtherId(Long id, String username) {
        Optional<User> userExist = userRepository.findByUsername(username);
        if(userExist.isPresent()) {
            if(userExist.get().getId().equals(id)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void update(User userUpdate) {
        User user = findById(userUpdate.getId());

        if(user.isNewUsername(userUpdate.getUsername()) && usernameAlreadyExistWithOtherId(userUpdate.getId(), userUpdate.getUsername())) {
            throw new UsernameAlreadyExistException(ErrorMessages.USERNAME_ALREADY_EXIST);
        }

        user.setActive(userUpdate.isActive());
        user.setEmail(userUpdate.getEmail());
        user.setLastName(userUpdate.getLastName());
        user.setName(userUpdate.getName());
        user.setPhoneNumber(userUpdate.getPhoneNumber());
        user.setRole(user.getRole());
        user.setUsername(userUpdate.getUsername());

        userRepository.save(user);
    }

    public void delete(Long id) {
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
        .orElseThrow(() -> new EntityNotFoundException(ErrorMessages.USERNAME_NOT_FOUND) {
        });
    }
}
