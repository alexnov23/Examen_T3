package com.example.examen.init;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authorization.AuthorityReactiveAuthorizationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Usuario;
import com.example.examen.repository.AuthoryRepository;
import com.example.examen.repository.UsuarioRepository;



@Service
public class InitDB implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthoryRepository authorityRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		this.usuarioRepository.deleteAll();
		this.authorityRepository.deleteAll();
		
		Usuario camareros = new Usuario();
		camareros.setUsername("profe");
		camareros.setPassword(passwordEncoder.encode("1234"));
		camareros.setNombres("profesor");
		camareros.setEnable(true);
		
		Usuario gerente = new Usuario();
		gerente.setUsername("alcalde");
		gerente.setPassword(passwordEncoder.encode("alcalde"));
		gerente.setNombres("alcalde");
		gerente.setEnable(true);
        
		camareros.addAuthority("ROLE_CAMAREROS");
		camareros.addAuthority("ACCESS_PEDIDO_READ");
		camareros.addAuthority("ACCESS_PEDIDO_WRITE");
		gerente.addAuthority("ROLE_ADMIN");
		gerente.addAuthority("ACCESS_REST1");
		gerente.addAuthority("ACCESS_REST2");
        
        List<Usuario> usuarios = Arrays.asList(camareros, gerente);        
        this.usuarioRepository.saveAll(usuarios);*/
	}
}
