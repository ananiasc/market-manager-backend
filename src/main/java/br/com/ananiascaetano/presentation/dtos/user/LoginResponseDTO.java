package br.com.ananiascaetano.presentation.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
	private String token;
}