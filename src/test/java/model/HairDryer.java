package model;

public class HairDryer {
    private String brand;
    private String model;
    private int power;
    private int numberOfNozzles;
    private float wireLength;
    private int tempControl;
    private int numberOfSpeeds;

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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getNumberOfNozzles() {
        return numberOfNozzles;
    }

    public void setNumberOfNozzles(int numberOfNozzles) {
        this.numberOfNozzles = numberOfNozzles;
    }

    public float getWireLength() {
        return wireLength;
    }

    public void setWireLength(float wireLength) {
        this.wireLength = wireLength;
    }

    public int getTempControl() {
        return tempControl;
    }

    public void setTempControl(int tempControl) {
        this.tempControl = tempControl;
    }

    public int getNumberOfSpeeds() {
        return numberOfSpeeds;
    }

    public void setNumberOfSpeeds(int numberOfSpeeds) {
        this.numberOfSpeeds = numberOfSpeeds;
    }

    public void printProductName(){
        System.out.println(brand + " " + model);
    }

    public void printTechnicalSpecifications(){
        System.out.println(power + "," + numberOfNozzles + "," + wireLength + "," + tempControl + "," + numberOfSpeeds);
    }
}
