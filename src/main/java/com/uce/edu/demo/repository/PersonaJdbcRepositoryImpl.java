package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.Persona;

@Repository
public class PersonaJdbcRepositoryImpl implements IPersonaJdbcRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Persona buscarPorId(int id) {
		return this.jdbcTemplate.queryForObject("select * from persona where id=?", 
					new Object[] {id}, 
					new BeanPropertyRowMapper<Persona>(Persona.class));
		
	}

	@Override
	public void insertar(Persona p) {
		this.jdbcTemplate.update("insert into persona(id, nombre, apellido) values(?,?,?)",
				new Object[] {p.getId(),p.getNombre(),p.getApellido()});
		
	}

	@Override
	public void actualizar(Persona p) {
		this.jdbcTemplate.update("update persona set nombre=?, apellido=? where id=?",
				new Object[] {p.getNombre(),p.getApellido(),p.getId()});
	}

	@Override
	public void eliminar(int id) {
		this.jdbcTemplate.update("delete from persona where id=?",
				new Object[] {id});
	}

}
