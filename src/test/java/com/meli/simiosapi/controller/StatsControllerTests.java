package com.meli.simiosapi.controller;

import com.meli.simiosapi.contracts.response.StatsResponse;
import com.meli.simiosapi.service.StatsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatsControllerTests {

    private StatsResponse VALID_RESPONSE = StatsResponse.builder()
            .countHumanDna(100L)
            .countMutantDna(40L)
            .ratio(0.4)
            .build();

    @Mock
    private StatsService service;

    @InjectMocks
    private StatsController statsController;


    @Test
    public void deveRetornarStatusOkQuandoBasePossuirRegistros() {
        when(service.getStats()).thenReturn(VALID_RESPONSE);
        Assert.assertEquals(HttpStatus.OK, statsController.getStats().getStatusCode());
    }
}
