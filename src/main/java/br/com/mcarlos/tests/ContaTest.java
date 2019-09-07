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
	public void teste1InserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta Teste");
		contasPage.salvar();
		
		
		assertEquals("Conta adicionada com sucesso!", contasPage.getMensagemSucesso());
	}
	
	@Test
	public void teste2AlterarConta() {
		menuPage.acessarTelaListarConta();
		
		
		contasPage.clicarAlterarConta("Conta para alterar");
		contasPage.setNome("Conta alterada");
		contasPage.salvar();
		
		assertEquals("Conta alterada com sucesso!", contasPage.getMensagemSucesso());
	}
	
	@Test
	public void teste3InserirContasIguais() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();
		
		
		assertEquals("Já existe uma conta com esse nome!", contasPage.getMensagemErro());
	}
}
