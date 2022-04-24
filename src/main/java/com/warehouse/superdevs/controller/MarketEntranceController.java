package com.warehouse.superdevs.controller;

import com.warehouse.superdevs.model.dto.MarketEntranceDTO;
import com.warehouse.superdevs.service.MarketEntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/marketEntrance")
public class MarketEntranceController {
    @Autowired
    private MarketEntranceService marketEntranceService;
    @GetMapping
    public List getMarketEntranceList() {
        List someList = marketEntranceService.getMarketEntranceList();
        return someList;
    }

    @DeleteMapping
    public ResponseEntity deleteMarketEntrances() {
        marketEntranceService.clearMarketEntrances();
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity addUser(@RequestBody MarketEntranceDTO marketEntranceDTO) {
        if(marketEntranceService.addMarketEntrance(marketEntranceDTO) != null)
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/filter/dataSource")
    public List filterByDataSource(@RequestParam String name) {
        System.out.println("dataSource: " + name);
        return marketEntranceService.filterByDataSource(name);
    }

    @PostMapping("upload/csv")
    public ResponseEntity uploadCSV(@RequestParam MultipartFile file) {
        if(marketEntranceService.isCSV(file))
            if(marketEntranceService.bulkCSVIntoMarketEntrances(file))
                return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
