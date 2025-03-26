package br.com.ananiascaetano.mappers.user;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.ananiascaetano.domain.entities.user.User;
import br.com.ananiascaetano.presentation.dtos.user.UserDto;

public class UserMapper {
private ModelMapper model;
	
	public UserMapper() {
		this.model = new ModelMapper();
	}

    public List<UserDto> convertToEntityDTOList(List<User> users) {
        return users.stream()
                .map(user -> this.model.map(user, UserDto.class))
                .collect(Collectors.toList());
    }
}
