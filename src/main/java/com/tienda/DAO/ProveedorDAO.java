package com.tienda.DAO;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tienda.DTO.ProveedorDTO;
import com.tienda.DTO.ProveedorDTO;

public class ProveedorDAO {
	PreparedStatement preparedStatement;
	public void registrarProveedor(ProveedorDTO proveedor) {
        Conexion conex = new Conexion();
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("INSERT INTO proveedores VALUES ('"+proveedor.getNitProveedor()+"', '"
                     +proveedor.getCiudadProveedor()+"', '"+proveedor.getDireccionProveedor()+"','"+proveedor.getNombreProveedor()+"','"+proveedor.getTelefonoProveedor()+"')");
            JOptionPane.showMessageDialog(null, "Se ha registrado el proveedor exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);;
            st.close();
            conex.desconectar();
        }catch(Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puedo agregar al proveedor");
        }
    }
	public ArrayList<ProveedorDTO> consultarProveedor(int nit){
        ArrayList<ProveedorDTO> miCliente = new ArrayList<ProveedorDTO>();
        Conexion conex = new Conexion();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE nitproveedor = ?");
            consulta.setInt(1, nit);
            ResultSet res = consulta.executeQuery();
            if(res.next()) {
                ProveedorDTO proveedor = new ProveedorDTO();
                proveedor.setNitProveedor(Integer.parseInt(res.getString("nitproveedor")));
                proveedor.setCiudadProveedor(res.getString("ciudad_proveedor"));
                proveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
                proveedor.setNombreProveedor(res.getString("nombre_proveedor"));
                proveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));
                miCliente.add(proveedor);
            }
            res.close();
            consulta.close();
            conex.desconectar();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar al proveedor "+e);
        }
        return miCliente;
    }
	
	public ArrayList<ProveedorDTO> listaDeProveedores() {
        ArrayList< ProveedorDTO> miCliente = new ArrayList< ProveedorDTO>();
        Conexion conex= new Conexion();
          
        try {
         PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
         ResultSet res = consulta.executeQuery();
         while(res.next()){
             ProveedorDTO proveedor= new ProveedorDTO();
             proveedor.setNitProveedor(Integer.parseInt(res.getString("nitproveedor")));
             proveedor.setCiudadProveedor(res.getString("ciudad_proveedor"));
             proveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
             proveedor.setNombreProveedor(res.getString("nombre_proveedor"));
             proveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));
        
          miCliente.add(proveedor);
                }
                res.close();
                consulta.close();
                conex.desconectar();
         
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
        }
        return miCliente;
    }
	
	public void eliminarProveedor(int nit) {
        Conexion conex= new Conexion();
        try {
            String query = "DELETE FROM proveedores WHERE nitproveedor = ?";
            preparedStatement = conex.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, nit);
            preparedStatement.executeUpdate();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void editarProveedor(ProveedorDTO proveedor) {
		Conexion conex = new Conexion();
		try {
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate("UPDATE proveedores SET ciudad_proveedor = '"+proveedor.getCiudadProveedor()+"', direccion_proveedor = '"+proveedor.getDireccionProveedor()+"', nombre_proveedor='"+proveedor.getNombreProveedor()+"', telefono_proveedor='"+proveedor.getTelefonoProveedor()+"' WHERE nitproveedor="+proveedor.getNitProveedor());
			st.close();
			conex.desconectar();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 
	
}
