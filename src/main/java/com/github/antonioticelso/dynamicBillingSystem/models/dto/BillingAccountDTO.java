package com.github.antonioticelso.dynamicBillingSystem.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.antonioticelso.dynamicBillingSystem.models.ChargingRequest;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingAccountDTO {

    private String id;
    private String MSISDNRequest;
    private int serviceId;
    private double bucket1;
    private double bucket2;
    private double bucket3;
    private int counterA;
    private int counterB1;
    private int counterCTrue;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime counterD;
    private ChargingRequest chargingRequest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMSISDNRequest() {
        return MSISDNRequest;
    }

    public void setMSISDNRequest(String MSISDNRequest) {
        this.MSISDNRequest = MSISDNRequest;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public double getBucket1() {
        return bucket1;
    }

    public void setBucket1(double bucket1) {
        this.bucket1 = bucket1;
    }

    public double getBucket2() {
        return bucket2;
    }

    public void setBucket2(double bucket2) {
        this.bucket2 = bucket2;
    }

    public double getBucket3() {
        return bucket3;
    }

    public void setBucket3(double bucket3) {
        this.bucket3 = bucket3;
    }

    public int getCounterA() {
        return counterA;
    }

    public void setCounterA(int counterA) {
        this.counterA = counterA;
    }

    public int getCounterB1() {
        return counterB1;
    }

    public void setCounterB1(int counterB1) {
        this.counterB1 = counterB1;
    }

    public int getCounterCTrue() {
        return counterCTrue;
    }

    public void setCounterCTrue(int counterCTrue) {
        this.counterCTrue = counterCTrue;
    }

    public LocalDateTime getCounterD() {
        return counterD;
    }

    public void setCounterD(LocalDateTime counterD) {
        this.counterD = counterD;
    }

    public ChargingRequest getChargingRequest() {
        return chargingRequest;
    }

    public void setChargingRequest(ChargingRequest chargingRequest) {
        this.chargingRequest = chargingRequest;
    }

    public BillingAccountDTO() {
    }

}
