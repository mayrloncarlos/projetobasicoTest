package br.com.mcarlos.pages;

import br.com.mcarlos.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarTelaMovimentacao() {
		clicarLink("Criar Movimenta��o");
	}
	
	public void acessarTelaResumo() {
		clicarLink("Resumo Mensal");
	}
}
