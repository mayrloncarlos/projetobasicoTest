package br.com.mcarlos.tests;

import static br.com.mcarlos.utils.DataUtils.obterDataComDiferencaDias;
import static br.com.mcarlos.utils.DataUtils.obterDataFormatada;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
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
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movimentacaoPage.setDataPagamento(obterDataFormatada(new Date()));
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
	
	@Test
	public void inserirMovimentacaoFutura() {
		menuPage.acessarTelaMovimentacao();
		
		Date dataFutura = obterDataComDiferencaDias(5);
		
		movimentacaoPage.setTipoMovimentacao("Despesa");
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movimentacaoPage.setDataPagamento(obterDataFormatada(dataFutura));
		movimentacaoPage.setDescricao("Teste de descri��o");
		movimentacaoPage.setInteressado("Mayrlon");
		movimentacaoPage.setValor("150.00");
		movimentacaoPage.setConta("Conta Teste Alterada");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvar();
		
		List<String> obterErros = movimentacaoPage.obterErros();
		assertTrue(
				obterErros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		assertEquals(1, obterErros.size());
	}
}
