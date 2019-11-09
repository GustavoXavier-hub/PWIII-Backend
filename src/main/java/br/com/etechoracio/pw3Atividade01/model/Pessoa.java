package br.com.etechoracio.pw3Atividade01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="PESSOA")
@Entity
@Setter
@Getter
public class Pessoa {
	
	
	
		@GeneratedValue
		@Column (name="IDPESSOA")
		@Id
		private int id;
		
		@Column (name="NOMEPESSOA")
		private String nome;
		
		@Column (name="SOBRENOMEPESSOA")
		private String  sobrenome;
		
		@Column (name="CPFPESSOA")
		private String cpf;
		
		@Column (name="TELPESSOA")
		private String telefone;
		
		@Column (name="EMAILPESSOA")
		private  String email;
		
		@Column (name="ENDPESSOA")
		private String Endereco;
		
		
		
	
}
