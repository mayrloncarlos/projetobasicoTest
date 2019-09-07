package br.com.mcarlos.tests;

import static br.com.mcarlos.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.mcarlos.core.BaseTest;
import br.com.mcarlos.core.DriverFactory;
import br.com.mcarlos.pages.MenuPage;
import br.com.mcarlos.pages.ResumoPage;

public class ResumoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void teste1ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		assertEquals("Movimentação removida com sucesso!", resumoPage.getMensagemSucesso());
	}
	
	@Test
	public void teste2ResumoMensal() {
		menuPage.acessarTelaResumo();
		
		assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		resumoPage.selecionarAno("2016");
		resumoPage.buscar();
		
		List<WebElement> elementosEncontrados = 
				DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		
		assertEquals(0, elementosEncontrados.size());
	}
}
