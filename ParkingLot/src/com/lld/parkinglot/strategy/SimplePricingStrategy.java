package com.lld.parkinglot.strategy;

import com.lld.parkinglot.model.SlotType;

public class SimplePricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(SlotType slotType, long hours) {

        if (slotType == SlotType.SMALL) {
            return hours * 10;
        } else if (slotType == SlotType.MEDIUM) {
            return hours * 20;
        } else {
            return hours * 30;
        }
    }
}