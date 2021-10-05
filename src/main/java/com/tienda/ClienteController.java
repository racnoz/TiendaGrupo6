package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.ClienteDAO;
import com.tienda.DTO.ClienteDTO;


@RestController
public class ClienteController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/registrarCliente")
	public void registrarCliente(ClienteDTO cliente) {
        ClienteDAO Dao = new ClienteDAO(); 
        Dao.registrarCliente(cliente);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/consultarCliente")
	public ArrayList<ClienteDTO> consultarCliente(int documento){
        ClienteDAO Dao = new ClienteDAO(); 
        return Dao.consultarCliente(documento);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/listarClientes")
	public ArrayList<ClienteDTO> listaDeClientes(){
        ClienteDAO Dao = new ClienteDAO();
        return Dao.listaDeClientes();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/eliminarClientes")
    public void eliminarCliente(int cedula) {
        ClienteDAO Dao = new ClienteDAO();
        Dao.eliminarCliente(cedula);
    }
}
