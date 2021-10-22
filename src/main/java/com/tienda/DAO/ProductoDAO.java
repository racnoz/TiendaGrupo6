package com.tienda.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tienda.DTO.ProductoDTO;

public class ProductoDAO {
	PreparedStatement preparedStatement;
	public String registrarProducto(ProductoDTO producto) {
        Conexion conex = new Conexion();
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("INSERT INTO productos VALUES ('"+producto.getCodigoProducto()+"', '"
                     +producto.getIvaCompra()+"', '"+producto.getNitProveedor()+"','"+producto.getNombreProducto()+"','"+producto.getPrecioCompra()+"', '"+producto.getPrecioVenta()+"')");
            st.close();
            conex.desconectar();
            return "Se ha registrado exitosamente el producto";
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo agregar el producto";
        }
    }
	public ArrayList<ProductoDTO> consultarProducto(int codigo){
        ArrayList<ProductoDTO> miProducto = new ArrayList<ProductoDTO>();
        Conexion conex = new Conexion();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos WHERE codigo_producto = ?");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            if(res.next()) {
                ProductoDTO producto = new ProductoDTO();
                producto.setCodigoProducto(Integer.parseInt(res.getString("codigo_producto")));
                producto.setIvaCompra(Float.parseFloat(res.getString("ivacompra")));
                producto.setNitProveedor(Integer.parseInt(res.getString("nitproveedor")));
                producto.setNombreProducto(res.getString("nombre_producto"));
                producto.setPrecioCompra(Float.parseFloat(res.getString("precio_compra")));
                producto.setPrecioVenta(Float.parseFloat(res.getString("precio_venta")));
                miProducto.add(producto);
            }
            res.close();
            consulta.close();
            conex.desconectar();
        }catch(Exception e) {
            e.printStackTrace(); 
        	System.out.print("no se pudo consultar el producto");
        }
        return miProducto;
    }
	
	public ArrayList<ProductoDTO> listaDeProductos() {
        ArrayList< ProductoDTO> miProducto = new ArrayList< ProductoDTO>();
        Conexion conex= new Conexion();
        try {
         PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos");
         ResultSet res = consulta.executeQuery();
         while(res.next()){
        	 ProductoDTO producto = new ProductoDTO();
             producto.setCodigoProducto(Integer.parseInt(res.getString("codigo_producto")));
             producto.setIvaCompra(Float.parseFloat(res.getString("ivacompra")));
             producto.setNitProveedor(Integer.parseInt(res.getString("nitproveedor")));
             producto.setNombreProducto(res.getString("nombre_producto"));
             producto.setPrecioCompra(Float.parseFloat(res.getString("precio_compra")));
             producto.setPrecioVenta(Float.parseFloat(res.getString("precio_venta")));
             miProducto.add(producto);
        }
        res.close();
        consulta.close();
        conex.desconectar();
         
        } catch (Exception e) {
         //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
        	e.printStackTrace();
        }
        return miProducto;
    }
	public String eliminarProducto(int codigo) {
        Conexion conex= new Conexion();
        try {
            String query = "DELETE FROM productos WHERE codigo_producto = ?";
            preparedStatement = conex.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            return "Se ha eliminado el producto";
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo eliminar el producto";
        }
    }
	
	public String editarProducto(ProductoDTO producto) {
		Conexion conex = new Conexion();
		try {
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate("UPDATE productos SET ivacompra = '"+producto.getIvaCompra()+"', nitproveedor = '"+producto.getNitProveedor()+"', nombre_producto='"+producto.getNombreProducto()+"', precio_compra='"+producto.getPrecioCompra()+"', precio_venta='"+producto.getPrecioVenta()+"' WHERE codigo_producto="+producto.getCodigoProducto());
			st.close();
			conex.desconectar();
			 return "Se ha editado exitosamente";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "no se pudo completar la operación!";
		}
	} 
}
