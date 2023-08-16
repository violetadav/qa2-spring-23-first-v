package model;

public class Ball {
    private String brand;
    private int ballSize;
    private float weight;
    private String type;
    private String color;
    private String material;
    private String isUsedFor;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getBallSize() {
        return ballSize;
    }

    public void setBallSize(int ballSize) {
        this.ballSize = ballSize;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getIsUsedFor() {
        return isUsedFor;
    }

    public void setIsUsedFor(String isUsedFor) {
        this.isUsedFor = isUsedFor;
    }
}
