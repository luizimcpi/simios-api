package com.meli.simiosapi.service.impl;

import com.meli.simiosapi.contracts.response.StatsResponse;
import com.meli.simiosapi.enuns.SpecieType;
import com.meli.simiosapi.repository.HistoricRepository;
import com.meli.simiosapi.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class StatsServiceImpl implements StatsService {

    private HistoricRepository repository;

    @Autowired
    public StatsServiceImpl(HistoricRepository repository) {
        this.repository = repository;
    }

    @Override
    public StatsResponse getStats() {
        Long countHumanDna = repository.countByType(SpecieType.HUMAN.toString());
        Long countMutantDna = repository.countByType(SpecieType.SIMIAN.toString());
        double ratio = countMutantDna / countHumanDna;

        StatsResponse reponse = StatsResponse.builder()
                .countHumanDna(countHumanDna)
                .countMutantDna(countMutantDna)
                .ratio(ratio).build();

        return reponse;
    }
}
