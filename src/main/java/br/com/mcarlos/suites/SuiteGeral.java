package br.com.mcarlos.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.mcarlos.core.DriverFactory;
import br.com.mcarlos.pages.LoginPage;
import br.com.mcarlos.tests.ContaTest;
import br.com.mcarlos.tests.MovimentacaoTest;
import br.com.mcarlos.tests.RemoverMovimentacaoContaTest;
import br.com.mcarlos.tests.ResumoTest;
import br.com.mcarlos.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {

	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("mayrloncarlos2@gmail.com");
		page.setSenha("123456");
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}
