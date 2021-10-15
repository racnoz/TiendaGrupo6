package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.DetalleVentaDAO;
import com.tienda.DTO.DetalleVentaDTO;

@RestController
public class DetalleVentaController {

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/registrarDetalleVenta", method=RequestMethod.POST )
	public String registrarDetalleVenta(DetalleVentaDTO detalleVenta) {
        DetalleVentaDAO Dao = new DetalleVentaDAO(); 
       return Dao.registrarDetalleVenta(detalleVenta);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/consultarDetalleVenta", method=RequestMethod.GET)
	public ArrayList<DetalleVentaDTO> consultarDetalleVenta(int codigo){
        DetalleVentaDAO Dao = new DetalleVentaDAO(); 
        return Dao.consultarDetalleVenta(codigo);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/listarDetalleVentas", method=RequestMethod.GET)
	public ArrayList<DetalleVentaDTO> listaDeDetalleVentas(){
        DetalleVentaDAO Dao = new DetalleVentaDAO();
        return Dao.listaDeDetalleVentas();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/eliminarDetalleVenta", method=RequestMethod.DELETE)
    public String eliminarDetalleVenta(int codigo) {
        DetalleVentaDAO Dao = new DetalleVentaDAO();
        return Dao.eliminarDetalleVenta(codigo);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/editarDetalleVenta", method=RequestMethod.POST )
	public void editarDetalleVenta(DetalleVentaDTO detalleVenta) {
		DetalleVentaDAO dao = new DetalleVentaDAO();
		dao.editarDetalleVenta(detalleVenta);
	}
	
}
