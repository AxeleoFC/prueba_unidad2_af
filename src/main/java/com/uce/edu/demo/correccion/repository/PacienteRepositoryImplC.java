package com.uce.edu.demo.correccion.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.correccion.repository.modelo.Paciente;
import com.uce.edu.demo.correccion.repository.modelo.PacienteSencillo;
import com.uce.edu.demo.repository.modelo.CitaMedicaSencilla;

@Repository
@Transactional
public class PacienteRepositoryImplC implements IPacienteRepositoryC {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorCedula(cedula));
	}

	@Override
	public void actualizar(Paciente p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("Paciente.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Paciente) myQuery.getSingleResult();
	}

	@Override
	public List<PacienteSencillo> reportePacient(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteSencillo> myQueri = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.correccion.repository.modelo.PacienteSencillo(p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento > :datoFecha AND p.genero = :datoGenero",
				PacienteSencillo.class);
		myQueri.setParameter("datoFecha", fechaNacimiento);
		myQueri.setParameter("datoGenero", genero);
		return myQueri.getResultList();
	}

}
