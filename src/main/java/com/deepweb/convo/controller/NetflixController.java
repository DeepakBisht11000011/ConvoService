package com.deepweb.convo.controller;

import com.deepweb.convo.entities.NetflixEntryModel;
import com.deepweb.convo.service.NetflixService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Netflix Controller", description = "Contains basic netflix APIs")
@RequestMapping("/home")
public class NetflixController {

    @Autowired
    private NetflixService netflixService;


    @GetMapping(value="/findAll",produces = "application/json")
    @Operation(
            summary = "Fetch all records",
            description = "fetches all shows from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<List<NetflixEntryModel>> getAll(@RequestParam final Integer pageNo) {
        return ResponseEntity.ok(netflixService.findAllRecordsPaginated(pageNo));
    }

    @GetMapping(value="/findByGenre",produces = "application/json")
    public ResponseEntity<List<NetflixEntryModel>> findByGenre(@RequestParam final String gener, @RequestParam Integer pageNo) {
        return ResponseEntity.ok(netflixService.findByGenre(gener, pageNo));
    }

    @GetMapping(value="/search",produces = "application/json")
    public ResponseEntity<List<NetflixEntryModel>> search(@RequestParam final String param1, @RequestParam final String param2, @RequestParam Integer pageNo) {
        return ResponseEntity.ok(netflixService.search(param1, param2, pageNo));
    }
}
