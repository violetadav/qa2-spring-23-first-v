package Pages;

import model.tickets.Flight;
import model.tickets.Passenger;
import org.openqa.selenium.By;

public class PassengerInfoPage {
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULTS_INPUT = By.id("adults");
    private final By CHILDREN_INPUT = By.id("children");
    private final By LUGGAGE_INPUT = By.id("bugs");
    private final By SELECTED_FLIGHT = By.id("flight");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick = 'setLang();']");
    private final By BOOK2_BTN = By.id("book2");
    private final By FLIGHT_INFO = By.xpath(".//span[@class = 'bTxt']");

    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInPassengerInfo(Flight flight, Passenger passenger) {
        baseFunc.type(NAME_INPUT, passenger.getFirstName());
        baseFunc.type(SURNAME_INPUT, passenger.getLastName());
        baseFunc.type(DISCOUNT_INPUT, flight.getDiscount());
        baseFunc.type(ADULTS_INPUT, flight.getPassengersCount());
        baseFunc.type(CHILDREN_INPUT, flight.getChildCount());
        baseFunc.type(LUGGAGE_INPUT, flight.getLuggageCount());
        baseFunc.selectByText(SELECTED_FLIGHT, flight.getFlightDate());
    }

    public String departureCheck() {
        return baseFunc.waitForNumbersOfElementsToBe(FLIGHT_INFO, 2).get(0).getText();
    }

    public String arrivalCheck() {
        return baseFunc.waitForNumbersOfElementsToBe(FLIGHT_INFO, 2).get(1).getText();
    }

    public String arrivalAirportCheck() {
        return baseFunc.waitForNumbersOfElementsToBe(FLIGHT_INFO, 5).get(4).getText();
    }

    public String departureAirportCheck() {
        return baseFunc.waitForNumbersOfElementsToBe(FLIGHT_INFO, 5).get(3).getText();
    }

    public void clickGetPriceBtn(){
        baseFunc.click(GET_PRICE_BTN);
    }

    public void clickBookBtn() {
        baseFunc.click(BOOK2_BTN);
    }
}
