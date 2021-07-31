package com.ailtonluiz.stock.domain.model;

public enum StatusPurchase {


    DELIVERY("Delivery"),
    BUDGET("Budget"),
    PENDING("Merchandise unfit for use"),
    CANCELLED("Cancelled");

    private String description;

    StatusPurchase(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
