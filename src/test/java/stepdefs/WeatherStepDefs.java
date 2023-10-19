package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.weather.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

    @Given("city ID is {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("latitude is {double}")
    public void latitude_check(double latitude) {
        Assertions.assertEquals(latitude, response.getLat(), "Incorrect Latitude!");
    }

    @And("longitude is {double}")
    public void longitude_check(double longitude) {
        Assertions.assertEquals(longitude, response.getLon(), "Incorrect Longitude!");
    }

    @And("timezone is {string}")
    public void timezone_check(String timezone) {
        Assertions.assertEquals(timezone, response.getTimezone(), "Incorrect timezone!");
    }

    @And("timezone offset is {int}")
    public void timezone_offset_check(int offset) {
        Assertions.assertEquals(offset, response.getTimezoneOffset(), "Incorrect Timezone Offset!");
    }

    @And("current weather data is:")
    public void current_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getCurrent().getDt(), "Incorrect Current Dt!");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getCurrent().getSunrise(), "Incorrect Current Sunrise!");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getCurrent().getSunset(), "Incorrect Current Sunset!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getCurrent().getTemp(), "Incorrect Current temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getCurrent().getFeelsLike(), "Incorrect Current FeelsLike!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getCurrent().getPressure(), "Incorrect Current Pressure!");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getCurrent().getHumidity(), "Incorrect Current humidity!");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getCurrent().getDewPoint(), "Incorrect Current DewPoint!");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getCurrent().getUvi(), "Incorrect Current Uvi!");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getCurrent().getClouds(), "Incorrect Current Clouds!");
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getCurrent().getVisibility(), "Incorrect Current Visibility!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getCurrent().getWindSpeed(), "Incorrect Current WindSpeed!");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getCurrent().getWindDeg(), "Incorrect Current WindDeg!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getCurrent().getWindGust(), "Incorrect Current WindGust!");
    }

    @And("current weather details are:")
    public void current_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getCurrent().getWeathers().get(0).getId(), "Incorrect Current Weather Id!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeathers().get(0).getMain(), "Incorrect Current Weather Main!");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeathers().get(0).getDescription(), "Incorrect Current Weather Description!");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeathers().get(0).getIcon(), "Incorrect Current Weather Icon!");
    }

    @And("minutely weather data is:")
    public void minutely_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getMinutely().get(0).getDt(), "Incorrect Minutely Dt!");
        Assertions.assertEquals(Integer.parseInt(params.get("precipitation")), response.getMinutely().get(0).getPrecipitation(), "Incorrect Minutely Precipitation!");
    }

    @And("hourly weather data is:")
    public void hourly_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getHourly().get(0).getDt(), "Incorrect Hourly dt!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getHourly().get(0).getTemp(), "Incorrect Hourly temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getHourly().get(0).getFeelsLike(), "Incorrect Hourly FeelsLike!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getHourly().get(0).getPressure(), "Incorrect Hourly Pressure!");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getHourly().get(0).getHumidity(), "Incorrect Hourly humidity!");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getHourly().get(0).getDewPoint(), "Incorrect Hourly DewPoint!");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getHourly().get(0).getUvi(), "Incorrect Hourly Uvi!");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getHourly().get(0).getClouds(), "Incorrect Hourly Clouds!");
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getHourly().get(0).getVisibility(), "Incorrect Hourly Visibility!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getHourly().get(0).getWindSpeed(), "Incorrect Hourly WindSpeed!");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getHourly().get(0).getWindDeg(), "Incorrect Hourly WindDeg!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getHourly().get(0).getWindGust(),"Incorrect Hourly WindGust!");
        Assertions.assertEquals(Double.parseDouble(params.get("pop")), response.getHourly().get(0).getPop(), "Incorrect Hourly Pop!");
    }

    @And("hourly weather details are:")
    public void hourly_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getHourly().get(0).getWeathers().get(0).getId(), "Incorrect Hourly Id!");
        Assertions.assertEquals(params.get("main"), response.getHourly().get(0).getWeathers().get(0).getMain(), "Incorrect Hourly Main!");
        Assertions.assertEquals(params.get("description"), response.getHourly().get(0).getWeathers().get(0).getDescription(), "Incorrect Hourly Description!");
        Assertions.assertEquals(params.get("icon"), response.getHourly().get(0).getWeathers().get(0).getIcon(), "Incorrect Hourly Icon!");
    }

    @And("daily weather data is:")
    public void daily_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getDaily().get(0).getDt(), "Incorrect Daily Dt!");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getDaily().get(0).getSunrise(), "Incorrect Daily Sunrise!");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getDaily().get(0).getSunset(), "Incorrect Daily Sunset!");
        Assertions.assertEquals(Long.parseLong(params.get("moonrise")), response.getDaily().get(0).getMoonrise(), "Incorrect Daily Moonrise!");
        Assertions.assertEquals(Long.parseLong(params.get("moonset")), response.getDaily().get(0).getMoonset(), "Incorrect Daily Moonset!");
        Assertions.assertEquals(Double.parseDouble(params.get("moon_phase")), response.getDaily().get(0).getMoonPhase(), "Incorrect Daily MoonPhase!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getDaily().get(0).getPressure(), "Incorrect Daily Pressure!");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getDaily().get(0).getHumidity(), "Incorrect Daily Humidity!");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getDaily().get(0).getDewPoint(), "Incorrect Daily DewPoint!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getDaily().get(0).getWindSpeed(), "Incorrect Daily WindSpeed!");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getDaily().get(0).getWindDeg(), "incorrect Daily WindDeg!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getDaily().get(0).getWindGust(), "Incorrect Daily WindGust!");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getDaily().get(0).getClouds(), "Incorrect Daily Clouds!");
        Assertions.assertEquals(Double.parseDouble(params.get("pop")), response.getDaily().get(0).getPop(), "Incorrect Daily Pop!");
        Assertions.assertEquals(Double.parseDouble(params.get("rain")), response.getDaily().get(0).getRain(), "Incorrect Daily Rain!");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getDaily().get(0).getUvi(), "Incorrect Daily Uvi!");
    }

    @And("daily temperature details are:")
    public void daily_weather_temperature_check(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("day")), response.getDaily().get(0).getTemp().getDay(), "Incorrect Day Temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("min")), response.getDaily().get(0).getTemp().getMin(), "Incorrect Min Temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("max")), response.getDaily().get(0).getTemp().getMax(), "Incorrect Max Temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("night")), response.getDaily().get(0).getTemp().getNight(), "Incorrect Night Temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("eve")), response.getDaily().get(0).getTemp().getEve(), "Incorrect Eve Temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("morn")), response.getDaily().get(0).getTemp().getMorn(), "Incorrect Morn Temp!");
    }

    @And("daily feels like details are:")
    public void daily_feels_like_check(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("day")), response.getDaily().get(0).getFeelsLike().getDay(), "Incorrect Day FeelsLike!");
        Assertions.assertEquals(Double.parseDouble(params.get("night")), response.getDaily().get(0).getFeelsLike().getNight(), "Incorrect Night FeelsLike!");
        Assertions.assertEquals(Double.parseDouble(params.get("eve")), response.getDaily().get(0).getFeelsLike().getEve(), "Incorrect Eve FeelsLike!");
        Assertions.assertEquals(Double.parseDouble(params.get("morn")), response.getDaily().get(0).getFeelsLike().getMorn(), "Incorrect Morn FeelsLike!");
    }

    @And("daily weather details are:")
    public void daily_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getDaily().get(0).getWeathers().get(0).getId(), "Incorrect Daily Weather Id!");
        Assertions.assertEquals(params.get("main"), response.getDaily().get(0).getWeathers().get(0).getMain(), "Incorrect Daily Weather Main!");
        Assertions.assertEquals(params.get("description"), response.getDaily().get(0).getWeathers().get(0).getDescription(), "Incorrect Daily Weather Description!");
        Assertions.assertEquals(params.get("icon"), response.getDaily().get(0).getWeathers().get(0).getIcon(), "Incorrect Daily Weather Icon!");
    }

    @And("alerts data is:")
    public void alerts_data_check(Map<String, String> params) {
        Assertions.assertEquals(params.get("sender_name"), response.getAlerts().get(0).getSenderName(), "Incorrect Sender Name!");
        Assertions.assertEquals(params.get("event"), response.getAlerts().get(0).getEvent(), "Incorrect Event!");
        Assertions.assertEquals(Long.parseLong(params.get("start")), response.getAlerts().get(0).getStart(), "Incorrect Start!");
        Assertions.assertEquals(Long.parseLong(params.get("end")), response.getAlerts().get(0).getEnd(), "Incorrect End!");
    }
}