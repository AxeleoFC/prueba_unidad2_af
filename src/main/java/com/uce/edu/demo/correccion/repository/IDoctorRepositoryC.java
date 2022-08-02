package com.uce.edu.demo.correccion.repository;

import com.uce.edu.demo.correccion.repository.modelo.Doctor;

public interface IDoctorRepositoryC {
	
	public void insertar(Doctor d);
	public void eliminar(String cedula);
	public void actualizar(Doctor d);
	public Doctor buscar(Integer id);
	public Doctor buscarPorCedula(String cedula);

}