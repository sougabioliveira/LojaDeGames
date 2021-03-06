package com.generation.lojadegames.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojadegames.model.UsuarioLoginModel;
import com.generation.lojadegames.model.UsuarioModel;
import com.generation.lojadegames.repository.UsuarioRepository;
import com.generation.lojadegames.service.UsuarioService;



@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

		
	@GetMapping("/all")
	public ResponseEntity<List<UsuarioModel>> getAll() {

			return ResponseEntity.ok(usuarioRepository.findAll());

		}

		@PostMapping("/logar")
		public ResponseEntity<UsuarioLoginModel> login(@RequestBody Optional<UsuarioLoginModel> user) {
			return usuarioService.autenticaUsuario(user).map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		}

		@PostMapping("/cadastrar")
		public ResponseEntity<UsuarioModel> postUsuario(@Valid @RequestBody UsuarioModel usuario) {

			return usuarioService.cadastraUsuario(usuario)
					.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
					.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

		}
		
		 @PutMapping
		 public ResponseEntity<UsuarioModel> put (@Valid @RequestBody UsuarioModel usuario) {
			 return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
		 }
		 
		 @DeleteMapping("/{id}")
		 public void delete(@PathVariable long id) {
			usuarioRepository.deleteById(id); 
		 }
	}
