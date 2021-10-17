package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.VentaDAO;
import com.tienda.DTO.TotalVentasDTO;
import com.tienda.DTO.VentaDTO;

@RestController
public class VentaController {

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/registrarVenta", method=RequestMethod.POST )
	public String registrarVenta(VentaDTO venta) {
        VentaDAO Dao = new VentaDAO(); 
       return Dao.registrarVenta(venta);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/consultarVenta", method=RequestMethod.GET)
	public ArrayList<VentaDTO> consultarVenta(int codigo){
        VentaDAO Dao = new VentaDAO(); 
        return Dao.consultarVenta(codigo);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/listarVentas", method=RequestMethod.GET)
	public ArrayList<VentaDTO> listaDeVentas(){
        VentaDAO Dao = new VentaDAO();
        return Dao.listaDeVentas();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/eliminarVenta", method=RequestMethod.DELETE)
    public String eliminarVenta(int codigo) {
        VentaDAO Dao = new VentaDAO();
        return Dao.eliminarVenta(codigo);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/editarVenta", method=RequestMethod.POST )
	public void editarVenta(VentaDTO venta) {
		VentaDAO dao = new VentaDAO();
		dao.editarVenta(venta);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/listarVentasUsuario", method=RequestMethod.GET)
	public ArrayList<TotalVentasDTO> listaVentasUsuario(){
        VentaDAO Dao = new VentaDAO();
        return Dao.listarVentasUsuario();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/sumarVentas", method=RequestMethod.GET)
	public double sumaVentas(){
        VentaDAO Dao = new VentaDAO();
        return Dao.sumarVentas();
    }
	
}
