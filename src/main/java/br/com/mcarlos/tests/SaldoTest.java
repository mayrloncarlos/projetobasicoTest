package br.com.mcarlos.tests;

import static br.com.mcarlos.core.Propriedades.NOME_CONTA_ALTERADA;
import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.mcarlos.core.BaseTest;
import br.com.mcarlos.pages.HomePage;
import br.com.mcarlos.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaldoTest extends BaseTest {
	
	private HomePage homePage = new HomePage();
	private MenuPage menuPage = new MenuPage();

	@Test
	public void testeSaldoConta() {
		menuPage.acessarTelaPrincipal();
		
		assertEquals("150.00", homePage.obterSaldoConta(NOME_CONTA_ALTERADA));
	}
}
