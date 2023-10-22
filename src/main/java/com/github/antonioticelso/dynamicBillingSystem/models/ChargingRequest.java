package com.github.antonioticelso.dynamicBillingSystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class ChargingRequest {

    @Id
    private String id;
    private Timestamp entry;
    private boolean roaming;
    private String MSISDN;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getEntry() {
        return entry;
    }

    public void setEntry(Timestamp entry) {
        this.entry = entry;
    }

    public boolean isRoaming() {
        return roaming;
    }

    public void setRoaming(boolean roaming) {
        this.roaming = roaming;
    }

    public String getMSISDN() {
        return MSISDN;
    }

    public void setMSISDN(String MSISDN) {
        this.MSISDN = MSISDN;
    }

    public ChargingRequest() {
    }

    public ChargingRequest(String id, Timestamp entry, boolean roaming, String MSISDN) {
        this.id = id;
        this.entry = entry;
        this.roaming = roaming;
        this.MSISDN = MSISDN;
    }

}
