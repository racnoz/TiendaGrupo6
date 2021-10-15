package com.tienda.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tienda.DTO.DetalleVentaDTO;

public class DetalleVentaDAO {
	PreparedStatement preparedStatement;
	public String registrarDetalleVenta(DetalleVentaDTO detalleVenta) {
        Conexion conex = new Conexion();
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("INSERT INTO detalle_ventas VALUES ('"+detalleVenta.getCodigoDetalleVenta()+"', '"
                     +detalleVenta.getCantidadProducto()+"', '"+detalleVenta.getCodigoProducto()+"','"+detalleVenta.getCodigoVenta()+"','"+detalleVenta.getValorTotal()+"','"+detalleVenta.getValorVenta()+"', '"+detalleVenta.getValorIva()+"')");
            st.close();
            conex.desconectar();
            return "Se ha registrado exitosamente el Detalle Venta";
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo agregar el Detalle Venta";
        }
    }
	public ArrayList<DetalleVentaDTO> consultarDetalleVenta(int codigo){
        ArrayList<DetalleVentaDTO> miDetalleVenta = new ArrayList<DetalleVentaDTO>();
        Conexion conex = new Conexion();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM detalle_ventas WHERE codigo_detalle_venta = ?");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            if(res.next()) {
            	DetalleVentaDTO detalleVenta = new DetalleVentaDTO();
                detalleVenta.setCodigoDetalleVenta(Integer.parseInt(res.getString("codigo_detalle_venta")));
                detalleVenta.setCantidadProducto(Integer.parseInt(res.getString("cantidad_producto")));
                detalleVenta.setCodigoProducto(Long.parseLong(res.getString("codigo_producto")));
                detalleVenta.setCodigoVenta(Long.parseLong(res.getString("codigo_venta")));
                detalleVenta.setValorTotal(Double.parseDouble(res.getString("valor_total")));
                detalleVenta.setValorVenta(Double.parseDouble(res.getString("valor_venta")));
                detalleVenta.setValorIva(Double.parseDouble(res.getString("valoriva")));
                miDetalleVenta.add(detalleVenta);
            }
            res.close();
            consulta.close();
            conex.desconectar();
        }catch(Exception e) {
             System.out.print("no se pudo consultar el Detalle Venta ");
        }
        return miDetalleVenta;
    }
	
	public ArrayList<DetalleVentaDTO> listaDeDetalleVentas() {
        ArrayList< DetalleVentaDTO> miDetalleVenta = new ArrayList< DetalleVentaDTO>();
        Conexion conex= new Conexion();
          
        try {
         PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM detalle_ventas");
         ResultSet res = consulta.executeQuery();
         while(res.next()){
        	 DetalleVentaDTO detalleVenta = new DetalleVentaDTO();
             detalleVenta.setCodigoDetalleVenta(Integer.parseInt(res.getString("codigo_detalle_venta")));
             detalleVenta.setCantidadProducto(Integer.parseInt(res.getString("cantidad_producto")));
             detalleVenta.setCodigoProducto(Long.parseLong(res.getString("codigo_producto")));
             detalleVenta.setCodigoVenta(Long.parseLong(res.getString("codigo_venta")));
             detalleVenta.setValorTotal(Double.parseDouble(res.getString("valor_total")));
             detalleVenta.setValorVenta(Double.parseDouble(res.getString("valor_venta")));
             detalleVenta.setValorIva(Double.parseDouble(res.getString("valoriva")));
             miDetalleVenta.add(detalleVenta);
        }
        res.close();
        consulta.close();
        conex.desconectar();
         
       } catch (Exception e) {
         //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
       }
        return miDetalleVenta;
    }
	
	public String eliminarDetalleVenta(int codigo) {
        Conexion conex= new Conexion();
        try {
            String query = "DELETE FROM detalle_ventas WHERE codigo_detalle_venta = ?";
            preparedStatement = conex.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            return "Se ha eliminado el Detalle Venta";
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo eliminar el Detalle Venta";
        }
    }
	
	public void editarDetalleVenta(DetalleVentaDTO detalleVenta) {
		Conexion conex = new Conexion();
		try {
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate("UPDATE detalle_ventas SET cantidad_producto = '"+detalleVenta.getCantidadProducto()+"', codigo_producto = '"+detalleVenta.getCodigoProducto()+"', codigo_venta='"+detalleVenta.getCodigoVenta()+"', valor_total='"+detalleVenta.getValorTotal()+"', valor_venta = '"+detalleVenta.getValorVenta()+"', valoriva = '"+detalleVenta.getValorIva()+"' WHERE codigo_detalle_venta="+detalleVenta.getCodigoDetalleVenta());
			st.close();
			conex.desconectar();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 
}
