package com.meli.simiosapi.service.impl;

import com.meli.simiosapi.domain.Historic;
import com.meli.simiosapi.repository.HistoricRepository;
import com.meli.simiosapi.service.HistoricService;
import com.meli.simiosapi.utils.DnaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricServiceImpl implements HistoricService {

    private final HistoricRepository repository;

    @Autowired
    public HistoricServiceImpl(HistoricRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean dnaExists(String dna) {
        if(repository.findByDna(dna).size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public void save(String dna, String type) {
        Historic historic = new Historic().builder()
                .dna(dna)
                .type(type)
                .build();

        repository.save(historic);
    }

    @Override
    public boolean isSimian(List<String> dna) {
        String[] dnaArray = dna.toArray(new String[dna.size()]);
        return DnaUtils.isSimian(dnaArray);
    }
}
