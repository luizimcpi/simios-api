package com.meli.simiosapi.contracts;

import java.util.List;

public class SimianRequest {

    private List<String> dna;

    public SimianRequest() {
    }

    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }
}
