package com.concretepage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Usuario;
import com.concretepage.service.IUsuarioService;

@Controller
@RequestMapping("user")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	@GetMapping("usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Integer id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@GetMapping("usuarios")
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		List<Usuario> list = usuarioService.getAllUsuarios();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	@PostMapping("usuario")
	public ResponseEntity<Void> addUsuario(@RequestBody Usuario usuario, UriComponentsBuilder builder) {
        boolean flag = usuarioService.addUsuario(usuario);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("usuario")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		usuarioService.updateUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@DeleteMapping("usuario/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Integer id) {
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 