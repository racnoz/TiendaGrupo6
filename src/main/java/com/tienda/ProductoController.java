package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.ProductoDAO;
import com.tienda.DTO.ProductoDTO;


@RestController
public class ProductoController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/registrarProducto", method=RequestMethod.POST )
	public String registrarProducto(ProductoDTO usuario) {
        ProductoDAO Dao = new ProductoDAO(); 
       return Dao.registrarProducto(usuario);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/consultarProducto", method=RequestMethod.GET)
	public ArrayList<ProductoDTO> consultarProducto(int codigo){
        ProductoDAO Dao = new ProductoDAO(); 
        return Dao.consultarProducto(codigo);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/listarProductos", method=RequestMethod.GET)
	public ArrayList<ProductoDTO> listaDeProductos(){
        ProductoDAO Dao = new ProductoDAO();
        return Dao.listaDeProductos();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/eliminarProductos", method=RequestMethod.DELETE)
    public String eliminarProducto(int codigo) {
        ProductoDAO Dao = new ProductoDAO();
        return Dao.eliminarProducto(codigo);
    }
}
