package com.app.ponto.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.ponto.models.Lancamento;

public interface LancamentoRepository extends CrudRepository<Lancamento, String> {

}
