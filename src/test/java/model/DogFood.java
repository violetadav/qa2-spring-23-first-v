package model;

public class DogFood {
    private String typeOfProduct;
    private String brand;
    private float weight;
    private String feedType;
    private String dogSize;
    private String qualityClass;
    private int numberOfPacksInABox;

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getDogSize() {
        return dogSize;
    }

    public void setDogSize(String dogSize) {
        this.dogSize = dogSize;
    }

    public String getQualityClass() {
        return qualityClass;
    }

    public void setQualityClass(String qualityClass) {
        this.qualityClass = qualityClass;
    }

    public int getNumberOfPacksInABox() {
        return numberOfPacksInABox;
    }

    public void setNumberOfPacksInABox(int numberOfPacksInABox) {
        this.numberOfPacksInABox = numberOfPacksInABox;
    }
}
