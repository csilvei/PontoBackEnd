package com.app.ponto.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.ponto.models.Banco;

public interface BancoRepository extends CrudRepository<Banco, String> {

}
