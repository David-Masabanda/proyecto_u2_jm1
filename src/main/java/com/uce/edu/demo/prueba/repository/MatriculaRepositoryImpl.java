package com.uce.edu.demo.prueba.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.repository.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@Override
	public void create(Matricula m) {
		System.out.println("Se ha creado una nueva matricula en la base: "+ m);
	}

}
