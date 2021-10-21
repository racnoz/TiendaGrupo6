package com.tienda.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tienda.DTO.TotalVentasDTO;
import com.tienda.DTO.VentaDTO;

public class VentaDAO {
	PreparedStatement preparedStatement;
	public String registrarVenta(VentaDTO venta) {
        Conexion conex = new Conexion();
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("INSERT INTO ventas VALUES ('"+venta.getCodigoVenta()+"', '"
                     +venta.getCedulaCliente()+"', '"+venta.getCedulaUsuario()+"','"+venta.getIvaVenta()+"', '"+venta.getTotalVenta()+"', '"+venta.getValorVenta()+"')");
            st.close();
            conex.desconectar();
            return "Se ha registrado exitosamente la venta";
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo agregar la venta";
        }
    }
	public ArrayList<VentaDTO> consultarVenta(int codigo){
        ArrayList<VentaDTO> miVenta = new ArrayList<VentaDTO>();
        Conexion conex = new Conexion();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas WHERE codigo_venta = ?");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            if(res.next()) {
                VentaDTO venta = new VentaDTO();
                venta.setCodigoVenta(Integer.parseInt(res.getString("codigo_venta")));
                venta.setCedulaCliente(Long.parseLong(res.getString("cedula_cliente")));
                venta.setCedulaUsuario(Long.parseLong(res.getString("cedula_usuario")));
                venta.setIvaVenta(Double.parseDouble(res.getString("ivaventa")));
                venta.setTotalVenta(Double.parseDouble(res.getString("total_venta")));
                venta.setValorVenta(Double.parseDouble(res.getString("valor_venta")));
                miVenta.add(venta);
            }
            res.close();
            consulta.close();
            conex.desconectar();
        }catch(Exception e) {
        	e.printStackTrace();
             System.out.print("no se pudo consultar al venta ");
        }
        return miVenta;
    }
	
	public ArrayList<VentaDTO> listaDeVentas() {
        ArrayList< VentaDTO> miVenta = new ArrayList< VentaDTO>();
        Conexion conex= new Conexion();
          
        try {
         PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");
         ResultSet res = consulta.executeQuery();
         while(res.next()){
        	 VentaDTO venta = new VentaDTO();
             venta.setCodigoVenta(Integer.parseInt(res.getString("codigo_venta")));
             venta.setCedulaCliente(Long.parseLong(res.getString("cedula_cliente")));
             venta.setCedulaUsuario(Long.parseLong(res.getString("cedula_usuario")));
             venta.setIvaVenta(Double.parseDouble(res.getString("ivaventa")));
             venta.setTotalVenta(Double.parseDouble(res.getString("total_venta")));
             venta.setValorVenta(Double.parseDouble(res.getString("valor_venta")));
             miVenta.add(venta);
        }
        res.close();
        consulta.close();
        conex.desconectar();
         
       } catch (Exception e) {
         //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
       }
        return miVenta;
    }
	
	public String eliminarVenta(int codigo) {
        Conexion conex= new Conexion();
        try {
            String query = "DELETE FROM ventas WHERE codigo_venta = ?";
            preparedStatement = conex.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            return "Se ha eliminado la venta";
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo eliminar la venta";
        }
    }
	
	public void editarVenta(VentaDTO venta) {
		Conexion conex = new Conexion();
		try {
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate("UPDATE ventas SET cedula_cliente = '"+venta.getCedulaCliente()+"', cedula_usuario = '"+venta.getCedulaUsuario()+"', ivaventa='"+venta.getIvaVenta()+"', total_venta='"+venta.getTotalVenta()+"', valor_venta='"+venta.getValorVenta()+"' WHERE codigo_venta="+venta.getCodigoVenta());
			st.close();
			conex.desconectar();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 
	
	public ArrayList<TotalVentasDTO> listarVentasUsuario() {
		ArrayList<TotalVentasDTO> totales = new ArrayList<TotalVentasDTO>();
        Conexion conex= new Conexion();
          
        try {
        	/*
        	 * El siguiente comando SQL permite obtener una tabla con los resulatados correspondientes a la cedula del cliente (tabla clientes), nombre del cliente (tabla clientes), y la suma de los valores de ventas (tabla ventas) y los agrupa segúin la cédula del cliente
        	 * 	*El comando "sum(columna)" permite calcular la suma de una columna de una tabla
        	 * 	*El comando "tabla1 INNER JOIN tabla 2 ON condition" une las 2 tablas según los valores iguales de una columna de cada tabla
        	 * 	*El comando "GROUP BY param" agrupa los elementos de una tabla seún un parámetro específico. 
        	 */
        	PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT clientes.cedula_cliente, clientes.nombre_cliente, sum(ventas.valor_venta) FROM clientes INNER JOIN ventas ON clientes.cedula_cliente=ventas.cedula_cliente GROUP BY cedula_cliente");
        	ResultSet res = consulta.executeQuery();
        	while(res.next()) {
        		TotalVentasDTO total = new TotalVentasDTO();
        		total.setSuma(Double.parseDouble(res.getString("sum(ventas.valor_venta)")));
        		total.setCedula(Integer.parseInt(res.getString("cedula_cliente")));
        		total.setNombre(res.getString("nombre_cliente"));
        		totales.add(total);
	       }
	       res.close();
	       consulta.close();
	       conex.desconectar();
       } catch (Exception e) {
    	   e.printStackTrace();//JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
       }
        return totales;
	}
	
	public double sumarVentas() {
		double suma = 0;
		Conexion conex= new Conexion();
        
        try {
         PreparedStatement consulta = conex.getConnection().prepareStatement("select sum(valor_venta) from ventas");
         ResultSet res = consulta.executeQuery();
         res.next();
         suma =Double.parseDouble(res.getString("sum(valor_venta)"));
         res.close();
         consulta.close();
         conex.desconectar();
       } catch (Exception e) {
         e.printStackTrace();//JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
       }
       return suma;
	}
		
}
