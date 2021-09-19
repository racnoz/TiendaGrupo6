package com.mintic.tiendavirtual.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tiendavirtual.DAO.UsuariosDAO;
import com.mintic.tiendavirtual.modelo.Usuarios;


@RestController
@RequestMapping("usuarios")
public class UsuariosAPI {
	
	@Autowired
	private UsuariosDAO usuariosDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Usuarios usuarios) {
		usuariosDAO.save(usuarios);
	}
	@GetMapping("/listar")
	public List<Usuarios> Listar(){
		return usuariosDAO.findAll();
	}
	@DeleteMapping("/eliminar/{id}")
	public void eliminar (@PathVariable("Id") Integer id ) {
		usuariosDAO.deleteById(id);
	}
	@PutMapping("/actualizar")
	public void actualizar (@RequestBody Usuarios usuarios) {
		usuariosDAO.save(usuarios);
	}
	
}
