package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.modelo.Doctor;
@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Autowired
	private IDoctorRepository doctorRepo;

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
	public Doctor buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscar(cedula);
	}

}
