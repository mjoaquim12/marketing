package com.tgtechnology.preferences.events;

import com.tgtechnology.preferences.dto.PreferenceDTO;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class PreferenceUpdatedEvent {

    @TargetAggregateIdentifier
    private UUID customerId;
    private PreferenceDTO preferenceDTO;

    public PreferenceUpdatedEvent(UUID customerId, PreferenceDTO preferenceDTO) {
        this.customerId = customerId;
        this.preferenceDTO = preferenceDTO;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public PreferenceDTO getPreferenceDTO() {
        return preferenceDTO;
    }
}