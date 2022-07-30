package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedicaSencilla;
import com.uce.edu.demo.repository.modelo.Cita_Medica;
@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cita_Medica cm) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cm);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(numero));
	}

	@Override
	public void actualizar(Cita_Medica cm) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cm);
	}

	@Override
	public Cita_Medica buscar(String numero) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("Cita_Medica.buscarPorNumero");
		myQuery.setParameter("datoNumero", numero);
		return (Cita_Medica) myQuery.getSingleResult();
	}

	@Override
	public List<CitaMedicaSencilla> reporteCitaMedica(LocalDateTime fechaCita, BigDecimal valorCita) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedicaSencilla> myQueri = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.CitaMedicaSencilla(cm.numero, cm.fechaCita, cm.valorCita, cm.fechaControl) FROM Cita_Medica cm WHERE cm.fechaCita > :datoFecha AND cm.valorCita > :datoValor",
				CitaMedicaSencilla.class);
		myQueri.setParameter("datoFecha", fechaCita);
		myQueri.setParameter("datoValor", valorCita);
		return myQueri.getResultList();
	}

}
