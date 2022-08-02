package com.uce.edu.demo.correccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correccion.repository.IDoctorRepositoryC;
import com.uce.edu.demo.correccion.repository.modelo.Doctor;
@Service
public class DoctorServiceImplC implements IDoctorServiceC{
	
	@Autowired
	private IDoctorRepositoryC doctorRepo;

	@Override
	public void insertar(Doctor d) {
		// TODO Auto-generated method stub
		this.doctorRepo.insertar(d);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.doctorRepo.eliminar(cedula);
	}

	@Override
	public void actualizar(Doctor d) {
		// TODO Auto-generated method stub
		this.doctorRepo.actualizar(d);
	}

	@Override
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscar(id);
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscarPorCedula(cedula);
	}

}
