package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private By elementSelectVersion = By.id("switch-version-select");
	private By btnAddCustumer = By.partialLinkText("Add Customer");
	private By btnSearch = By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]");
	private By inputSearch = By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/input");
	private By firstCheckBox = By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr[1]/td[1]/input");
	private By btnDelete = By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a");
	private By divSucessDelete = By.xpath("/html/body/div[3]");
	private By msgSucessDelete = By.xpath("/html/body/div[3]/span[3]/p");
	private By btnDeleteModal = By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]");
	private By txtFirstRecordTable = By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr[1]/td[3]");
	private By txtAlertModal = By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]");
	
	public HomePage (WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void selectVersion (String version) {
		Select comboSelectVersion = new Select (driver.findElement(elementSelectVersion));
		comboSelectVersion.selectByVisibleText(version);
		
		
	}
	
	public void clickAddCustomer () {
		driver.findElement(btnAddCustumer).click();
	}
	public void clickSearch() {
		driver.findElement(btnSearch).click();
	}
	public void setSearch(String search) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(inputSearch));
		driver.findElement(inputSearch).sendKeys(search);
		driver.findElement(inputSearch).sendKeys(Keys.ENTER);
	}
	public void clickFirstCheckBox() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.textToBePresentInElementLocated(txtFirstRecordTable, "Teste Sicredi"));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(firstCheckBox));
		driver.findElement(firstCheckBox).click();
	}
	public void clickBtnDelete() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(btnDelete));
		driver.findElement(btnDelete).click();
	}
	public void clickBtnDeleteModal() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(btnDeleteModal));
		driver.findElement(btnDeleteModal).click();
		
	}
	public boolean validaMsgSucesso(String msg) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(divSucessDelete));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(msgSucessDelete));		
		return driver.findElement(msgSucessDelete).getText().equals(msg);
		
		
	}

	public String getTxtAlertModal() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(txtAlertModal));
		return driver.findElement(txtAlertModal).getText();
		
	}
	public boolean validaTextoPopUp(String texto) {
		
		return getTxtAlertModal().equals(texto);
	}
}
