package com.github.antonioticelso.dynamicBillingSystem.repositorys;

import com.github.antonioticelso.dynamicBillingSystem.models.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<BillingAccount, String> {
}
