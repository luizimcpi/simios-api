package com.meli.simiosapi.contracts.response;

import com.fasterxml.jackson.annotation.JsonAlias;

import static com.meli.simiosapi.contracts.response.StatsResponse.StatsResponseBuilder.aStatsResponse;

public class StatsResponse {

    @JsonAlias("count_mutant_dna")
    private Integer countMutantDna;
    @JsonAlias("count_human_dna")
    private Integer countHumanDna;
    private double ratio;

    public Integer getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(Integer countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public Integer getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(Integer countHumanDna) {
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


        public StatsResponse.StatsResponseBuilder countMutantDna(Integer countMutantDna) {
            statsResponse.setCountMutantDna(countMutantDna);
            return this;
        }

        public StatsResponse.StatsResponseBuilder countHumanDna(Integer countHumanDna) {
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
