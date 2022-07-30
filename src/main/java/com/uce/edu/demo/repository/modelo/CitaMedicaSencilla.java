package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaMedicaSencilla implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private LocalDateTime fechaCita;
	private BigDecimal valorCita;
	private LocalDateTime fechaControl;
	
	public CitaMedicaSencilla() {
		// TODO Auto-generated constructor stub
	}

	public CitaMedicaSencilla(String numero, LocalDateTime fechaCita, BigDecimal valorCita,
			LocalDateTime fechaControl) {
		super();
		this.numero = numero;
		this.fechaCita = fechaCita;
		this.valorCita = valorCita;
		this.fechaControl = fechaControl;
	}

	@Override
	public String toString() {
		return "CitaMedicaSencilla [numero=" + numero + ", fechaCita=" + fechaCita + ", valorCita=" + valorCita
				+ ", fechaControl=" + fechaControl + "]";
	}

	//SEt y GET
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

}
