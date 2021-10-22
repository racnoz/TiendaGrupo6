package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.ProveedorDAO;
import com.tienda.DAO.ProveedorDAO;
import com.tienda.DTO.ProveedorDTO;
import com.tienda.DTO.ProveedorDTO;


@RestController
public class ProveedorController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/registrarProveedor", method=RequestMethod.POST )
	public String registrarProveedor(ProveedorDTO proveedor) {
        ProveedorDAO Dao = new ProveedorDAO(); 
        return Dao.registrarProveedor(proveedor);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/consultarProveedor", method=RequestMethod.GET)
	public ArrayList<ProveedorDTO> consultarProveedor(int nit){
        ProveedorDAO Dao = new ProveedorDAO(); 
        return Dao.consultarProveedor(nit);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/listarProveedores", method=RequestMethod.GET)
	public ArrayList<ProveedorDTO> listaDeProveedores(){
        ProveedorDAO Dao = new ProveedorDAO();
        return Dao.listaDeProveedores();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/eliminarProveedores", method=RequestMethod.DELETE)
    public String eliminarProveedor(int nit) {
        ProveedorDAO Dao = new ProveedorDAO();
        return Dao.eliminarProveedor(nit);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/editarProveedor", method=RequestMethod.POST )
	public String editarProveedor(ProveedorDTO proveedor) {
		ProveedorDAO dao = new ProveedorDAO();
		return dao.editarProveedor(proveedor);
	}
}
