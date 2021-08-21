package com.tgtechnology.preferences.query;

import java.util.UUID;

public class PreferenceQuery {

    private final UUID customerId;

    public PreferenceQuery(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getCustomerId() {
        return customerId;
    }
}