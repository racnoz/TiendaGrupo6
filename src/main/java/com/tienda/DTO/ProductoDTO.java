package com.tienda.DTO;

public class ProductoDTO {
	int codigoProducto;
	float ivaCompra;
	long nitProveedor;
	String nombreProducto;
	float precioCompra;
	float precioVenta;
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public float getIvaCompra() {
		return ivaCompra;
	}
	public void setIvaCompra(float ivaCompra) {
		this.ivaCompra = ivaCompra;
	}
	public long getNitProveedor() {
		return nitProveedor;
	}
	public void setNitProveedor(long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	
}
