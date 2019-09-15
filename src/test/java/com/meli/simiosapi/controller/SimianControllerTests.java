package com.meli.simiosapi.controller;

import com.meli.simiosapi.contracts.request.SimianRequest;
import com.meli.simiosapi.service.HistoricService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimianControllerTests {

    private static final List<String> VALID_DNA = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
    private SimianRequest VALID_SIMIAN_REQUEST = null;

    @Mock
    private HistoricService service;

    @InjectMocks
    private SimianController simianController;

    @Before
    public void setUp(){
        VALID_SIMIAN_REQUEST = SimianRequest.builder()
                .dna(VALID_DNA)
                .build();
    }

    @Test
    public void deveRetornarStatusConflictQuandoDnaExistirNaBase() {
        when(service.dnaExists(VALID_DNA.toString())).thenReturn(true);
        Assert.assertEquals(HttpStatus.CONFLICT, simianController.create(VALID_SIMIAN_REQUEST).getStatusCode());
    }
}
