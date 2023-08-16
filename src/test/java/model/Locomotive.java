package model;

public class Locomotive {
    private String brand;
    private String model;
    private float coalConsumptionTonsPer100Km;
    private float waterConsumptionCubicMetersPer100Km;

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

    public float getCoalConsumptionTonsPer100Km() {
        return coalConsumptionTonsPer100Km;
    }

    public void setCoalConsumptionTonsPer100Km(float coalConsumptionTonsPer100Km) {
        this.coalConsumptionTonsPer100Km = coalConsumptionTonsPer100Km;
    }

    public float getWaterConsumptionCubicMetersPer100Km() {
        return waterConsumptionCubicMetersPer100Km;
    }

    public void setWaterConsumptionCubicMetersPer100Km(float waterConsumptionCubicMetersPer100Km) {
        this.waterConsumptionCubicMetersPer100Km = waterConsumptionCubicMetersPer100Km;
    }

    public void printFullName(){
        System.out.println(brand + " " + model);
    }
}
