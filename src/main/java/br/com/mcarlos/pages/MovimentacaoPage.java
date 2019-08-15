package br.com.mcarlos.pages;

import org.openqa.selenium.By;

import br.com.mcarlos.core.BasePage;

public class MovimentacaoPage extends BasePage {	

	public void setTipoMovimentacao(String movimentacao) {
		selecionarCombo("tipo", movimentacao);
	}
	
	public void setDataMovimentacao(String data) {
		escreve("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		escreve("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		escreve("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escreve("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escreve("valor", valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void setSituacaoPendente() {
		clicar("status_pendente");
	}
	
	public void setSituacaoPago() {
		clicar("status_pago");
	}
	
	public String getMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class= 'alert alert-success']"));
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
}
