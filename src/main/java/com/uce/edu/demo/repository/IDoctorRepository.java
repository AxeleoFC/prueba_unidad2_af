package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Doctor;

public interface IDoctorRepository {
	
	public void insertar(Doctor d);
	public void eliminar(String cedula);
	public void actualizar(Doctor d);
	public Doctor buscar(String cedula);

}
