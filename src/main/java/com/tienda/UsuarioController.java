package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.UsuarioDAO;
import com.tienda.DTO.UsuarioDTO;


@RestController
public class UsuarioController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/registrarUsuario", method=RequestMethod.POST )
	public String registrarUsuario(UsuarioDTO usuario) {
        UsuarioDAO Dao = new UsuarioDAO(); 
       return Dao.registrarUsuario(usuario);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/consultarUsuario", method=RequestMethod.GET)
	public ArrayList<UsuarioDTO> consultarUsuario(int documento){
        UsuarioDAO Dao = new UsuarioDAO(); 
        return Dao.consultarUsuario(documento);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/listarUsuarios", method=RequestMethod.GET)
	public ArrayList<UsuarioDTO> listaDeUsuarios(){
        UsuarioDAO Dao = new UsuarioDAO();
        return Dao.listaDeUsuarios();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/eliminarUsuarios", method=RequestMethod.DELETE)
    public String eliminarUsuario(int cedula) {
        UsuarioDAO Dao = new UsuarioDAO();
        return Dao.eliminarUsuario(cedula);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/comprobarUsuario", method=RequestMethod.GET)
	public boolean comprobarUsuario(String usuario, String pass) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.comprobarUsuario(usuario, pass);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/editarUsuario", method=RequestMethod.POST )
	public String editarUsuario(UsuarioDTO usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.editarUsuario(usuario);
	}
}
