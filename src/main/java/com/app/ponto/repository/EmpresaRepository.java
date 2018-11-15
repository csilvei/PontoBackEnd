package com.app.ponto.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.ponto.models.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, String> {

}
