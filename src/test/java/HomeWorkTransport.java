import model.AirPlane;
import model.Car;
import model.Locomotive;
import model.RouteRigaTbilisi;
import org.junit.jupiter.api.Test;

public class HomeWorkTransport {
    @Test
    public void fuelConsumptionCalculation(){
        AirPlane raketa = new AirPlane();
        raketa.setBrand("Raketishe");
        raketa.setModel("Mig-23");
        raketa.setAviationFuelConsumptionKgPer1hour(2850);

        Car mashina = new Car();
        mashina.setBrand("Ziguli");
        mashina.setModel("Kopeika");
        mashina.setFuelConsumptionLitersPer100Km(8);

        Locomotive parovoz = new Locomotive();
        parovoz.setBrand("Chuh_Chuh");
        parovoz.setModel("MnogoPara");
        parovoz.setCoalConsumptionTonsPer100Km(4500);
        parovoz.setWaterConsumptionCubicMetersPer100Km(25);

        RouteRigaTbilisi marshrut = new RouteRigaTbilisi();
        marshrut.setAirDistanceHours(3.5f);
        marshrut.setRoadDistanceKm(2819);
        marshrut.setRailDistanceKm(2615);

        raketa.printFullName();
        System.out.println(raketa.getAviationFuelConsumptionKgPer1hour() * marshrut.getAirDistanceHours());
        mashina.printFullName();
        System.out.println(marshrut.getRoadDistanceKm() / 100 * mashina.getFuelConsumptionLitersPer100Km());
        parovoz.printFullName();
        System.out.println(marshrut.getRailDistanceKm() / 100 * parovoz.getCoalConsumptionTonsPer100Km());
        System.out.println(marshrut.getRailDistanceKm() / 100 * parovoz.getWaterConsumptionCubicMetersPer100Km());
    }
}
