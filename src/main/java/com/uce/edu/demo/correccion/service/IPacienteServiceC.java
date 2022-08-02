package com.uce.edu.demo.correccion.service;

import com.uce.edu.demo.correccion.repository.modelo.Paciente;

public interface IPacienteServiceC {
	
	public void insertar(Paciente p);
	public void eliminar(String cedula);
	public void actualizar(Paciente p);
	public Paciente buscar(Integer id);
	public Paciente buscarPorCedula(String cedula);

}
