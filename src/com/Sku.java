package com;

/**
 * Created by ananmoha
 * Date: 2/24/2015
 * Time: 8:39 PM
 * Product details
 */
public class Sku {
    private String skuName;
    private int availableCount;
    private int price;

    public Sku(String skuName, int availableCount, int price) {
        this.skuName = skuName;
        this.availableCount = availableCount;
        this.price = price;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
