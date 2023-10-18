package stepdefs;

import Pages.*;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.tickets.Flight;
import model.tickets.Passenger;
import model.tickets.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import requesters.TicketsRequester;

import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private Passenger passenger = new Passenger();
    private Flight flight = new Flight();
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private PassengerInfoPage infoPage;
    private SeatSelectPage seatSelectPage;
    private FinalPage finalPage;
    private List<Reservation> reservations;
    private Reservation reservationFromApi;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Given("airports:")
    public void set_airports(Map<String, String> params) {
        LOGGER.info("Setting airports");
        flight.setDeparture(params.get("from"));
        flight.setArrival(params.get("to"));
    }

    @Given("passenger info is:")
    public void set_passenger_info(Map<String, String> params) {
        LOGGER.info("Filling passenger info");
        passenger.setFirstName(params.get("first_name"));
        passenger.setLastName(params.get("last_name"));
    }

    @Given("flight info is:")
    public void set_flight_info(Map<String, String> params) {
        LOGGER.info("Filling flight info");
        flight.setDiscount(params.get("discount"));
        flight.setPassengersCount(Integer.parseInt(params.get("passengers_count")));
        flight.setChildCount(Integer.parseInt(params.get("child_count")));
        flight.setLuggageCount(Integer.parseInt(params.get("luggage_count")));
        flight.setFlightDate(params.get("flight_date"));
        flight.setSeatNr(Integer.parseInt(params.get("seat_nr")));
    }

    @Given("home page ir opened")
    public void open_home_page() {
        LOGGER.info("Opening homepage");
        baseFunc.openUrl("qaguru.lv:8089/tickets");
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        LOGGER.info("Selecting airports");
        homePage.selectDepartureAirport(flight.getDeparture());
        homePage.selectArrivalAirport(flight.getArrival());
        homePage.clickGoGoGoBtn();
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appears on the passenger info page")
    public void check_selected_airports() {
        LOGGER.info("Airports appears");
        Assertions.assertEquals(flight.getDeparture(), infoPage.departureCheck(), "Wrong Departure Airport!");
        Assertions.assertEquals(flight.getArrival(), infoPage.arrivalCheck(), "Wrong Arrival Airport!");
    }

    @When("we are filling in passenger info")
    public void fill_in_flight_info() {
        LOGGER.info("Filling flight info");
        infoPage.fillInPassengerInfo(flight, passenger);
    }

    @And("requesting price")
    public void get_price() {
        LOGGER.info("Requesting price");
        infoPage.clickGetPriceBtn();
    }

    @Then("airports and price appears in flight details")
    public void airports_and_price_check() {
        LOGGER.info("Appears airports and price");
        Assertions.assertEquals(flight.getDeparture(), infoPage.departureAirportCheck(), "Wrong Departure Airport Info!");
        Assertions.assertEquals(flight.getArrival(), infoPage.arrivalAirportCheck(), "Wrong Arrival Airport Info!");
    }

    @When("we are confirming price")
    public void price_confirming() {
        LOGGER.info("Confirming price");
        infoPage.clickBookBtn();
    }

    @And("selecting seat number")
    public void seat_selecting() {
        LOGGER.info("Selecting seat nr");
        seatSelectPage = new SeatSelectPage(baseFunc);
        seatSelectPage.selectSeatNr(flight.getSeatNr());
    }

    @Then("selected seat number appears")
    public void seat_number_check() {
        LOGGER.info("Seat nr appears");
        Assertions.assertEquals(String.valueOf(flight.getSeatNr()), seatSelectPage.seatNrChecking(), "Wrong Seat!");
    }

    @When("we are confirming seat")
    public void seat_confirming() {
        LOGGER.info("Confirming seat");
        seatSelectPage.clickBookBtn();
    }

    @Then("successful registration message appears")
    public void successful_registration_message_check() {
        LOGGER.info("Successful registration");
        finalPage = new FinalPage(baseFunc);
        finalPage.successfulMessageAppears();
    }


    @When("we are requesting all reservations via API")
    public void request_all_reservations() throws JsonProcessingException {
        LOGGER.info("Requesting reservations");
        TicketsRequester requester = new TicketsRequester();
        reservations = requester.getReservations();
    }

    @Then("current reservation exists in the list")
    public void find_reservation() {
        LOGGER.info("Finding reservations");
        for (Reservation reservation : reservations) {
            if (reservation.getName().equals(passenger.getFirstName())) {
                reservationFromApi = reservation;
                break;
            }
        }

        Assertions.assertNotNull(reservationFromApi, "Can't find reservation!");
    }

    @Then("all data are stored correctly")
    public void check_reservation_data() {
        LOGGER.info("All data is ok");
        Assertions.assertEquals(passenger.getLastName(), reservationFromApi.getSurname(), "Wrong Last Name!");
        Assertions.assertEquals(passenger.getFirstName(), reservationFromApi.getName(), "Wrong Name!");
        Assertions.assertEquals(flight.getDeparture(), reservationFromApi.getAfrom(), "Wrong departure airport!");
        Assertions.assertEquals(flight.getArrival(), reservationFromApi.getAto(), "Wrong arrival airport!");
        Assertions.assertEquals(flight.getSeatNr(), reservationFromApi.getSeat(), "Wrong Seat Nr!");
        Assertions.assertEquals(flight.getPassengersCount(), reservationFromApi.getAdults(), "Wrong Passengers count!");
        Assertions.assertEquals(flight.getChildCount(), reservationFromApi.getChildren(), "Wrong children count!");
        Assertions.assertEquals(flight.getLuggageCount(), reservationFromApi.getBugs(), "Wrong Luggage count!");
        Assertions.assertEquals(flight.getDiscount(), reservationFromApi.getDiscount(), "Wrong discount code!");
        Assertions.assertEquals(flight.getFlightDate().substring(0, 2), reservationFromApi.getFlight(), "Wrong flight date!");
    }
}
