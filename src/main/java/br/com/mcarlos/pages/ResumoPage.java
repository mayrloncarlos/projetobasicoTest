package br.com.mcarlos.pages;

import org.openqa.selenium.By;

import br.com.mcarlos.core.BasePage;

public class ResumoPage extends BasePage {

	public void excluirMovimentacao() {
		clicar(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String getMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class= 'alert alert-success']"));
	}
	
	public void selecionarAno(String ano) {
		selecionarCombo("ano", ano);
	}
	
	public void buscar() {
		clicar(By.xpath("//input[@value='Buscar']"));
	}
}
