package com.github.antonioticelso.dynamicBillingSystem.services;

import com.github.antonioticelso.dynamicBillingSystem.models.BillingAccount;

import java.util.List;

public interface BillingService {

    List<BillingAccount> findAll();

    BillingAccount findById(String id);

    BillingAccount create(BillingAccount parkingCreate);

    BillingAccount update(String id, BillingAccount parkingCreate);

    void delete(String id);

    BillingAccount checkOut(String id);
}
