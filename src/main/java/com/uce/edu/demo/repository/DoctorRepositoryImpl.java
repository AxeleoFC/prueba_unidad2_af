package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;
@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Doctor d) {
		// TODO Auto-generated method stub
		this.entityManager.persist(d);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(cedula));
	}

	@Override
	public void actualizar(Doctor d) {
		// TODO Auto-generated method stub
		this.entityManager.merge(d);
	}

	@Override
	public Doctor buscar(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("Doctor.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Doctor) myQuery.getSingleResult();
	}

}
