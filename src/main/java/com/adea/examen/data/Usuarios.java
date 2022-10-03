package com.adea.examen.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "Usuario")
@Table(name = "USUARIO")
public class Usuarios {
    @Id
	@Column(name="LOGIN", length = 20, nullable = false)
    private String usuario;
    
    @Column(name="PASSWORD", length = 30, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    private String password; 
    
    @Column(name="NOMBRE", length = 50, nullable = false) 
    private String nombre;
    
    @Column(name="CLIENTE", nullable = false)
    private float cliente;
    
    @Column(name="EMAIL", length = 50)
    private String email;
    
    @Column(name="FECHAALTA", nullable = false)
    private Date fechaAlta = new Date();
    
    @Column(name="FECHABAJA")
    private Date fechaBaja;
    
    @Column(name="STATUS", length = 1, nullable = false)
    private String status = "A";
    
    @Column(name="INTENTOS", nullable = false)
    private float intentos = 0f;
    
    @Column(name="FECHAREVOCADO")
    private Date fechaRevocado;
    
    @Column(name="FECHA_VIGENCIA")
    private Date fechaVigencia;
    
    @Column(name="NO_ACCESO")
    private Integer NoAcceso;
    
    @Column(name="APELLIDO_PATERNO", length = 50)
    private String ApellidoPaterno;
    
    @Column(name="APELLIDO_MATERNO", length = 50)
    private String ApellidoMaterno;
    
    @Column(name="AREA")
    private Integer area;
    
    @Column(name="FECHAMODIFICACION", nullable = false)
    private Date fechaModificacion;

	public String getUsuarioId() {
		return usuario;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuario = usuarioId;
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
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
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

	public Usuarios() {
		super();
	}
    
    

    
}
