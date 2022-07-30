package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.CitaMedicaSencilla;

public interface ICitaMedicaService {
	
	public void agendarCita(String numero, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita, String cedulaDoctor, String cedulaPaciente);

	public void actualizarCita(String numero, String diagnostico, String receta, LocalDateTime fechaControl);
	
	public List<CitaMedicaSencilla> reporteCitaMedica(LocalDateTime fechaCita, BigDecimal valorCita);
}
