package com.ailtonluiz.stock.domain.model;

public enum StatusOrder {


    INSSUED("Delivery"),
    BUDGET("Budget"),
    CANCELLED("Cancelled"),
    FINISHED("Finished");


    private String description;

    StatusOrder(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
