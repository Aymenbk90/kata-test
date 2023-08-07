package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.CommonUtils.*;
import static utils.DriversUtils.*;

import java.time.LocalDate;
import java.util.List;

public class HomePage {

	@FindBy(tagName = "h2")
	private WebElement roomCategoryIdentifier;

	@FindBy(xpath = "//button[contains(@class,'openBooking')]")
	private WebElement bookThisRoomButton;
	
	@FindBy(xpath = "//button[contains(@class,'primary float-right book-room')]")
	private WebElement bookButton;

	@FindBy(name = "firstname")
	private WebElement FirstName;

	@FindBy(name = "lastname")
	private WebElement LastName;

	@FindBy(name = "email")
	private WebElement Email;

	@FindBy(name = "phone")
	private WebElement Phone;

	@FindBy(xpath = "//*[contains(@class,'today')]")
	private WebElement todayDate;

	@FindAll({ @FindBy(xpath = "//*[contains(@class,'today')]/../*") })
	private List<WebElement> ActualWeekDaysElements;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath = "//*[contains(@class,'ReactModalPortal')]")
	private WebElement PopupConfirmation;
	@FindBy(xpath = "//*[contains(@class,'col-sm-6')]/h3")
	private WebElement PopupTitle;
	
	@FindBy(xpath = "//*[contains(@class,'col-sm-6')]/p[1]")
	private WebElement PopupMessage;
	
	@FindBy(xpath = "//*[contains(@class,'col-sm-6')]/p[2]")
	private WebElement PopupBookingPeriod;

	public void goToRoomsCategory() {
		try {
			scrollToElement(roomCategoryIdentifier);
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("Error in the rooms category method");
		}
	}

	public void assertBookButtonDisplayed() {
		Assert.assertEquals(true, getBookThisRoomButton().isDisplayed());
	}

	public void clickButton(WebElement element) {
		scrollToElement(element);
		element.click();
	}

	public void navigateToHomePage() {
		getDriver().get("https://automationintesting.online/#/");
	}

	public void waitUntillElementIsVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void fillInformations(String firstName, String lastName, String email, String phone) {
		waitUntillElementIsVisible(FirstName);
		scrollToElement(FirstName);
		FirstName.sendKeys(firstName);
		waitUntillElementIsVisible(LastName);
		LastName.sendKeys(lastName);
		waitUntillElementIsVisible(Email);
		Email.sendKeys(email);
		waitUntillElementIsVisible(Phone);
		Phone.sendKeys(phone);
	}

	public void Select2nightsFromCalendar() {
		// waitUntillElementIsVisible(todayDate);
		scrollToElement(todayDate);

		for (int i = 0; i < ActualWeekDaysElements.size(); i++) {
			if (ActualWeekDaysElements.get(i).getAttribute("class").contains("today")) {
				Actions actions = new Actions(getDriver());
				actions.moveToElement(todayDate);
				actions.clickAndHold();
				actions.moveToElement(ActualWeekDaysElements.get(i + 2));
				actions.release().perform();
			}

		}

	}
	
	public void DisplayPopupInformation(String Title,String Message) {
		waitUntillElementIsVisible(PopupConfirmation);
		Assert.assertEquals(PopupTitle.getText(), Title);
		Assert.assertEquals(PopupMessage.getText(), Message);
	}
	
	public void DisplayPopupPeriod() {
		LocalDate startDayOfBooking = LocalDate.now();
		LocalDate EndDayOfBooking = startDayOfBooking.plusDays(3);
		String Period = startDayOfBooking.toString()+" - "+EndDayOfBooking.toString();
		Assert.assertEquals(PopupBookingPeriod.getText(), Period);
	}
	

	public WebElement getBookThisRoomButton() {
		return bookThisRoomButton;
	}

	public void setBookThisRoomButton(WebElement bookThisRoomButton) {
		this.bookThisRoomButton = bookThisRoomButton;
	}

	public WebElement getBookButton() {
		return bookButton;
	}

	public void setBookButton(WebElement bookButton) {
		this.bookButton = bookButton;
	}

}
