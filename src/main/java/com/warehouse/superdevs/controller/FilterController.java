package com.warehouse.superdevs.controller;

import com.warehouse.superdevs.model.dto.MarketEntranceDTO;
import com.warehouse.superdevs.service.MarketEntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filter")
public class FilterController {
    @Autowired
    private MarketEntranceService marketEntranceService;

    @GetMapping(value = "/dataSource")
    public ResponseEntity<List> filterByDataSource(@RequestParam String dataSource) {
        return new ResponseEntity<>(marketEntranceService.filterByDataSource(dataSource), HttpStatus.OK);
    }


    @GetMapping(value = "/clicksDataSourceDataRange")
    public ResponseEntity<List> filterDataRangeForClicksWithDataSource(@RequestParam Optional<String> dataSource, @RequestParam String startDate, @RequestParam String endDate) {
        if(dataSource.equals(Optional.empty()))
            return new ResponseEntity<>(marketEntranceService.clicksFromDataSourceAndTime(startDate, endDate), HttpStatus.OK);
        return new ResponseEntity<>(marketEntranceService.clicksFromDataSourceAndTime(dataSource.get(), startDate, endDate), HttpStatus.OK);
    }


    @GetMapping(value = "/clickThroughRateByDataSourceAndCampaign")
    public ResponseEntity<List> filterClickThroughRateByDataSourceAndCampaign(@RequestParam Optional<String> dataSource, @RequestParam Optional<String> campaign) {
        if(dataSource.equals(Optional.empty()) || campaign.equals(Optional.empty()))
            return new ResponseEntity<>(marketEntranceService.findClickThroughRateByDataSourceAndCampaign(), HttpStatus.OK);
        return new ResponseEntity<>(marketEntranceService.findClickThroughRateByDataSourceAndCampaign(dataSource.get(), campaign.get()), HttpStatus.OK);
    }

}
