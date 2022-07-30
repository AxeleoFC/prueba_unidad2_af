package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.CitaMedicaSencilla;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.ICitaMedicaService;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(PruebaUnidad2AfApplication.class.getName());
	
	@Autowired
	private IPacienteService pacienteSerice;
	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private ICitaMedicaService citaMService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Insertar 2 doctores
		Doctor d1=new Doctor();
		d1.setCedula("123654");
		d1.setNombre("Miguel");
		d1.setApellido("Velez");
		d1.setFechaNacimiento(LocalDateTime.of(1995, 06, 12, 22, 45, 10));
		d1.setNumeroConsultorio("D123");
		d1.setTitulo("Cirujano Plastico");
		d1.setSalario(new BigDecimal(800));
		this.doctorService.insertar(d1);
		
		Doctor d2=new Doctor();
		d2.setCedula("136554");
		d2.setNombre("Jaime");
		d2.setApellido("Mendoza");
		d2.setFechaNacimiento(LocalDateTime.of(1985, 04, 10, 12, 15, 16));
		d2.setNumeroConsultorio("D124");
		d2.setTitulo("Medicina");
		d2.setSalario(new BigDecimal(1200));
		this.doctorService.insertar(d2);
		LOG.info("Insertar 2 doctores");
		
		//Insertar 2 pacientes
		LOG.info("Agendar una cita");
		Paciente p1=new Paciente();
		p1.setCedula("125634");
		p1.setNombre("Pepe");
		p1.setApellido("Mejia");
		p1.setFechaNacimiento(LocalDateTime.of(1995, 04, 10, 12, 15, 16));
		p1.setCodIess("1234");
		p1.setEstatura(1.5);
		p1.setPeso(1.5);
		p1.setGenero("Masculino");
		this.pacienteSerice.insertar(p1);
		
		Paciente p2=new Paciente();
		p2.setCedula("125459");
		p2.setNombre("Jose");
		p2.setApellido("Montalvo");
		p2.setFechaNacimiento(LocalDateTime.of(1980, 06, 12, 12, 15, 16));
		p2.setCodIess("1256");
		p2.setEstatura(1.7);
		p2.setPeso(1.8);
		p2.setGenero("Masculino");
		this.pacienteSerice.insertar(p2);
		LOG.info("Insertar 2 pacientes");
		
		LOG.info("Agendar una cita");
		this.citaMService.agendarCita("1", LocalDateTime.of(2022, 8, 20, 12, 30), new BigDecimal(15.50), "Hospital del dia", "136554", "125459");
		
		LOG.info("Actualizar cita");
		this.citaMService.actualizarCita("1", "Dolor de espalda", "Tomar ibuprofeno cada 8 horas", LocalDateTime.of(2022, 9, 20, 12, 30));
		
		LOG.info("Reporte cita");
		List<CitaMedicaSencilla> reporte= this.citaMService.reporteCitaMedica(LocalDateTime.of(2022, 7, 20, 12, 30), new BigDecimal(14.50));
		reporte.stream().forEach(CitaMedicaSencilla -> {LOG.info("Cita: "+CitaMedicaSencilla);});
	}

}
