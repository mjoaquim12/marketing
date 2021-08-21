package com.tgtechnology.preferences.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class PreferenceCreatedEvent {

    @TargetAggregateIdentifier
    private UUID customerId;

    public PreferenceCreatedEvent(UUID customerId){
        this.customerId = customerId;
    }

    public UUID getCustomerId() {
        return customerId;
    }
}