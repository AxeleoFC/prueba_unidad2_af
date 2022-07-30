package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Paciente;

public interface IPacienteService {
	
	public void insertar(Paciente p);
	public void eliminar(String cedula);
	public void actualizar(Paciente p);
	public Paciente buscar(String cedula);

}
