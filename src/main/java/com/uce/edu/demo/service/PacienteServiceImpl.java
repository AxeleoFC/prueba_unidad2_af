package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.Paciente;
@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepository pacienteRepo;
	
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
	public Paciente buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscar(cedula);
	}

}
