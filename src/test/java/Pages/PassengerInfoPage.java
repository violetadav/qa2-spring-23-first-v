package Pages;

import com.beust.ah.A;
import model.ReservationInfo;
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

    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInPassengerInfo(ReservationInfo reservationInfo) {
        baseFunc.type(NAME_INPUT, reservationInfo.getFirstName());
        baseFunc.type(SURNAME_INPUT, reservationInfo.getLastName());
        baseFunc.type(DISCOUNT_INPUT, reservationInfo.getDiscount());
        baseFunc.type(ADULTS_INPUT, reservationInfo.getPassengerCount());
        baseFunc.type(CHILDREN_INPUT, reservationInfo.getChildCount());
        baseFunc.type(LUGGAGE_INPUT, reservationInfo.getBagsCount());
        baseFunc.selectByText(SELECTED_FLIGHT, reservationInfo.getFlightDate());
    }

    public void clickGetPriceBtn(){
        baseFunc.click(GET_PRICE_BTN);
    }

    public void clickBookBtn() {
        baseFunc.click(BOOK2_BTN);
    }
}
