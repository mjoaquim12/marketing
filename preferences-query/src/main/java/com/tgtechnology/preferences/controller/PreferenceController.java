package com.tgtechnology.preferences.controller;

import com.tgtechnology.preferences.dto.PreferenceDTO;
import com.tgtechnology.preferences.query.PreferenceQuery;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class PreferenceController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/customer/{customer-id}/preferences")
    public CompletableFuture<PreferenceDTO> getPreferences(@PathVariable("customer-id") UUID customerId) {
        return queryGateway.query(new PreferenceQuery(customerId), PreferenceDTO.class);
    }
}