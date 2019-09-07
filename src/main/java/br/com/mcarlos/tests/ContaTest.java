package br.com.mcarlos.tests;

import static br.com.mcarlos.core.Propriedades.NOME_CONTA_ALTERADA;
import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.mcarlos.core.BaseTest;
import br.com.mcarlos.pages.ContasPage;
import br.com.mcarlos.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		
		
		contasPage.clicarAlterarConta("Conta Teste");
		contasPage.setNome(NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		assertEquals("Conta alterada com sucesso!", contasPage.getMensagemSucesso());
	}
	
	@Test
	public void teste3InserirContasIguais() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome(NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		
		assertEquals("Já existe uma conta com esse nome!", contasPage.getMensagemErro());
	}
}
