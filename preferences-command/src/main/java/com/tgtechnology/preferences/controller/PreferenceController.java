package com.tgtechnology.preferences.controller;

import com.tgtechnology.preferences.commands.CreatePreferenceCommand;
import com.tgtechnology.preferences.commands.UpdatePreferenceCommand;
import com.tgtechnology.preferences.dto.PreferenceDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
public class PreferenceController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/register")
    public CompletableFuture<UUID> createCustomer() {
        return commandGateway.send(new CreatePreferenceCommand(UUID.randomUUID()));
    }

    @PostMapping("/customer/{customer-id}/preferences")
    public CompletableFuture<UUID> updatePreferences(@PathVariable("customer-id") UUID customerId, @RequestBody PreferenceDTO preferenceDTO) {
        return commandGateway.send(new UpdatePreferenceCommand(customerId, preferenceDTO));
    }
}