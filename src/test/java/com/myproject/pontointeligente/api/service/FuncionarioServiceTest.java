package com.myproject.pontointeligente.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.pontointeligente.api.entities.Funcionario;
import com.myproject.pontointeligente.api.repository.FuncionarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {

	@MockBean
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private FuncionarioService funcionarioService;

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
		BDDMockito.given(funcionarioRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Funcionario()));
		BDDMockito.given(funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
	}

	@Test
	public void testPersisitr() {
		Funcionario funcionario = funcionarioService.persistir(new Funcionario());
		assertNotNull(funcionario);
	}

	@Test
	public void testBuscarFuncionarioPorId() {
		Optional<Funcionario> funcionario = funcionarioService.buscarPorId(1L);
		assertTrue(funcionario.isPresent());
	}

	@Test
	public void testBuscarFuncionarioPorEmail() {
		Optional<Funcionario> funcionario = funcionarioService.buscarPorEmail("test@email.com");
		assertTrue(funcionario.isPresent());
	}

	@Test
	public void testBuscarFuncionarioPorCpf() {
		Optional<Funcionario> funcionario = funcionarioService.buscarPorCpf("12345678986");
		assertTrue(funcionario.isPresent());
	}
}
