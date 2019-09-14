package com.meli.simiosapi.service;

import java.util.List;

public interface HistoricService {

    boolean dnaExists(String dna);

    void save(String dna, String type);

    boolean isSimian(List<String> dna);

}
