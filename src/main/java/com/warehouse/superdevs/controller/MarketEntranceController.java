package com.warehouse.superdevs.controller;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import com.warehouse.superdevs.model.pojo.MarketEntrance;
import com.warehouse.superdevs.service.MarketEntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class MarketEntranceController {
    @Autowired
    private MarketEntranceService marketEntranceService;
    @GetMapping
    public ResponseEntity getMarketEntranceList() {
        List someList = marketEntranceService.getMarketEntranceList();
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping
    public MarketEntranceDAO addUser(@RequestBody MarketEntrance marketEntrance) {
        return marketEntranceService.addMarketEntrance(marketEntrance);
    }
}
