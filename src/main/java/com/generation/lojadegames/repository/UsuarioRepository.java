package com.generation.lojadegames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.generation.lojadegames.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	//quando temos mais de uma possivel resposta
	public Optional<UsuarioModel> findByUsuario(String usuario);
}
