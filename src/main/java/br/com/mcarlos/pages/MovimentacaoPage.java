package br.com.mcarlos.pages;

import org.openqa.selenium.By;

import br.com.mcarlos.core.BasePage;

public class MovimentacaoPage extends BasePage {	

	public void selecionarTipoMovimentacao(String movimentacao) {
		selecionarCombo("tipo", movimentacao);
	}
	
	public void inserirDataMovimentacao(String data) {
		escreve("data_transacao", data);
	}
	
	public void inserirDataPagamento(String data) {
		escreve("data_pagamento", data);
	}
	
	public void inserirDescricao(String descricao) {
		escreve("descricao", descricao);
	}
	
	public void inserirInteressado(String interessado) {
		escreve("interessado", interessado);
	}
	
	public void inserirValor(String valor) {
		escreve("valor", valor);
	}
	
	public void selecionarConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void selecionarSituacaoPendente() {
		clicar("status_pendente");
	}
	
	public void selecionarSituacaoPago() {
		clicar("status_pago");
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class= 'alert alert-success']"));
	}
	
	public void salvar() {
		clicar(By.xpath("//button[.='Salvar']"));
	}
}
