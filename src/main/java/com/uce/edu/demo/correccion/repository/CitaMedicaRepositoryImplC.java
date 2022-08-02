package com.uce.edu.demo.correccion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.correccion.repository.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepositoryImplC implements ICitaMedicaRepositoryC {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica cm) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cm);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorNumero(numero));
	}

	@Override
	public void actualizar(CitaMedica cm) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cm);
	}

	@Override
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("CitaMedica.buscarPorNumero");
		myQuery.setParameter("datoNumero", numero);
		return (CitaMedica) myQuery.getSingleResult();
	}


}
