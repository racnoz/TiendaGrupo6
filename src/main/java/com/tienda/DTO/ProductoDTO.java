package com.tienda.DTO;

public class ProductoDTO {
	private Integer codigoProducto;
	private double ivaCompra;
    private Integer nitProveedor;
    private String nombreProducto;
    private double precioCompra;
    private double precioVenta;
    
	public Integer getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public double getIvaCompra() {
		return ivaCompra;
	}
	public void setIvaCompra(double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}
	public Integer getNitProveedor() {
		return nitProveedor;
	}
	public void setNitProveedor(Integer nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
    
    
}
