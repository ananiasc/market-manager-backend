package br.com.ananiascaetano.presentation.controllers.user;

import br.com.ananiascaetano.application.services.user.UserService;
import br.com.ananiascaetano.domain.entities.user.User;
import br.com.ananiascaetano.mappers.user.UserMapper;
import br.com.ananiascaetano.presentation.dtos.user.UserDto;
import br.com.ananiascaetano.presentation.dtos.user.UserRegisterDTO;
import br.com.ananiascaetano.presentation.dtos.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper = new ModelMapper();
    private final UserMapper userMapper = new UserMapper();

    @GetMapping()
    public List<UserDto> findAll() {
        List<User> users = userService.findAll();
        return userMapper.convertToEntityDTOList(users);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return modelMapper.map(user, UserDto.class);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserRegisterDTO registerDTO) {
        User user = modelMapper.map(registerDTO, User.class);
        userService.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public void update(@RequestBody UserUpdateDto userUpdateDto) {
        User user = modelMapper.map(userUpdateDto, User.class);
        userService.update(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
