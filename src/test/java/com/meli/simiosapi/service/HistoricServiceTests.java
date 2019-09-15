package com.meli.simiosapi.service;

import com.meli.simiosapi.domain.Historic;
import com.meli.simiosapi.enuns.SpecieType;
import com.meli.simiosapi.repository.HistoricRepository;
import com.meli.simiosapi.service.impl.HistoricServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HistoricServiceTests {

    private static final String VALID_SIMIAN_DNA = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG").toString();

    private static final List<Historic> VALID_HISTORIC_LIST = new ArrayList<>();

    private static final List<Historic> EMPTY_HISTORIC_LIST = new ArrayList<>();

    @Mock
    private HistoricRepository repository;

    @InjectMocks
    private HistoricServiceImpl service;

    @Test
    public void deveEncontrarDNAExistenteNaBaseComSucesso() {
        Historic historic = new Historic().builder()
                .dna("CTGAGA,CTATGC,TATTGT,AGAGGG,CCCCTA,TCACTG")
                .type(SpecieType.SIMIAN.toString())
                .build();

        VALID_HISTORIC_LIST.add(historic);
        when(repository.findByDna(VALID_SIMIAN_DNA)).thenReturn(VALID_HISTORIC_LIST);
        Assert.assertTrue(service.dnaExists(VALID_SIMIAN_DNA));
    }

    @Test
    public void deveRetornarFalsoQuandoDNANaoForEncontradoNaBase() {
        when(repository.findByDna(VALID_SIMIAN_DNA)).thenReturn(EMPTY_HISTORIC_LIST);
        Assert.assertFalse(service.dnaExists(VALID_SIMIAN_DNA));
    }
}
