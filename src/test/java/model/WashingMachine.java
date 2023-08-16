package model;

public class WashingMachine {
    private String brand;
    private String model;
    private Character energyEfficiencyClass;
    private int washingCapacity;
    private Character spinClass;
    private float waterConsumption;
    private int noiseLevel;

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

    public Character getEnergyEfficiencyClass() {
        return energyEfficiencyClass;
    }

    public void setEnergyEfficiencyClass(Character energyEfficiencyClass) {
        this.energyEfficiencyClass = energyEfficiencyClass;
    }

    public int getWashingCapacity() {
        return washingCapacity;
    }

    public void setWashingCapacity(int washingCapacity) {
        this.washingCapacity = washingCapacity;
    }

    public Character getSpinClass() {
        return spinClass;
    }

    public void setSpinClass(Character spinClass) {
        this.spinClass = spinClass;
    }

    public float getWaterConsumption() {
        return waterConsumption;
    }

    public void setWaterConsumption(float waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    public int getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }
}
