package com.pruebapractica.api.exceptions;

import java.util.Date;

public class RespuestaException {

	private Date fecha;
	private String mensaje;
	private String detalles;

	public RespuestaException(Date fecha, String mensaje, String detalles) {
		super();
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

}
