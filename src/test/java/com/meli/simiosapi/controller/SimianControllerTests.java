package com.meli.simiosapi.controller;

import com.meli.simiosapi.contracts.request.SimianRequest;
import com.meli.simiosapi.exception.BadRequestException;
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

    private static final List<String> VALID_SIMIAN_DNA = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
    private static final List<String> VALID_HUMAN_DNA = Arrays.asList("CTGAGA", "CTATGC", "TAATGT", "AGAGAG", "CTCCTA", "TCACTG");
    private static final List<String> INVALID_DNA = Arrays.asList("CTGAGA", "CTATGC", "TAATGT", "AGAGAG", "CTCCTA");
    private SimianRequest VALID_SIMIAN_REQUEST = null;
    private SimianRequest VALID_HUMAN_REQUEST = null;
    private SimianRequest INVALID_REQUEST = null;

    @Mock
    private HistoricService service;

    @InjectMocks
    private SimianController simianController;

    @Before
    public void setUp(){
        VALID_SIMIAN_REQUEST = SimianRequest.builder()
                .dna(VALID_SIMIAN_DNA)
                .build();

        VALID_HUMAN_REQUEST = SimianRequest.builder()
                .dna(VALID_HUMAN_DNA)
                .build();

        INVALID_REQUEST = SimianRequest.builder()
                .dna(INVALID_DNA)
                .build();
    }

    @Test
    public void deveRetornarStatusConflictQuandoDnaExistirNaBase() {
        when(service.dnaExists(VALID_SIMIAN_DNA.toString())).thenReturn(true);
        Assert.assertEquals(HttpStatus.CONFLICT, simianController.create(VALID_SIMIAN_REQUEST).getStatusCode());
    }


    @Test
    public void deveRetornarStatusForbiddenQuandoDnaForHumanoEValido() {
        when(service.dnaExists(VALID_HUMAN_DNA.toString())).thenReturn(false);
        when(service.isSimian(VALID_HUMAN_DNA)).thenReturn(false);
        Assert.assertEquals(HttpStatus.FORBIDDEN, simianController.create(VALID_HUMAN_REQUEST).getStatusCode());
    }

    @Test(expected = BadRequestException.class)
    public void deveRetornarErroQuandoDnaForInvalido() {
        when(service.dnaExists(INVALID_DNA.toString())).thenReturn(false);
        when(service.isSimian(INVALID_DNA)).thenThrow(BadRequestException.class);
        simianController.create(INVALID_REQUEST);
    }

    @Test
    public void deveRetornarStatusOkQuandoDnaForSimianEValido() {
        when(service.dnaExists(VALID_SIMIAN_DNA.toString())).thenReturn(false);
        when(service.isSimian(VALID_SIMIAN_DNA)).thenReturn(true);
        Assert.assertEquals(HttpStatus.OK, simianController.create(VALID_SIMIAN_REQUEST).getStatusCode());
    }
}
