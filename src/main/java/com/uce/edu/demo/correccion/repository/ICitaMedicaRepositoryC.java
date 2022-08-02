package com.uce.edu.demo.correccion.repository;

import com.uce.edu.demo.correccion.repository.modelo.CitaMedica;

public interface ICitaMedicaRepositoryC {
	
	public void insertar(CitaMedica cm);
	public void eliminar(String numero);
	public void actualizar(CitaMedica cm);
	public CitaMedica buscar(Integer id);
	public CitaMedica buscarPorNumero(String numero);

}
