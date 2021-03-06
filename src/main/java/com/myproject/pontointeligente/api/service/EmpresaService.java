package com.myproject.pontointeligente.api.service;

import java.util.Optional;

import com.myproject.pontointeligente.api.entities.Empresa;

public interface EmpresaService {

	/**
	 * Retorna uma empresa dado um CNPJ
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	Optional<Empresa> buscarPorCnpj(String cnpj);

	/**
	 * Cadastra uma nova empresa no banco de dados
	 * @param empresa
	 * @return Empresa
	 */
	Empresa persistir(Empresa empresa);
}
