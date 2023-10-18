import Pages.*;
import model.tickets.Flight;
import model.tickets.Passenger;
import org.junit.jupiter.api.Test;

public class TicketsTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets";
    private Passenger passenger = new Passenger("Dmitry", "Tester");
    private Flight flight = new Flight("RIX", "MEL", "CCC", 4, 1, 1, "11-05-2018", 18);

    private final String PRICE = "4130 EUR";
    private final String SUCCESSFUL_REG_MSG = "Thank You for flying with us!";

    @Test
    public void successTicketsBookCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectDepartureAirport(flight.getDeparture());
        homePage.selectArrivalAirport(flight.getArrival());
        homePage.clickGoGoGoBtn();

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(flight, passenger);
        infoPage.clickGetPriceBtn();
        infoPage.clickBookBtn();

        // SeatSelectPage seatSelectPage = new SeatSelectPage(baseFunc);
        // seatSelectPage.selectSeatNr();
        // seatSelectPage.clickBookBtn();

        SeatSelectPage seatSelectPage = new SeatSelectPage(baseFunc);
        seatSelectPage.selectSeatNr(flight.getSeatNr());
        seatSelectPage.priceCheck(PRICE);
        seatSelectPage.departureCheck(flight.getDeparture());
        seatSelectPage.arrivalCheck(flight.getArrival());
        seatSelectPage.nameCheck(passenger.getFirstName());
        seatSelectPage.clickBookBtn();

        FinalPage finalPage = new FinalPage(baseFunc);
        finalPage.successfulMsgCheck(SUCCESSFUL_REG_MSG);
    }
}
