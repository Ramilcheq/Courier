package com.ramil.courier.model;

public class Order {
    private Long ORD_ID;
    private String ORD_DATE;

    public Long getOrderId() {
        return ORD_ID;
    }

    public void setOrderId(Long orderId) {
        this.ORD_ID = orderId;
    }

    public String getORDER_DATE() {
        return ORD_DATE;
    }

    public void setORDER_DATE(String ORDER_DATE) {
        this.ORD_DATE = ORDER_DATE;
    }
}
