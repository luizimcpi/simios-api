package com.meli.simiosapi.controller;

import com.meli.simiosapi.contracts.SimianRequest;
import com.meli.simiosapi.domain.Historic;
import com.meli.simiosapi.repository.HistoricRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/simian")
public class SimianController {

    private static final Logger log = LoggerFactory.getLogger(SimianController.class);

    private final HistoricRepository repository;

    @Autowired
    public SimianController(HistoricRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(SimianRequest request) {
        Historic historic = new Historic();
//        String[] dna = request.getDna().toArray(new String[request.getDna().size()]);
        String[] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGGGGG", "CCCCTA", "TCACTG"};
//        historic.setId(1L);
        historic.setDna(dna);
        log.info("Saving historic with dna: " + historic.getDna());

        if(repository.findAll().size() > 0){
            Optional<Historic> optionalHistoric = repository.findAll()
                    .stream()
                    .filter(h -> Arrays.equals(h.getDna(), historic.getDna()))
                    .findFirst();

            if(optionalHistoric.isPresent()){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

        }

        return ResponseEntity.ok(repository.save(historic));
    }

}
