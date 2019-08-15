package br.com.mcarlos.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.mcarlos.core.BaseTest;
import br.com.mcarlos.pages.ContasPage;
import br.com.mcarlos.pages.MenuPage;
import br.com.mcarlos.pages.MovimentacaoPage;

public class ContaTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

	@Test
	public void testeInserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta Teste");
		contasPage.salvar();
		
		
		assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void testeAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		
		contasPage.clicarAlterarConta("Conta Teste");
		contasPage.setNome("Conta Teste Alterada");
		contasPage.salvar();
		
		assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void testeInserirContasIguais() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta Teste Alterada");
		contasPage.salvar();
		
		
		assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
	
	@Test
	public void testeInserirMovimentacao() {
		menuPage.acessarTelaMovimentacao();
		
		movimentacaoPage.selecionarTipoMovimentacao("Despesa");
		movimentacaoPage.inserirDataMovimentacao("10/08/2019");
		movimentacaoPage.inserirDataPagamento("15/08/2019");
		movimentacaoPage.inserirDescricao("Teste de descrição");
		movimentacaoPage.inserirInteressado("Mayrlon");
		movimentacaoPage.inserirValor("150.00");
		movimentacaoPage.selecionarConta("Conta Teste Alterada");
		movimentacaoPage.selecionarSituacaoPendente();
		movimentacaoPage.salvar();
		
		assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
	}
}
