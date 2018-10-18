package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {

	private WebDriver driver;
	private By fieldName = By.id ("field-customerName");
	private By fieldLastName = By.id ("field-contactLastName");
	private By fieldContactFirstName = By.id("field-contactFirstName");
	private By fieldPhone = By.id("field-phone");
	private By fieldAdressLine1 = By.id("field-addressLine1");
	private By fieldAdressLine2 = By.id("field-addressLine2");
	private By fieldCity = By.id("field-city");
	private By fieldState= By.id("field-state");
	private By fieldPostalCode = By.id("field-postalCode");
	private By fieldCountry = By.id("field-country");
	private By selectEmployer = By.id("field-salesRepEmployeeNumber");
	private By divSelectEmployer = By.id("field_salesRepEmployeeNumber_chosen");
	private By fieldCreditLimit = By.id("field-creditLimit");
	private By btnSave = By.id("form-button-save");
	private By btnSaveAndGo = By.id("save-and-go-back-button");
	private By btnCancel = By.id("cancel-button");
	private By labelMsgSucess = By.xpath("//*[@id=\"report-success\"]/p");
	private By linkBackToList = By.linkText("Go back to list");
	
	
	public AddCustomerPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void setName (String name) {
		driver.findElement(fieldName).sendKeys(name);
	}
	public void setLastName (String lastName) {
		driver.findElement(fieldLastName).sendKeys(lastName);
	}
	public void setContactFirstName (String contactFirstName) {
		driver.findElement(fieldContactFirstName).sendKeys(contactFirstName);
	}
	public void setPhone (String phone) {
		driver.findElement(fieldPhone).sendKeys(phone);
	}
	public void setAdressLine1 (String adressLine1) {
		driver.findElement(fieldAdressLine1).sendKeys(adressLine1);
	}
	public void setAdressLine2 (String adressLine2) {
		driver.findElement(fieldAdressLine2).sendKeys(adressLine2);
	}
	public void setCity (String city) {
		driver.findElement(fieldCity).sendKeys(city);
	}
	public void setState (String state) {
		driver.findElement(fieldState).sendKeys(state);
	}
	public void setPostalCode (String postalCode) {
		driver.findElement(fieldPostalCode).sendKeys(postalCode);
	}
	public void setCountry (String country) {
		driver.findElement(fieldCountry).sendKeys(country);
	}
	public void setEmployer (String employer) {
		Select comboEmployer = new Select (driver.findElement(selectEmployer));
		driver.findElement(divSelectEmployer).click();
		//Devido ao select possuir um display none foi necessario clicar na div para faze-lo visivel.
		comboEmployer.selectByVisibleText(employer);
	}
	public void setCreditLimit (String creditLimit) {
		driver.findElement(fieldCreditLimit).sendKeys(creditLimit);
	}
	
	public void clickBtnSave() {
		driver.findElement(btnSave).click();
	}
	public void clickBtnSaveAndGo() {
		driver.findElement(btnSaveAndGo).click();
	}
	public void clickCancel() {
		driver.findElement(btnCancel).click();
	}
	public  String getMsgLabelSucess() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(labelMsgSucess));
		//aguarda a visibilidade do label para que possa dar get no texto.
		return driver.findElement(labelMsgSucess).getText();
	}
	public void clickBackToList() {
		driver.findElement(linkBackToList).click();
	}
	
	
}
