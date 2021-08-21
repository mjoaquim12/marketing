package com.tgtechnology.preferences.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;
import java.util.UUID;

public class CreatePreferenceCommand {

    @TargetAggregateIdentifier
    private final UUID customerId;

    public CreatePreferenceCommand(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreatePreferenceCommand that = (CreatePreferenceCommand) o;

        return Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(customerId);
    }

    @Override
    public String toString() {
        return "CreateCustomerCommand{" +
                "customerId=" + customerId +
                '}';
    }
}