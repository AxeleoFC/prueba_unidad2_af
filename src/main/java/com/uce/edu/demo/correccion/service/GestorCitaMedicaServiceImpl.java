package com.uce.edu.demo.correccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correccion.repository.ICitaMedicaRepositoryC;
import com.uce.edu.demo.correccion.repository.IDoctorRepositoryC;
import com.uce.edu.demo.correccion.repository.IPacienteRepositoryC;
import com.uce.edu.demo.correccion.repository.modelo.CitaMedica;
import com.uce.edu.demo.correccion.repository.modelo.Doctor;
import com.uce.edu.demo.correccion.repository.modelo.Paciente;
@Service
public class GestorCitaMedicaServiceImpl implements IGestorCitaMedicaService{
	
	@Autowired
	private IDoctorRepositoryC doctorRepo;
	@Autowired
	private IPacienteRepositoryC pacienteRepo;
	@Autowired
	private ICitaMedicaRepositoryC citaMedicaRepo;

	@Override
	public void generarCita(String numero, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Paciente p=this.pacienteRepo.buscarPorCedula(cedulaPaciente);
		Doctor d=this.doctorRepo.buscarPorCedula(cedulaDoctor);
		
		CitaMedica citaMedica=new CitaMedica();
		citaMedica.setNumero(numero);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setValorCita(valorCita);
		citaMedica.setLugarCita(lugarCita);
		citaMedica.setPaciente(p);
		citaMedica.setDoctor(d);
		
		this.citaMedicaRepo.insertar(citaMedica);
		
	}

	@Override
	public void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		CitaMedica citaActualizada=this.citaMedicaRepo.buscarPorNumero(numero);
		citaActualizada.setDiagnostico(diagnostico);
		citaActualizada.setReceta(receta);
		citaActualizada.setFechaProximaCita(fechaProximaCita);
		this.citaMedicaRepo.actualizar(citaActualizada);
		
	}
	

}
