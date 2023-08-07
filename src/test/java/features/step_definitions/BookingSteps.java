package features.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;

public class BookingSteps extends BasePage {

    //public static WebDriver driver;
    HomePage homePage = new HomePage();
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        //driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.navigateToHomePage();

    }

    @When("I browse through the page")
    public void i_browse_through_the_page() {
        homePage.goToRoomsCategory();
    }
    @Then("I have the option to book a room")
    public void i_have_the_option_to_book_a_room() {
       //homePage.assertBookButtonDisplayed();
    	homePage.waitUntillElementIsVisible(homePage.getBookThisRoomButton());
    }
    
    @When("I click on the button Book this room")
    public void clickOnBookThisRoomButton() {
        homePage.clickButton(homePage.getBookThisRoomButton());
    }
    
    @When("^I fill the information needed: \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void fillAllInformations(String firstname, String lastname, String email, String phone) {
        homePage.fillInformations(firstname, lastname, email, phone);
    }
    
    @When("i select 2 availbles nights from the calendar")
    public void Select2nightsIncalendar() {
        homePage.Select2nightsFromCalendar();
    }
    @When("I click on the button  Book")
    public void clickOnBookButton() {
        homePage.clickButton(homePage.getBookButton());
}
    @Then("^the popup Booking successful will diplay with the correct title \"([^\"]*)\" and message \"([^\"]*)\"$")
    public void DisplayPopupInformation(String Title, String Message) {
        homePage.DisplayPopupInformation(Title, Message);
}
    @Then("the date display in the popup match the correct period")
    public void DisplayPopupInformation() {
        homePage.DisplayPopupPeriod();
}
    
    
}
