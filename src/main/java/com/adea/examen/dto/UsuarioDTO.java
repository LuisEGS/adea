package com.adea.examen.dto;

import java.util.Date;

import javax.persistence.Column;

public class UsuarioDTO {
    private String usuarioId;
    private String password; 
    private String nombre;
    private float cliente;
    private String email;
    private Date fechaAlta = new Date();
    private Date fechaBaja;
    private String status = "A";
    private float intentos = 0f;
    private Date fechaRevocado;
    private Date fechaVigencia;
    private Integer NoAcceso;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer area;
    private Date fechaModificacion;
    
    
    
    
	public String getUsuarioId() {
		return usuarioId;
	}




	public void setUsuarioId(String usuario) {
		this.usuarioId = usuario;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public float getCliente() {
		return cliente;
	}




	public void setCliente(float cliente) {
		this.cliente = cliente;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Date getFechaAlta() {
		return fechaAlta;
	}




	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}




	public Date getFechaBaja() {
		return fechaBaja;
	}




	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public float getIntentos() {
		return intentos;
	}




	public void setIntentos(float intentos) {
		this.intentos = intentos;
	}




	public Date getFechaRevocado() {
		return fechaRevocado;
	}




	public void setFechaRevocado(Date fechaRevocado) {
		this.fechaRevocado = fechaRevocado;
	}




	public Date getFechaVigencia() {
		return fechaVigencia;
	}




	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}




	public Integer getNoAcceso() {
		return NoAcceso;
	}




	public void setNoAcceso(Integer noAcceso) {
		NoAcceso = noAcceso;
	}




	public String getApellidoPaterno() {
		return apellidoPaterno;
	}




	public void setApellidoPaterno(String apellidoPaterno) {
		apellidoPaterno = apellidoPaterno;
	}




	public String getApellidoMaterno() {
		return apellidoMaterno;
	}




	public void setApellidoMaterno(String apellidoMaterno) {
		apellidoMaterno = apellidoMaterno;
	}




	public Integer getArea() {
		return area;
	}




	public void setArea(Integer area) {
		this.area = area;
	}




	public Date getFechaModificacion() {
		return fechaModificacion;
	}




	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}




	public UsuarioDTO() {
		super();
	}
    
    
    
}
