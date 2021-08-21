package com.tgtechnology.preferences.model;

import com.tgtechnology.preferences.commands.CreatePreferenceCommand;
import com.tgtechnology.preferences.commands.UpdatePreferenceCommand;
import com.tgtechnology.preferences.dto.PreferenceDTO;
import com.tgtechnology.preferences.events.PreferenceCreatedEvent;
import com.tgtechnology.preferences.events.PreferenceUpdatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class PreferenceAggregateTest {

    @Test
    public void testWhenCreatePreferenceCommand_ThenExpectPreferenceCreatedEvent() {
        var fixture = new AggregateTestFixture<>(PreferenceAggregate.class);
        var customerId = UUID.randomUUID();

        fixture.givenNoPriorActivity()
                .when(new CreatePreferenceCommand(customerId))
                .expectEvents(new PreferenceCreatedEvent(customerId));
    }

    @Test
    public void testWhenUpdatePreferenceCommand_ThenExpectPreferenceUpdatedEvent() {
        var fixture = new AggregateTestFixture<>(PreferenceAggregate.class);
        var customerId = UUID.randomUUID();
        var preferenceDTO = new PreferenceDTO(true, false, true);

        fixture.given(new PreferenceCreatedEvent(customerId))
                .when(new UpdatePreferenceCommand(customerId, preferenceDTO))
                .expectEvents(new PreferenceUpdatedEvent(customerId, preferenceDTO));
    }
}