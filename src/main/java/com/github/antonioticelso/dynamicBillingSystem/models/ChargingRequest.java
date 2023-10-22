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
    private String MSISDNRequest;

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

    public String getMSISDNRequest() {
        return MSISDNRequest;
    }

    public void setMSISDNRequest(String MSISDNRequest) {
        this.MSISDNRequest = MSISDNRequest;
    }

    public void setRoaming(boolean roaming) {
        this.roaming = roaming;
    }


    public ChargingRequest() {
    }

    public ChargingRequest(String id, Timestamp entry, boolean roaming, String MSISDNRequest) {
        this.id = id;
        this.entry = entry;
        this.roaming = roaming;
        this.MSISDNRequest = MSISDNRequest;
    }

}
