package com.app.ponto.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.ponto.models.Empregado;

public interface EmpregadoRepository extends CrudRepository<Empregado, String> {

}
