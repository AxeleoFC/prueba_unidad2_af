package com.uce.edu.demo.correccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public interface IGestorCitaMedicaService {
	
	public void generarCita(String numero, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);

	public void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaProximaCita);
}
