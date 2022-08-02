package com.uce.edu.demo.correccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correccion.repository.IPacienteRepositoryC;
import com.uce.edu.demo.correccion.repository.modelo.Paciente;
@Service
public class PacienteServiceImplC implements IPacienteServiceC{

	@Autowired
	private IPacienteRepositoryC pacienteRepo;
	
	@Override
	public void insertar(Paciente p) {
		// TODO Auto-generated method stub
		this.pacienteRepo.insertar(p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.pacienteRepo.eliminar(cedula);
	}

	@Override
	public void actualizar(Paciente p) {
		// TODO Auto-generated method stub
		this.pacienteRepo.actualizar(p);
	}

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscar(id);
	}


	@Override
	public Paciente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscarPorCedula(cedula);
	}

}
