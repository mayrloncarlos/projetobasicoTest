package br.com.mcarlos.pages;

import org.openqa.selenium.By;

import br.com.mcarlos.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escreve("nome", nome);
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String getMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class= 'alert alert-success']"));
	}
	
	public String getMensagemErro() {
		return obterTexto(By.xpath("//div[@class= 'alert alert-danger']"));
	}

	public void clicarAlterarConta(String nome) {
		obterCelula("Conta", nome, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();	
	}
	
	public void clicarExcluirConta(String nome) {
		obterCelula("Conta", nome, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();	
	}
}
