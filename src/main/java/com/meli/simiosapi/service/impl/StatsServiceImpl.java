package com.meli.simiosapi.service.impl;

import com.meli.simiosapi.contracts.response.StatsResponse;
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
//        DecimalFormat df = new DecimalFormat("#.0");

        Integer countHumanDna = 100;
        Integer countMutantDna = 40;
        double ratio = countMutantDna / countHumanDna;
//        ratio = Double.parseDouble(df.format(ratio));
        StatsResponse reponse = StatsResponse.builder().countHumanDna(40).countMutantDna(100).ratio(ratio).build();
        return reponse;
    }
}
