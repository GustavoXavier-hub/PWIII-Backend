package br.com.etechoracio.pw3Atividade01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="USUARIO")
@Entity
@Setter
@Getter
public class Usuario {

	@GeneratedValue
	@Column(name = "IDUSUARIO")
	@Id
	private int id;

	@Column(name = "USERUSUARIO")
	private String user;

	@Column(name = "PASSUSUARIO")
	private String pass;
	

}
