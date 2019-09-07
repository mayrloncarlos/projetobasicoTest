package br.com.mcarlos.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.CHROME;
	
	public static TipoExecucao TIPO_EXECUCAO =  TipoExecucao.NUVEM;
	
//	public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime(); 
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
	
	public enum TipoExecucao {
		LOCAL,
		GRID,
		NUVEM
	}
}
