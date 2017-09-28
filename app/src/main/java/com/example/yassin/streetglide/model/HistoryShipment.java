package com.example.yassin.streetglide.model;

/**
 * Created by yassin on 7/16/17.
 */

public class HistoryShipment {
    private String sender_name;
    private String consignee_name;
    private String consignee_add;
    private String cosignee_number;
    private String consignee_status;
    private String consignee_cash;
    private String flagline;


    public HistoryShipment(String sender_name, String consignee_name, String consignee_add, String cosignee_number, String consignee_status, String consignee_cash,  String flagline) {
        this.sender_name = sender_name;
        this.consignee_name = consignee_name;
        this.consignee_add = consignee_add;
        this.cosignee_number = cosignee_number;
        this.consignee_status = consignee_status;
        this.consignee_cash = consignee_cash;
        this.flagline=flagline;
    }

    public String getSender_name() {
        return sender_name;
    }

    public String getConsignee_name() {
        return consignee_name;
    }

    public String getConsignee_add() {
        return consignee_add;
    }

    public String getCosignee_number() {
        return cosignee_number;
    }

    public String getConsignee_status() {
        return consignee_status;
    }

    public String getConsignee_cash() {
        return consignee_cash;
    }

    public String getFlagline() {
        return flagline;
    }
}
