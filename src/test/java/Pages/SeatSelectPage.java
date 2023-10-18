package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeatSelectPage {

    private final By SEAT_NR_SELECT = By.xpath(".//div[@class = 'seat']");
    private final By BOOK3_BTN = By.id("book3");

    private final By FLIGHT_PRICE_INFO = By.xpath(".//div[@class = 'responsePrice']");
    private final By FLIGHT_INFO = By.xpath(".//span[@class = 'bTxt']");
    private final By SELECTED_SEAT_NR = By.xpath(".//div[@class = 'line']");

    private BaseFunc baseFunc;

    public SeatSelectPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSeatNr(int seatNr){
        //Wait for seats to appear
        baseFunc.waitForElementsCountTobeAtLeast(SEAT_NR_SELECT, 15);
        //Get all seats
        List<WebElement> seats = baseFunc.findElements(SEAT_NR_SELECT);
        Assertions.assertFalse(seats.isEmpty(), "There is no seats at all!");
        //Find necessary seat
        //Select it
        boolean isSeatFound = false;   //flag is down
        for (WebElement seat : seats) {
            if (Integer.parseInt(seat.getText()) == seatNr) {       //== -> sravnivaem (compare) => true / false
                seat.click();
                isSeatFound = true;   //flag is up
                break;
            }
        }

        Assertions.assertTrue(isSeatFound, "Seat Nr." + seatNr + "is not found!");




        //-----------FOR-----------
        //for (int i = 0; i < seats.size(); i++) {    //   i = i + 1 => i++
        //    System.out.println(seats.get(i).getText());
        //    //do something
        //}

        //---------FOR EACH---------
        //for (WebElement seat : seats) {
        //      System.out.println(seat.getText());
            //do something
        //}

        //public void selectSeatNr() {
        //    baseFunc.click(SEAT_NR_SELECT);
        //}

    }


    public void clickBookBtn() {
        baseFunc.click(BOOK3_BTN);
    }


    public void priceCheck(String PRICE) {
        baseFunc.findElement(FLIGHT_PRICE_INFO);
        WebElement priceInfo = baseFunc.findElement(FLIGHT_PRICE_INFO);
        String price = priceInfo.getText();
        Assertions.assertEquals(PRICE, price.substring(56, price.length() - 36), "Wrong Flight Price!");

    }

    public void departureCheck(String DEPARTURE_AIRPORT){
        baseFunc.findElements(FLIGHT_INFO);
        List <WebElement> flightInfoCheck = baseFunc.findElements(FLIGHT_INFO);
        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfoCheck.get(0).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfoCheck.get(3).getText(), "Wrong Departure Airport!");
    }

    public void arrivalCheck(String ARRIVAL_AIRPORT){
        baseFunc.findElements(FLIGHT_INFO);
        List <WebElement> flightInfoCheck = baseFunc.findElements(FLIGHT_INFO);
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfoCheck.get(1).getText(), "Wrong Arrival Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfoCheck.get(4).getText(), "Wrong Arrival Airport!");
    }

    public void nameCheck(String firstName) {
        baseFunc.findElements(FLIGHT_INFO);
        List <WebElement> flightInfoCheck = baseFunc.findElements(FLIGHT_INFO);
        String name = flightInfoCheck.get(2).getText();
        Assertions.assertEquals(firstName, name.substring(0, name.length() - 1), "Wrong Name!");
    }

    public String seatNrChecking() {
        return baseFunc.findElement(SELECTED_SEAT_NR).getText().substring(14);

    }

    //public String seatSelectCheck() {
    //    return baseFunc.findElement(SEAT_NR_SELECT).getText();
    //}
}
