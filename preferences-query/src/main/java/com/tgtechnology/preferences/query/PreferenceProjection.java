package com.tgtechnology.preferences.query;

import com.tgtechnology.preferences.dto.PreferenceDTO;
import com.tgtechnology.preferences.events.PreferenceCreatedEvent;
import com.tgtechnology.preferences.events.PreferenceUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PreferenceProjection {

    private final Map<UUID, PreferenceDTO> customerPreferences = new HashMap<>(); // TODO: Repla with Redis cache

    @EventHandler
    public void on(PreferenceCreatedEvent preferenceCreatedEvent) {
        customerPreferences.put(preferenceCreatedEvent.getCustomerId(), new PreferenceDTO());
    }

    @EventHandler
    public void on(PreferenceUpdatedEvent preferenceUpdatedEvent) {
        customerPreferences.put(preferenceUpdatedEvent.getCustomerId(), preferenceUpdatedEvent.getPreferenceDTO());
    }

    @QueryHandler
    public PreferenceDTO handle(PreferenceQuery preferenceQuery) {
        return customerPreferences.get(preferenceQuery.getCustomerId());
    }
}