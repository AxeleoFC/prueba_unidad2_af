package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Doctor;

public interface IDoctorService {
	
	public void insertar(Doctor d);
	public void eliminar(String cedula);
	public void actualizar(Doctor d);
	public Doctor buscar(String cedula);

}
