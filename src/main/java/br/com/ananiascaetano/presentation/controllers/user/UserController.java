package br.com.ananiascaetano.presentation.controllers.user;

import br.com.ananiascaetano.application.services.user.UserService;
import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.domain.entities.user.User;
import br.com.ananiascaetano.expections.UsernameAlreadyExistException;
import br.com.ananiascaetano.presentation.dtos.user.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper = new ModelMapper();

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserRegisterDTO registerDTO) {
        if(userService.usernameAlreadyExist(registerDTO.getUsername())) {
            throw new UsernameAlreadyExistException(ErrorMessages.USERNAME_ALREADY_EXIST);
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getPassword());
        registerDTO.setPassword(encryptedPassword);

        User user = modelMapper.map(registerDTO, User.class);
        userService.save(user);
    }
}
