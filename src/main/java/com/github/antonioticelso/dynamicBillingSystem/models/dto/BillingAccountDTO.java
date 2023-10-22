package com.github.antonioticelso.dynamicBillingSystem.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class BillingAccountDTO {

    private String MSISDNRequest;
    private double bucket1;
    private double bucket2;
    private double bucket3;
    private int counterA;
    private int counterB1;
    private int counterCTrue;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime counterD;

}
