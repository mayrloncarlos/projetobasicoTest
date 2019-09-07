package br.com.mcarlos.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.mcarlos.core.BaseTest;
import br.com.mcarlos.pages.HomePage;
import br.com.mcarlos.pages.MenuPage;

public class SaldoTest extends BaseTest {
	
	private HomePage homePage = new HomePage();
	private MenuPage menuPage = new MenuPage();

	@Test
	public void testeSaldoConta() {
		menuPage.acessarTelaPrincipal();
		
		assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
	}
}
