package com.github.antonioticelso.dynamicBillingSystem.services.impl;

import com.github.antonioticelso.dynamicBillingSystem.exception.BillingNotFoundException;
import com.github.antonioticelso.dynamicBillingSystem.models.BillingAccount;
import com.github.antonioticelso.dynamicBillingSystem.models.BillingAccountCheckOut;
import com.github.antonioticelso.dynamicBillingSystem.models.ChargingRequest;
import com.github.antonioticelso.dynamicBillingSystem.repositorys.BillingRepository;
import com.github.antonioticelso.dynamicBillingSystem.services.BillingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BillingServiceImp implements BillingService {

    private final BillingRepository repository;

    public BillingServiceImp(BillingRepository repository) {
        this.repository = repository;
    }
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<BillingAccount> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public BillingAccount findById(String id) {
        return repository.findById(id).orElseThrow(() -> new BillingNotFoundException(id));
    }

    @Override
    @Transactional
    public BillingAccount create(BillingAccount billingCreate) {
        String id = getUUID();
        billingCreate.setId(id);
        billingCreate.setCounterD(LocalDateTime.now());
        repository.save(billingCreate);

        return billingCreate;
    }

    @Override
    @Transactional
    public BillingAccount update(String id, BillingAccount billingCreate) {
        BillingAccount billing = findById(id);

        billing.setMSISDNRequest(billingCreate.getMSISDNRequest());
        billing.setServiceId(billingCreate.getServiceId());
        billing.setBucket1(billingCreate.getBucket1());
        billing.setBucket2(billingCreate.getBucket2());
        billing.setBucket3(billingCreate.getBucket3());
        billing.setCounterA(billingCreate.getCounterA());
        billing.setCounterB1(billingCreate.getCounterB1());
        billing.setCounterCTrue(billingCreate.getCounterCTrue());
        billing.setCounterD(billingCreate.getCounterD());
        billing.setChargingRequest(billingCreate.getChargingRequest());

        repository.save(billing);

        return billing;
    }

    @Override
    @Transactional
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);

    }

    @Override
    public BillingAccount checkOut(String id) {
        BillingAccount billing = findById(id);
        billing.setCounterD(LocalDateTime.now());
        billing.setBill(BillingAccountCheckOut.getBill(billing));
        repository.save(billing);

        return billing;
    }

}
