package com.tienda.DAO;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tienda.DTO.UsuarioDTO;

public class UsuarioDAO {
	PreparedStatement preparedStatement;
	public String registrarUsuario(UsuarioDTO usuario) {
        Conexion conex = new Conexion();
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("INSERT INTO usuarios VALUES ('"+usuario.getCedulaUsuario()+"', '"
                     +usuario.getEmailUsuario()+"', '"+usuario.getNombreUsuario()+"','"+usuario.getPassword()+"','"+usuario.getUsuario()+"')");
            st.close();
            conex.desconectar();
            return "Se ha registrado exitosamente el usuario";
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo agregar el usuario";
        }
    }
	public ArrayList<UsuarioDTO> consultarUsuario(int documento){
        ArrayList<UsuarioDTO> miUsuario = new ArrayList<UsuarioDTO>();
        Conexion conex = new Conexion();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario = ?");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();
            if(res.next()) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setCedulaUsuario(Integer.parseInt(res.getString("cedula_usuario")));
                usuario.setEmailUsuario(res.getString("email_usuario"));
                usuario.setNombreUsuario(res.getString("nombre_usuario"));
                usuario.setPassword(res.getString("password"));
                usuario.setUsuario(res.getString("usuario"));
                miUsuario.add(usuario);
            }
            res.close();
            consulta.close();
            conex.desconectar();
        }catch(Exception e) {
             System.out.print("no se pudo consultar al usuario ");
        }
        return miUsuario;
    }
	
	public ArrayList<UsuarioDTO> listaDeUsuarios() {
        ArrayList< UsuarioDTO> miCliente = new ArrayList< UsuarioDTO>();
        Conexion conex= new Conexion();
          
        try {
         PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
         ResultSet res = consulta.executeQuery();
         while(res.next()){
             UsuarioDTO usuario= new UsuarioDTO();
                usuario.setCedulaUsuario(Integer.parseInt(res.getString("cedula_usuario")));
                usuario.setEmailUsuario(res.getString("email_usuario"));
                usuario.setNombreUsuario(res.getString("nombre_usuario"));
                usuario.setPassword(res.getString("password"));
                usuario.setUsuario(res.getString("usuario"));
        
          miCliente.add(usuario);
                }
                res.close();
                consulta.close();
                conex.desconectar();
         
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
        }
        return miCliente;
    }
	
	public String eliminarUsuario(int cedula) {
        Conexion conex= new Conexion();
        try {
            String query = "DELETE FROM usuarios WHERE cedula_usuario = ?";
            preparedStatement = conex.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, cedula);
            preparedStatement.executeUpdate();
            
            return "Se ha eliminado el usuario";
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo eliminar el usuario";
        }
    }
	
	public long comprobarUsuarioLong(String usuario, String pass) {
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios WHERE usuario = ? and password = ?");
			consulta.setString(1, usuario);
			consulta.setString(2, pass);
			ResultSet res = consulta.executeQuery();
			if(res.next()) {
				return Long.parseLong(res.getString("cedula_usuario"));
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "No se pudo agregar al usuario"+e.getMessage());
		}
		return -1;
	}
	
	public String editarUsuario(UsuarioDTO usuario) {
		Conexion conex = new Conexion();
		try {
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate("UPDATE usuarios SET email_usuario = '"+usuario.getEmailUsuario()+"', nombre_usuario = '"+usuario.getNombreUsuario()+"', password='"+usuario.getPassword()+"', usuario='"+usuario.getUsuario()+"' WHERE cedula_usuario="+usuario.getCedulaUsuario());
			st.close();
			conex.desconectar();
			 return "Se ha editado exitosamente";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			 return "no se pudo completar la operación!";
		}
	} 
	
}
