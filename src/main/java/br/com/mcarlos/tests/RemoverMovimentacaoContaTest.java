package br.com.mcarlos.tests;

import static br.com.mcarlos.core.Propriedades.NOME_CONTA_ALTERADA;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.mcarlos.core.BaseTest;
import br.com.mcarlos.pages.ContasPage;
import br.com.mcarlos.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();
	
	@Test
	public void testeExcluirContaComMovimentacao() {
		 menuPage.acessarTelaListarConta();
		 
		 contasPage.clicarExcluirConta(NOME_CONTA_ALTERADA);
		 
		 assertEquals("Conta em uso na movimentações", contasPage.getMensagemErro());
	}
}
