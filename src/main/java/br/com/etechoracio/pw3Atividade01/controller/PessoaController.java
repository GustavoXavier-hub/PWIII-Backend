package br.com.etechoracio.pw3Atividade01.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.pw3Atividade01.dao.DaoPessoa;
import br.com.etechoracio.pw3Atividade01.model.Pessoa;



@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	
	
	@Autowired
	private DaoPessoa dao;

	@GetMapping
	public List<Pessoa> listar() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Integer id) {
		Optional<Pessoa> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	

	@PostMapping
	public void inserir(@RequestBody Pessoa pa) {
		dao.save(pa);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> delete(@PathVariable Integer id) {
		Optional<Pessoa> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Integer id, 
			@RequestBody Pessoa update) {
		
		Optional<Pessoa> resultado = dao.findById(id);
		
		if (resultado.isPresent()) {
			Pessoa pessoa1 = resultado.get();
			pessoa1.setId(id);
			pessoa1.setNome(update.getNome());
			pessoa1.setSobrenome(update.getSobrenome());
			pessoa1.setCpf(update.getCpf());
			pessoa1.setTelefone(update.getTelefone());
			pessoa1.setEmail(update.getEmail());
			pessoa1.setEndereco(update.getEndereco());
		
			
			dao.save(pessoa1);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
}
	
}	
