package br.com.mcarlos.tests;

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
		 
		 contasPage.clicarExcluirConta("Conta com movimentacao");
		 
		 assertEquals("Conta em uso na movimenta��es", contasPage.getMensagemErro());
	}
}
