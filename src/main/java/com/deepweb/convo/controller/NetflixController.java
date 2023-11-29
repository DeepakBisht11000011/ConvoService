package com.deepweb.convo.controller;

import com.deepweb.convo.entities.NetflixEntryModel;
import com.deepweb.convo.repository.NetflixEntryRepository;
import com.deepweb.convo.service.NetflixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NetflixController {

    @Autowired
    private NetflixService netflixService;

    @GetMapping("/findAll")
    public ResponseEntity<List<NetflixEntryModel>> getAll(@RequestParam final Integer pageNo) {
        return ResponseEntity.ok(netflixService.findAllRecordsPaginated(pageNo));
    }

    @GetMapping("/findByGenre")
    public ResponseEntity<List<NetflixEntryModel>> findByGenre(@RequestParam final String gener, @RequestParam Integer pageNo) {
        return ResponseEntity.ok(netflixService.findByGenre(gener, pageNo));
    }

    @GetMapping("/search")
    public ResponseEntity<List<NetflixEntryModel>> search(@RequestParam final String param1, @RequestParam final String param2, @RequestParam Integer pageNo) {
        return ResponseEntity.ok(netflixService.search(param1, param2, pageNo));
    }
}
