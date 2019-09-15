package com.meli.simiosapi.contracts.request;

import java.util.List;

import static com.meli.simiosapi.contracts.request.SimianRequest.SimianRequestBuilder.aSimianRequest;

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

    @Override
    public String toString() {
        return "SimianRequest{" +
                "dna=" + dna +
                '}';
    }

    public static final SimianRequest.SimianRequestBuilder builder(){
        return aSimianRequest();
    }

    public static final class SimianRequestBuilder {
        private SimianRequest simianRequest;

        private SimianRequestBuilder() {
            simianRequest = new SimianRequest();
        }

        public static SimianRequest.SimianRequestBuilder aSimianRequest() {
            return new SimianRequest.SimianRequestBuilder();
        }

        public SimianRequest.SimianRequestBuilder dna(List<String> dna) {
            simianRequest.setDna(dna);
            return this;
        }

        public SimianRequest build() {
            return simianRequest;
        }
    }
}
