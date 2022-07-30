package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Paciente;

public interface IPacienteRepository {
	
	public void insertar(Paciente p);
	public void eliminar(String cedula);
	public void actualizar(Paciente p);
	public Paciente buscar(String cedula);

}
