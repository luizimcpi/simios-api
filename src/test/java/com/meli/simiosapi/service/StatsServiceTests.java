package com.meli.simiosapi.service;

import com.meli.simiosapi.enuns.SpecieType;
import com.meli.simiosapi.exception.BadRequestException;
import com.meli.simiosapi.repository.HistoricRepository;
import com.meli.simiosapi.service.impl.StatsServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatsServiceTests {


    @Mock
    private HistoricRepository repository;

    @InjectMocks
    private StatsServiceImpl service;

    @Test(expected = BadRequestException.class)
    public void deveRetornarErroQuandoBaseNaoPossuirHumanosSuficiente() {
        when(repository.countByType(SpecieType.HUMAN.toString())).thenReturn(new Long(0));
        when(repository.countByType(SpecieType.SIMIAN.toString())).thenReturn(new Long(1));
        service.getStats();
    }

    @Test
    public void deveRetornarEstatisticasComSucessoQuandoBaseEstiverPreenchida() {
        when(repository.countByType(SpecieType.HUMAN.toString())).thenReturn(new Long(100));
        when(repository.countByType(SpecieType.SIMIAN.toString())).thenReturn(new Long(40));
        Assert.assertNotNull(service.getStats());
        Assert.assertTrue(0.4 == service.getStats().getRatio());
    }

}
