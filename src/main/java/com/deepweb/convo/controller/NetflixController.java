package com.deepweb.convo.controller;

import com.deepweb.convo.entities.NetflixEntryModel;
import com.deepweb.convo.repository.NetflixEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NetflixController {

    @Autowired
    private NetflixEntryRepository netflixEntryRepository;

    @GetMapping("/findAll")
    public ResponseEntity<NetflixEntryModel> getAll(){
        return ResponseEntity.ok(netflixEntryRepository.findById(2345L).get());
    }
}
