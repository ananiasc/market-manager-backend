package br.com.ananiascaetano.presentation.dtos.user;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String username;
    private boolean active;
    private String phoneNumber;
    private String role;
}
