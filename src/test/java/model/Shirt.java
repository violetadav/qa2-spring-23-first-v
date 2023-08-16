package model;

public class Shirt {
    private String type;
    private String brand;
    private String collection;
    private String gender;
    private String color;
    private Character size;
    private float percentOfCotton;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Character getSize() {
        return size;
    }

    public void setSize(Character size) {
        this.size = size;
    }

    public float getPercentOfCotton() {
        return percentOfCotton;
    }

    public void setPercentOfCotton(float percentOfCotton) {
        this.percentOfCotton = percentOfCotton;
    }
}
