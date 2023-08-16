package model;

public class Car {
    private String brand;
    private String model;
    private float fuelConsumptionLitersPer100Km;

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

    public float getFuelConsumptionLitersPer100Km() {
        return fuelConsumptionLitersPer100Km;
    }

    public void setFuelConsumptionLitersPer100Km(float fuelConsumptionLitersPer100Km) {
        this.fuelConsumptionLitersPer100Km = fuelConsumptionLitersPer100Km;
    }

    public void printFullName(){
        System.out.println(brand + " " + model);
    }
}
