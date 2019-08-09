package br.com.mcarlos.pages;

import org.openqa.selenium.By;

import br.com.mcarlos.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escreve("nome", nome);
	}
	
	public void salvar() {
		clicar(By.xpath("//button[.='Salvar']"));
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class= 'alert alert-success']"));
	}
}
