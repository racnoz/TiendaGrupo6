package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.ProveedorDAO;
import com.tienda.DTO.ProveedorDTO;


@RestController
public class ProveedorController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/registrarProveedor")
	public String registrarProveedor(ProveedorDTO proveedor) {
        ProveedorDAO Dao = new ProveedorDAO(); 
        return Dao.registrarProveedor(proveedor);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/consultarProveedor")
	public ArrayList<ProveedorDTO> consultarProveedor(int nit){
        ProveedorDAO Dao = new ProveedorDAO(); 
        return Dao.consultarProveedor(nit);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/listarProveedores")
	public ArrayList<ProveedorDTO> listaDeProveedores(){
        ProveedorDAO Dao = new ProveedorDAO();
        return Dao.listaDeProveedores();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/eliminarProveedor")
    public String eliminarProveedor(int nit) {
        ProveedorDAO Dao = new ProveedorDAO();
        return Dao.eliminarProveedor(nit);
    }
	
	
}
