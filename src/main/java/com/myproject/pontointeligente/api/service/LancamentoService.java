package com.myproject.pontointeligente.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.myproject.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {

	/**
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return
	 */
	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<Lancamento> buscaPorId(Long id);

	/**
	 * 
	 * @param lancamento
	 * @return
	 */
	Lancamento persistir(Lancamento lancamento);

	/**
	 * 
	 * @param id
	 */
	void remover(Long id);
}
