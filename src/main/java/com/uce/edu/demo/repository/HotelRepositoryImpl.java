package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void insertar(Hotel h) {
		this.entityManager.persist(h);
	}

}
