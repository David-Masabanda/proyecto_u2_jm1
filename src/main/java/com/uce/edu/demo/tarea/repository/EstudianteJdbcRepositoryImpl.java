package com.uce.edu.demo.tarea.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.to.Estudiante;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Estudiante buscarPorId(int id) {
		return this.jdbcTemplate.queryForObject("select * from estudiante where id=?",
				new Object[] {id},
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

	@Override
	public void insertar(Estudiante e) {
		this.jdbcTemplate.update("insert into estudiante(id, nombre, apellido, carrera, semestre) values(?,?,?,?,?)",
				new Object[] {e.getId(), e.getNombre(), e.getApellido(), e.getCarrera(), e.getSemestre()});
		
	}

	@Override
	public void actualizar(Estudiante e) {
		this.jdbcTemplate.update("update estudiante set nombre=?, apellido=?, carrera=?, semestre=? where id=?",
				new Object[] {e.getNombre(), e.getApellido(), e.getCarrera(), e.getSemestre(), e.getId()});
		
	}

	@Override
	public void eliminar(int id) {
		this.jdbcTemplate.update("delete from estudiante where id=?",
				new Object[] {id});
		
	}

}
