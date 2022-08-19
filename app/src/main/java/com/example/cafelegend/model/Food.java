package com.example.cafelegend.model;

public class Food {
    private String foodId;
    private String foodName;
    private String foodDesc;
    private int imageId;
    private int foodPrice;

    public Food(String foodId, String foodName, int foodPrice, int imageId, String foodDesc) {
        this.foodId = foodId;
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

    public String getMenuDesc() {
        return foodDesc;
    }

    public void setMenuDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
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
