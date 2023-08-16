package model;

public class AirPlane {
    private String brand;
    private String model;
    private float aviationFuelConsumptionKgPer1hour;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getAviationFuelConsumptionKgPer1hour() {
        return aviationFuelConsumptionKgPer1hour;
    }

    public void setAviationFuelConsumptionKgPer1hour(float aviationFuelConsumptionKgPer1hour) {
        this.aviationFuelConsumptionKgPer1hour = aviationFuelConsumptionKgPer1hour;
    }

    public void printFullName(){
        System.out.println(brand + " " + model);

    }
}
