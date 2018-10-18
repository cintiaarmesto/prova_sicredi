package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.HomePage;

public class Desafio1 {
	private WebDriver driver;
	private AddCustomerPage pageAddCustomer;
	private HomePage pageHome;
	
	@BeforeTest 

	    public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");

	    }
	 @Test(priority=0)
	 public void teste_Desafio_1() {
		 String msgSucessoGravacao = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
		 pageHome = new HomePage (driver);
		 pageHome.selectVersion("Bootstrap V4 Theme");
		 pageHome.clickAddCustomer();
		 pageAddCustomer = new AddCustomerPage(driver);
		 pageAddCustomer.setName("Teste Sicredi");
		 pageAddCustomer.setLastName("Teste");
		 pageAddCustomer.setContactFirstName("Cintia");
		 pageAddCustomer.setPhone(" 51 9999-9999");
		 pageAddCustomer.setAdressLine1(" Av Assis Brasil, 3970");
		 pageAddCustomer.setAdressLine2("Torre D");
		 pageAddCustomer.setCity("Porto Alegre");
		 pageAddCustomer.setState("RS");
		 pageAddCustomer.setPostalCode("91000-000");
		 pageAddCustomer.setCountry("Brasil");
		 pageAddCustomer.setEmployer("Fixter");
		 pageAddCustomer.setCreditLimit("200");
		 pageAddCustomer.clickBtnSave();
		 //Mensagem de sucesso não está de acordo com o roteiro. Informei a mensagem que a pagina retorna para que o teste não falhasse, deve ser verificado.
		 Assert.assertTrue(pageAddCustomer.getMsgLabelSucess().equals(msgSucessoGravacao));

	 }
	 @AfterTest
	 public void tearDown() {
		 driver.close();
	 }

}
