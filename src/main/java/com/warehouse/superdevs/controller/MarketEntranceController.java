package com.warehouse.superdevs.controller;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import com.warehouse.superdevs.model.pojo.MarketEntranceDTO;
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

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity addUser(@RequestBody MarketEntranceDTO marketEntranceDTO) {
        if(marketEntranceService.addMarketEntrance(marketEntranceDTO) != null)
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("upload/csv")
    public ResponseEntity uploadCSV(@RequestParam MultipartFile file) {
        if(marketEntranceService.isCSV(file))
            if(marketEntranceService.bulkCSVIntoMarketEntrances(file))
                return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
