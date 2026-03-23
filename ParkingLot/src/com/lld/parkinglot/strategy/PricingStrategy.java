package com.lld.parkinglot.strategy;

import com.lld.parkinglot.model.SlotType;

public interface PricingStrategy {

    double calculatePrice(SlotType slotType, long hours);
}