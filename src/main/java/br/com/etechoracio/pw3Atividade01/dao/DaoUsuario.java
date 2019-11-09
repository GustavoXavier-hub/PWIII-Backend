package br.com.etechoracio.pw3Atividade01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.pw3Atividade01.model.Usuario;

public interface DaoUsuario extends JpaRepository<Usuario, Integer> {
	

}
