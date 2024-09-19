package br.com.ananiascaetano.domain.entities.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	private String username;
	private String password;
	@Column(name = "is_active")
	private boolean active;
	@Column(name = "phone_number")
	private String phoneNumber;
	private UserRole role;
}
