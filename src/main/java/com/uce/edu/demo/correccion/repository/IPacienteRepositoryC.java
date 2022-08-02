package com.uce.edu.demo.correccion.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.correccion.repository.modelo.Paciente;
import com.uce.edu.demo.correccion.repository.modelo.PacienteSencillo;

public interface IPacienteRepositoryC {
	
	public void insertar(Paciente p);
	public void eliminar(String cedula);
	public void actualizar(Paciente p);
	public Paciente buscar(Integer id);
	public Paciente buscarPorCedula(String cedula);
	
	public List<PacienteSencillo> reportePacient(LocalDateTime fechaNacimiento, String genero);

}
