package br.com.mcarlos.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

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
		movimentacaoPage.setDescricao("Teste de descri��o");
		movimentacaoPage.setInteressado("Mayrlon");
		movimentacaoPage.setValor("150.00");
		movimentacaoPage.setConta("Conta Teste Alterada");
		movimentacaoPage.setSituacaoPendente();
		movimentacaoPage.salvar();
		
		assertEquals("Movimenta��o adicionada com sucesso!", movimentacaoPage.getMensagemSucesso());
	}
	
	@Test
	public void testeCamposObrigatorios() {
		menuPage.acessarTelaMovimentacao();
		
		movimentacaoPage.salvar();
		List<String> obterErros = movimentacaoPage.obterErros();
		
		assertTrue(obterErros.containsAll(Arrays.asList("Data da Movimenta��o � obrigat�rio",
											"Data do pagamento � obrigat�rio",
											"Descri��o � obrigat�rio",
											"Interessado � obrigat�rio",
											"Valor � obrigat�rio",
											"Valor deve ser um n�mero")));
		assertEquals(6, obterErros.size());
	}
}
