package com.github.antonioticelso.dynamicBillingSystem.repositorys;

import com.github.antonioticelso.dynamicBillingSystem.models.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<BillingAccount, String> {
}
