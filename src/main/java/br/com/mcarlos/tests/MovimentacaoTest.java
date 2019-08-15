package br.com.mcarlos.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.mcarlos.core.BaseTest;
import br.com.mcarlos.pages.MenuPage;
import br.com.mcarlos.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {
	
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	private MenuPage menuPage = new MenuPage();

	@Test
	public void testeInserirMovimentacao() {
		menuPage.acessarTelaMovimentacao();
		
		movimentacaoPage.setTipoMovimentacao("Despesa");
		movimentacaoPage.setDataMovimentacao("10/08/2019");
		movimentacaoPage.setDataPagamento("15/08/2019");
		movimentacaoPage.setDescricao("Teste de descrição");
		movimentacaoPage.setInteressado("Mayrlon");
		movimentacaoPage.setValor("150.00");
		movimentacaoPage.setConta("Conta Teste Alterada");
		movimentacaoPage.setSituacaoPendente();
		movimentacaoPage.salvar();
		
		assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.getMensagemSucesso());
	}
}
