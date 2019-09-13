package com.meli.simiosapi.domain;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "tb_historic")
public class Historic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "ds_dna", updatable = false, nullable = false)
    private String[] dna;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "Historic{" +
                "id=" + id +
                ", dna=" + Arrays.toString(dna) +
                '}';
    }
}
