package com.meli.simiosapi.domain;

import javax.persistence.*;

import static com.meli.simiosapi.domain.Historic.HistoricBuilder.aHistoric;

@Entity
@Table(name = "tb_historic")
public class Historic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "ds_dna", updatable = false, nullable = false)
    private String dna;
    @Column(name = "type", updatable = false, nullable = false)
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDna() {
        return dna;
    }
    public void setDna(String dna) {
        this.dna = dna;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Historic{" +
                "id=" + id +
                ", dna='" + dna + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static final Historic.HistoricBuilder builder(){
        return aHistoric();
    }

    public static final class HistoricBuilder {
        private Historic historic;

        private HistoricBuilder() {
            historic = new Historic();
        }

        public static Historic.HistoricBuilder aHistoric() {
            return new Historic.HistoricBuilder();
        }

        public Historic.HistoricBuilder dna(String dna) {
            historic.setDna(dna);
            return this;
        }

        public Historic.HistoricBuilder type(String type) {
            historic.setType(type);
            return this;
        }

        public Historic build() {
            return historic;
        }
    }
}
