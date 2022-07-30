package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Paciente;
@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {
	
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
		this.entityManager.remove(this.buscar(cedula));
	}

	@Override
	public void actualizar(Paciente p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	public Paciente buscar(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("Paciente.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Paciente) myQuery.getSingleResult();
	}

}
