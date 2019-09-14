package com.meli.simiosapi.contracts.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.meli.simiosapi.contracts.response.StatsResponse.StatsResponseBuilder.aStatsResponse;

public class StatsResponse {

    @JsonProperty("count_mutant_dna")
    private Long countMutantDna;
    @JsonProperty("count_human_dna")
    private Long countHumanDna;
    private double ratio;

    public Long getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(Long countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public Long getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(Long countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "StatsResponse{" +
                "countMutantDna=" + countMutantDna +
                ", countHumanDna=" + countHumanDna +
                ", ratio=" + ratio +
                '}';
    }

    public static final StatsResponse.StatsResponseBuilder builder(){
        return aStatsResponse();
    }

    public static final class StatsResponseBuilder {
        private StatsResponse statsResponse;

        private StatsResponseBuilder() {
            statsResponse = new StatsResponse();
        }

        public static StatsResponse.StatsResponseBuilder aStatsResponse() {
            return new StatsResponse.StatsResponseBuilder();
        }


        public StatsResponse.StatsResponseBuilder countMutantDna(Long countMutantDna) {
            statsResponse.setCountMutantDna(countMutantDna);
            return this;
        }

        public StatsResponse.StatsResponseBuilder countHumanDna(Long countHumanDna) {
            statsResponse.setCountHumanDna(countHumanDna);
            return this;
        }

        public StatsResponse.StatsResponseBuilder ratio(double ratio) {
            statsResponse.setRatio(ratio);
            return this;
        }


        public StatsResponse build() {
            return statsResponse;
        }
    }
}
