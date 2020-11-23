package com.example.testtask;

public class item {
    private  String itemType;
    private  String priceFrom;
    private  String priceTo;
    private  String brand;

    public item setItemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

    public item setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
        return this;
    }

    public item setPriceTo(String priceTo) {
        this.priceTo = priceTo;
        return this;
    }

    public item setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getItemType() {
        return itemType;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public String getBrand() {
        return brand;
    }
}
