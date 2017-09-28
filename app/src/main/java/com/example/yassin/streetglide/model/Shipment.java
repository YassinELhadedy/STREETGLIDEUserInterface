package com.example.yassin.streetglide.model;

/**
 * Created by yassin on 7/11/17.
 */

public class Shipment {
    private String cosignee_name;
    private String consignee_add;
    private int shipment_id;
    private String cost;
    private String flagline;

    public Shipment(String cosignee_name, String consignee_add, int shipment_id, String cost,String flagline) {
        this.cosignee_name = cosignee_name;
        this.consignee_add = consignee_add;
        this.shipment_id = shipment_id;
        this.cost = cost;
        this.flagline=flagline;
    }

    public String getFlagline() {
        return flagline;
    }

    public String getCosignee_name() {
        return cosignee_name;
    }

    public String getConsignee_add() {
        return consignee_add;
    }

    public int getShipment_id() {
        return shipment_id;
    }

    public String getCost() {
        return cost;
    }
}
