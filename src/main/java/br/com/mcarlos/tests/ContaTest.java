package br.com.mcarlos.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.mcarlos.core.BaseTest;
import br.com.mcarlos.pages.ContasPage;
import br.com.mcarlos.pages.MenuPage;

public class ContaTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();

	@Test
	public void testeInserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta Teste");
		contasPage.salvar();
		
		
		assertEquals("Conta adicionada com sucesso!", contasPage.getMensagemSucesso());
	}
	
	@Test
	public void testeAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		
		contasPage.clicarAlterarConta("Conta Teste");
		contasPage.setNome("Conta Teste Alterada");
		contasPage.salvar();
		
		assertEquals("Conta alterada com sucesso!", contasPage.getMensagemSucesso());
	}
	
	@Test
	public void testeInserirContasIguais() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta Teste Alterada");
		contasPage.salvar();
		
		
		assertEquals("J� existe uma conta com esse nome!", contasPage.getMensagemErro());
	}
	
}
