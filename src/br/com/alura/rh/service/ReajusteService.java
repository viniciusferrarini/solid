package br.com.alura.rh.service;

import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ReajusteService {

	private final List<ValidacaoReajuste> validacoes;

	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(v -> v.validar(funcionario, aumento));
		BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);
		funcionario.getDadosPessoais().atualizarSalario(salarioReajustado);
		funcionario.setDataUltimoReajuste(LocalDate.now());
	}

}
