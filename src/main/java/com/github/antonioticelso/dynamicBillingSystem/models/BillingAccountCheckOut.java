package com.github.antonioticelso.dynamicBillingSystem.models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BillingAccountCheckOut {
    public static final int ONE_HOUR = 60;
    public static final int TWENTY_FOUR_HOUR = 24 * ONE_HOUR;
    public static final double ONE_HOUR_LOCAL_VALUE = 1.00;
    public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
    public static final double DAY_VALUE = 50.00;

    public static Double getBill(BillingAccount billing) {
        return getBill(billing.getCounterD(), billing.getCounterD());
    }

    private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
        long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);
        double bill = 0.0;

        if (minutes <= ONE_HOUR) {
            return ONE_HOUR_LOCAL_VALUE;
        }

        if (minutes <= TWENTY_FOUR_HOUR) {
            bill = ONE_HOUR_LOCAL_VALUE;
            int hours = (int) (minutes / ONE_HOUR);
            for (int i = 0; i < hours; i++) {
                bill += ADDITIONAL_PER_HOUR_VALUE;
            }
            return bill;
        }

        int days = (int) (minutes / TWENTY_FOUR_HOUR);
        for (int i = 0; i < days; i++) {
            bill+=DAY_VALUE;
        }

        return bill;

    }

}
