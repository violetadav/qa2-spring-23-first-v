import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TicketsTests {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");

    //private final By SELECTED_AIRPORT = By.xpath(".//span[@class = 'bTxt']");
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULTS_INPUT = By.id("adults");
    private final By CHILDREN_INPUT = By.id("children");
    private final By LUGGAGE_INPUT = By.id("bugs");
    private final By SELECTED_FLIGHT = By.id("flight");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick = 'setLang();']");
    private final By FLIGHT_INFO = By.xpath(".//span[@class = 'bTxt']");
    private final By FLIGHT_PRICE = By.xpath(".//div[@class = 'responsePrice']");
    private final By BOOK2_BTN = By.id("book2");
    private final By SEAT_NR_SELECT = By.xpath(".//div[@onclick = 'seat(6)']");
    private final By BOOK3_BTN = By.id("book3");

    private final String URL = "http://www.qaguru.lv:8089/tickets";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";
    private final String PRICE = "4130 EUR";

    private final String NAME = "Dmitrijs";
    private final String SURNAME = "Lidotajs";
    private final String DISCOUNT = "Free";
    private final int ADULTS_COUNT = 2;
    private final int CHILDREN_COUNT = 3;
    private final int LUGGAGE_COUNT = 5;
    private final String FLIGHT_DATE = "17";

    @Test
    public void successTicketsBookCheck() {
        //Open browser
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        //Open Home Page
        browser.get(URL);

        //Select Departure airport
        WebElement fromDropdown = browser.findElement(FROM);
        Select fromSelect = new Select(fromDropdown);
        fromSelect.selectByValue(DEPARTURE_AIRPORT);

        //Select Arrival airport
        WebElement toDropdown = browser.findElement(TO);
        Select toSelect = new Select(toDropdown);
        toSelect.selectByValue(ARRIVAL_AIRPORT);

        //Press GoGoGo btn
        browser.findElement(GO_BTN).click();

        //Check if selected airport appears
        //List<WebElement> selectedAirports = browser.findElements(SELECTED_AIRPORT);
        //System.out.println("First airport " + selectedAirports.get(0).getText());
        //System.out.println("Second airport " + selectedAirports.get(1).getText());

        //Fill in passenger personal info
        WebElement nameInputField = browser.findElement(NAME_INPUT);
        nameInputField.clear();
        nameInputField.sendKeys(NAME);

        WebElement surnameInputField = browser.findElement(SURNAME_INPUT);
        surnameInputField.clear();
        surnameInputField.sendKeys(SURNAME);

        WebElement discountInputField = browser.findElement(DISCOUNT_INPUT);
        discountInputField.clear();
        discountInputField.sendKeys(DISCOUNT);

        WebElement adultsCountField = browser.findElement(ADULTS_INPUT);
        adultsCountField.clear();
        adultsCountField.sendKeys(String.valueOf(ADULTS_COUNT));

        WebElement childrenCountField = browser.findElement(CHILDREN_INPUT);
        childrenCountField.clear();
        childrenCountField.sendKeys(String.valueOf(CHILDREN_COUNT));

        WebElement luggageCountField = browser.findElement(LUGGAGE_INPUT);
        luggageCountField.clear();
        luggageCountField.sendKeys(String.valueOf(LUGGAGE_COUNT));

        WebElement flightDropdown = browser.findElement(SELECTED_FLIGHT);
        Select flightSelect = new Select(flightDropdown);
        flightSelect.selectByValue(FLIGHT_DATE);

        //Press Get Price link
        browser.findElement(GET_PRICE_BTN).click();

        //Press Book btn
        browser.findElement(BOOK2_BTN).click();

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(SEAT_NR_SELECT));

        //Select Seat Nr
        browser.findElement(SEAT_NR_SELECT).click();

        //Press Book btn
        browser.findElement(BOOK3_BTN).click();

        WebElement flightPrice = browser.findElement(FLIGHT_PRICE);
        String price = flightPrice.getText();
        Assertions.assertEquals(PRICE, price.substring(56, price.length() - 36), "Wrong Flight Price");

        wait.until(ExpectedConditions.numberOfElementsToBe(FLIGHT_INFO, 5));

        List<WebElement> flightInfo = browser.findElements(FLIGHT_INFO);

        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(0).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(1).getText(), "Wrong Arrival Airport!");

        String name = flightInfo.get(2).getText();
        Assertions.assertEquals(NAME, name.substring(0, name.length() - 1), "Wrong Name!");

        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(3).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(4).getText(), "Wrong Arrival Airport!");

    }

}






//Check if selected date appears
//Press Get Price link
//Press Book btn
//Select seat Nr
//Press Book btn
//Check if successful message appears