package com.tienda.DTO;

public class VentaDTO {
	private int codigoVenta;
	private long cedulaCliente;
	private long cedulaUsuario;
	private double ivaVenta;
	private double totalVenta;
	private double valorVenta;
	
	public int getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public long getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public long getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(long cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public double getIvaVenta() {
		return ivaVenta;
	}
	public void setIvaVenta(double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}
	public double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
	public double getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}
}
