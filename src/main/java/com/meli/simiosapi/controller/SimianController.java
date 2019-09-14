package com.meli.simiosapi.controller;

import com.meli.simiosapi.contracts.request.SimianRequest;
import com.meli.simiosapi.domain.Historic;
import com.meli.simiosapi.enuns.SpecieType;
import com.meli.simiosapi.service.HistoricService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simian")
public class SimianController {

    private static final Logger log = LoggerFactory.getLogger(SimianController.class);

    private final HistoricService service;

    @Autowired
    public SimianController(HistoricService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody SimianRequest request) {
        log.info("Saving historic with dna: " + request.getDna());

        if(service.dnaExists(request.getDna().toString())){
            log.info("Dna already exists: " + request.getDna());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if(!service.isSimian(request.getDna())){
            log.info("Saving human Dna: " + request.getDna());
            service.save(request.getDna().toString(), SpecieType.HUMAN.toString());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        log.info("Saving simian Dna: " + request.getDna());
        service.save(request.getDna().toString(), SpecieType.SIMIAN.toString());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
