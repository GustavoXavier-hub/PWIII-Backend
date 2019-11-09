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

import br.com.etechoracio.pw3Atividade01.dao.DaoUsuario;
import br.com.etechoracio.pw3Atividade01.model.Pessoa;
import br.com.etechoracio.pw3Atividade01.model.Usuario;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	

	
	@Autowired
	private DaoUsuario dao;

	@GetMapping
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Integer id) {
		Optional<Usuario> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	

	@PostMapping
	public void inserir(@RequestBody Usuario us) {
		dao.save(us);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable Integer id) {
		Optional<Usuario> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestBody Usuario update) {
		Optional<Usuario> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			Usuario usuario = resultado.get();
			usuario.setId(id);
			usuario.setUser(update.getUser());
			usuario.setPass(update.getPass());
			dao.save(usuario);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
}
	
	

}
