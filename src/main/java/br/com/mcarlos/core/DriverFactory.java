package br.com.mcarlos.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.mcarlos.core.Propriedades.TipoExecucao;

public class DriverFactory {
	
//	private static WebDriver driver;
	
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
		switch (Propriedades.BROWSER) {
			case FIREFOX: driver = new FirefoxDriver(); break;
			case CHROME: driver = new ChromeDriver(); break;
			}
		}
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
			case FIREFOX: cap = DesiredCapabilities.firefox(); break;
			case CHROME: cap = DesiredCapabilities.chrome(); break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.9:4444/wd/hub") , cap) ;
			} catch (MalformedURLException e) {
				System.err.println("Falha na conex�o com o GRID");
				e.printStackTrace();
			}
		}
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
			case FIREFOX: cap = DesiredCapabilities.firefox(); break;
			case CHROME: cap = DesiredCapabilities.chrome(); break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://mayrlon:a73ccddd-e252-488d-985f-d397b2c34dad@ondemand.saucelabs.com:80/wd/hub") , cap) ;
			} catch (MalformedURLException e) {
				System.err.println("Falha na conex�o com o GRID");
				e.printStackTrace();
			}
		}
			driver.manage().window().maximize();
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;		
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}

}
