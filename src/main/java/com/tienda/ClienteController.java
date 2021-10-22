package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.ClienteDAO;
import com.tienda.DAO.ClienteDAO;
import com.tienda.DTO.ClienteDTO;
import com.tienda.DTO.ClienteDTO;


@RestController
public class ClienteController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/registrarCliente", method=RequestMethod.POST )
	public String registrarCliente(ClienteDTO cliente) {
        ClienteDAO Dao = new ClienteDAO(); 
        return Dao.registrarCliente(cliente);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/consultarCliente", method=RequestMethod.GET)
	public ArrayList<ClienteDTO> consultarCliente(int documento){
        ClienteDAO Dao = new ClienteDAO(); 
        return Dao.consultarCliente(documento);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/listarClientes", method=RequestMethod.GET)
	public ArrayList<ClienteDTO> listaDeClientes(){
        ClienteDAO Dao = new ClienteDAO();
        return Dao.listaDeClientes();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/eliminarClientes", method=RequestMethod.DELETE)
    public String eliminarCliente(int cedula) {
        ClienteDAO Dao = new ClienteDAO();
        return Dao.eliminarCliente(cedula);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/editarCliente", method=RequestMethod.POST )
	public String editarCliente(ClienteDTO cliente) {
		ClienteDAO dao = new ClienteDAO();
		return dao.editarCliente(cliente);
	}
}
