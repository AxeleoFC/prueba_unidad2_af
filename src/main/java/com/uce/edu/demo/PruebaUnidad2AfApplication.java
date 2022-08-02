package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.correccion.repository.modelo.Doctor;
import com.uce.edu.demo.correccion.repository.modelo.Paciente;
import com.uce.edu.demo.correccion.service.IDoctorServiceC;
import com.uce.edu.demo.correccion.service.IGestorCitaMedicaService;
import com.uce.edu.demo.correccion.service.IPacienteServiceC;

@SpringBootApplication
public class PruebaUnidad2AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(PruebaUnidad2AfApplication.class.getName());
	
	@Autowired
	private IPacienteServiceC pacienteSerice;
	@Autowired
	private IDoctorServiceC doctorService;
	@Autowired
	private IGestorCitaMedicaService gestorCitaService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Insertar 2 doctores
		Doctor doc1=new Doctor();
		doc1.setCedula("123654");
		doc1.setNombre("Miguel");
		doc1.setApellido("Velez");
		doc1.setFechaNacimiento(LocalDateTime.of(1995, 06, 12, 22, 45, 10));
		doc1.setNumeroConsultorio("D123");
		doc1.setCodigoSenescyt("123123123");
		doc1.setGenero("M");
		this.doctorService.insertar(doc1);
		
		Doctor doc2=new Doctor();
		doc2.setCedula("136554");
		doc2.setNombre("Jaime");
		doc2.setApellido("Mendoza");
		doc2.setFechaNacimiento(LocalDateTime.of(1985, 04, 10, 12, 15, 16));
		doc2.setNumeroConsultorio("D124");
		doc2.setCodigoSenescyt("123123123");
		doc2.setGenero("M");
		this.doctorService.insertar(doc2);
		LOG.info("Insertar 2 doctores");
		
		//Insertar 2 pacientes
		LOG.info("Agendar una cita");
		Paciente p1=new Paciente();
		p1.setCedula("125634");
		p1.setNombre("Pepe");
		p1.setApellido("Mejia");
		p1.setFechaNacimiento(LocalDateTime.of(1995, 04, 10, 12, 15, 16));
		p1.setCodigoSeguro("1234");
		p1.setEstatura(1.5);
		p1.setPeso(1.5);
		p1.setGenero("Masculino");
		this.pacienteSerice.insertar(p1);
		
		Paciente p2=new Paciente();
		p2.setCedula("125459");
		p2.setNombre("Jose");
		p2.setApellido("Montalvo");
		p2.setFechaNacimiento(LocalDateTime.of(1980, 06, 12, 12, 15, 16));
		p2.setCodigoSeguro("1256");
		p2.setEstatura(1.7);
		p2.setPeso(1.8);
		p2.setGenero("Masculino");
		this.pacienteSerice.insertar(p2);
		LOG.info("Insertar 2 pacientes");
		
		LOG.info("Agendar cita");
		this.gestorCitaService.generarCita("12231", LocalDateTime.now(), new BigDecimal(15.5), "Hospital", "123654", "125459");
		
		LOG.info("Actualizar cita");
		this.gestorCitaService.actualizarCitaMedica("12231", "Covid", "Paracetamol", LocalDateTime.now().plusMonths(1));
		
		LOG.info("Reporte Paciente");
		//List<PaciienteSencillo> reporte= this.pacienteSerice.reporteCitaMedica(LocalDateTime.of(2022, 7, 20, 12, 30), new BigDecimal(14.50));
		//reporte.stream().forEach(PaciienteSencillo -> {LOG.info("Paciente: "+PaciienteSencillo);});
	}

}
