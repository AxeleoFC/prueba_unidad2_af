package com.uce.edu.demo.correccion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.correccion.repository.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepositoryImplC implements IDoctorRepositoryC {
	
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
		this.entityManager.remove(this.buscarPorCedula(cedula));
	}

	@Override
	public void actualizar(Doctor d) {
		// TODO Auto-generated method stub
		this.entityManager.merge(d);
	}

	@Override
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("Doctor.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Doctor) myQuery.getSingleResult();
	}

}
