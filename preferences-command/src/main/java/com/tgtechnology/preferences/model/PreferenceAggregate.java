package com.tgtechnology.preferences.model;

import com.tgtechnology.preferences.commands.CreatePreferenceCommand;
import com.tgtechnology.preferences.commands.UpdatePreferenceCommand;
import com.tgtechnology.preferences.dto.PreferenceDTO;
import com.tgtechnology.preferences.events.PreferenceCreatedEvent;
import com.tgtechnology.preferences.events.PreferenceUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class PreferenceAggregate {

    @AggregateIdentifier
    private UUID customerId;
    private PreferenceDTO preferenceDTO;

    private PreferenceAggregate() {
        // Required for Axon to build a default Aggregate prior to Event Sourcing
    }

    public PreferenceDTO getPreferenceDTO() {
        return preferenceDTO;
    }

    @CommandHandler
    public PreferenceAggregate(CreatePreferenceCommand createPreferenceCommand) {
        apply(new PreferenceCreatedEvent(createPreferenceCommand.getCustomerId()));
    }

    @CommandHandler
    public void handle(UpdatePreferenceCommand updatePreferenceCommand) {
        apply(new PreferenceUpdatedEvent(updatePreferenceCommand.getCustomerId(), updatePreferenceCommand.getPreferenceDTO()));
    }

    @EventHandler
    public void on(PreferenceCreatedEvent preferenceCreatedEvent) {
        this.customerId = preferenceCreatedEvent.getCustomerId();
        this.preferenceDTO = new PreferenceDTO();
    }

    @EventHandler
    public void on(PreferenceUpdatedEvent preferenceUpdatedEvent) {
        this.customerId = preferenceUpdatedEvent.getCustomerId();
        this.preferenceDTO = preferenceUpdatedEvent.getPreferenceDTO();
    }
}