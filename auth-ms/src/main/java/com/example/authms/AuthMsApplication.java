package com.example.authms;

import com.example.authms.dto.RegisterRequest;
import com.example.authms.model.Enseignant;
import com.example.authms.model.Etudiant;
import com.example.authms.model.Role;
import com.example.authms.repository.EnseignantRepository;
import com.example.authms.repository.EtudiantRepository;
import com.example.authms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
//@EnableResourceServer
public class AuthMsApplication {
	@Autowired
	private AuthService accountService;
	private RegisterRequest registerRequest = new RegisterRequest();

	public static void main(String[] args) {
		SpringApplication.run(AuthMsApplication.class, args);
	}



	@Bean
	CommandLineRunner start(EnseignantRepository enseignantRepository){
		return args -> {
			accountService.save(new Role(null, "USER"));
			accountService.save(new Role(null, "ADMIN"));
			accountService.save(new Role(null, "ETUDIANT"));
			accountService.save(new Role(null, "ENSEIGNANT"));
			Stream.of("user1","user2", "user3", "admin").forEach(username -> {
				registerRequest.setUsername(username);
				registerRequest.setPassword("12345");
				registerRequest.setConfirmedPassword("12345");
				accountService.saveUser(registerRequest);
			});

			accountService.addRoleToUser("admin","ADMIN");
//			enseignantRepository.save(new Enseignant(null, ))
		};
	}

	@Bean
	BCryptPasswordEncoder getBCryptePasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
