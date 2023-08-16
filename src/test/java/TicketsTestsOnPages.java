import Pages.BaseFunc;
import Pages.HomePage;
import Pages.PassengerInfoPage;
import Pages.SeatSelectPage;
import model.ReservationInfo;
import org.junit.jupiter.api.Test;

public class TicketsTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";
    private ReservationInfo info = new ReservationInfo("Dmitrijs", "Lidotajs", "Free", 2, 3, 5, "17-05-2018");

    private int seatNr = 28;

    private final String PRICE = "4130 EUR";

    @Test
    public void successTicketsBookCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectDepartureAirport(DEPARTURE_AIRPORT);
        homePage.selectArrivalAirport(ARRIVAL_AIRPORT);
        homePage.clickGoGoGoBtn();

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(info);
        infoPage.clickGetPriceBtn();
        infoPage.clickBookBtn();

        // SeatSelectPage seatSelectPage = new SeatSelectPage(baseFunc);
        // seatSelectPage.selectSeatNr();
        // seatSelectPage.clickBookBtn();

        SeatSelectPage seatSelectPage = new SeatSelectPage(baseFunc);
        seatSelectPage.selectSeatNr(seatNr);
        seatSelectPage.priceCheck(PRICE);
        seatSelectPage.departureCheck(DEPARTURE_AIRPORT);
        seatSelectPage.arrivalCheck(ARRIVAL_AIRPORT);
        seatSelectPage.nameCheck(info.getFirstName());
        seatSelectPage.clickBookBtn();
    }
}
