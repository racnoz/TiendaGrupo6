package com.tienda.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
}
