package com.example.cafelegend.model;

public class Food {
    private String foodName;
    private String foodDesc;
    private int imageId;
    private int foodPrice;

    public Food(String foodName, int foodPrice, int imageId, String foodDesc) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.imageId = imageId;
        this.foodDesc = foodDesc;
    }

    public Food(String foodName, int foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public Food(String foodName, int foodPrice, int imageId) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.imageId = imageId;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
}
