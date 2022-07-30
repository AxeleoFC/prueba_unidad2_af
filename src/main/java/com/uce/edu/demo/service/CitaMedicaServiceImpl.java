package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedicaSencilla;
import com.uce.edu.demo.repository.modelo.Cita_Medica;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{
	
	@Autowired
	private IDoctorRepository doctorRepo;
	@Autowired
	private IPacienteRepository pacienteRepo;
	@Autowired
	private ICitaMedicaRepository citaMedicaRepo;

	@Override
	public void agendarCita(String numero, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Paciente p=this.pacienteRepo.buscar(cedulaPaciente);
		Doctor d=this.doctorRepo.buscar(cedulaDoctor);
		
		Cita_Medica citaMedica=new Cita_Medica();
		citaMedica.setNumero(numero);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setValorCita(valorCita);
		citaMedica.setLugarCita(lugarCita);
		citaMedica.setPaciente(p);
		citaMedica.setDoctor(d);
		
		this.citaMedicaRepo.insertar(citaMedica);
		
	}

	@Override
	public void actualizarCita(String numero, String diagnostico, String receta, LocalDateTime fechaControl) {
		// TODO Auto-generated method stub
		Cita_Medica citaActualizada=this.citaMedicaRepo.buscar(numero);
		citaActualizada.setDiagnostico(diagnostico);
		citaActualizada.setReceta(receta);
		citaActualizada.setFechaControl(fechaControl);
		this.citaMedicaRepo.actualizar(citaActualizada);
		
	}

	@Override
	public List<CitaMedicaSencilla> reporteCitaMedica(LocalDateTime fechaCita, BigDecimal valorCita) {
		// TODO Auto-generated method stub
		List<CitaMedicaSencilla> reporte=this.citaMedicaRepo.reporteCitaMedica(fechaCita, valorCita);
		return reporte;
	}

	

}
