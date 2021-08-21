package com.tgtechnology.preferences.commands;

import com.tgtechnology.preferences.dto.PreferenceDTO;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class UpdatePreferenceCommand {

    @TargetAggregateIdentifier
    private final UUID customerId;
    private final PreferenceDTO preferenceDTO;

    public UpdatePreferenceCommand(UUID customerId, PreferenceDTO preferenceDTO) {
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