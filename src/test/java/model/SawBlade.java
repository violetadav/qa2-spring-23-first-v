package model;

public class SawBlade {
    private int diameter;
    private float thickness;
    private float weight;
    private int numberOfTeeth;
    private String material;
    private int toothAngle;
    private float cuttingThickness;

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public void setNumberOfTeeth(int numberOfTeeth) {
        this.numberOfTeeth = numberOfTeeth;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getToothAngle() {
        return toothAngle;
    }

    public void setToothAngle(int toothAngle) {
        this.toothAngle = toothAngle;
    }

    public float getCuttingThickness() {
        return cuttingThickness;
    }

    public void setCuttingThickness(float cuttingThickness) {
        this.cuttingThickness = cuttingThickness;
    }
}
