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
	public void teste1InserirMovimentacao() {
		menuPage.acessarTelaMovimentacao();
		
		movimentacaoPage.setTipoMovimentacao("Receita");
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movimentacaoPage.setDataPagamento(obterDataFormatada(new Date()));
		movimentacaoPage.setDescricao("Teste de descrição");
		movimentacaoPage.setInteressado("Mayrlon");
		movimentacaoPage.setValor("150.00");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvar();
		
		assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.getMensagemSucesso());
	}
	
	@Test
	public void teste2CamposObrigatorios() {
		menuPage.acessarTelaMovimentacao();
		
		movimentacaoPage.salvar();
		List<String> obterErros = movimentacaoPage.obterErros();
		
		assertTrue(obterErros.containsAll(Arrays.asList("Data da Movimentação é obrigatório",
											"Data do pagamento é obrigatório",
											"Descrição é obrigatório",
											"Interessado é obrigatório",
											"Valor é obrigatório",
											"Valor deve ser um número")));
		assertEquals(6, obterErros.size());
	}
	
	@Test
	public void teste3InserirMovimentacaoFutura() {
		menuPage.acessarTelaMovimentacao();
		
		Date dataFutura = obterDataComDiferencaDias(5);
		
		movimentacaoPage.setTipoMovimentacao("Despesa");
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movimentacaoPage.setDataPagamento(obterDataFormatada(dataFutura));
		movimentacaoPage.setDescricao("Teste de descrição");
		movimentacaoPage.setInteressado("Mayrlon");
		movimentacaoPage.setValor("150.00");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvar();
		
		List<String> obterErros = movimentacaoPage.obterErros();
		assertTrue(
				obterErros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		assertEquals(1, obterErros.size());
	}
}
