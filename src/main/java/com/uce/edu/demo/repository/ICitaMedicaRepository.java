package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.CitaMedicaSencilla;
import com.uce.edu.demo.repository.modelo.Cita_Medica;

public interface ICitaMedicaRepository {
	
	public void insertar(Cita_Medica cm);
	public void eliminar(String numero);
	public void actualizar(Cita_Medica cm);
	public Cita_Medica buscar(String numero);

	public List<CitaMedicaSencilla> reporteCitaMedica(LocalDateTime fechaCita, BigDecimal valorCita);
}
