package com.warehouse.superdevs.service;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import com.warehouse.superdevs.model.pojo.MarketEntrance;
import com.warehouse.superdevs.repository.MarketEntranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MarketEntranceService {
    @Autowired
    private MarketEntranceRepository marketEntranceRepository;

    public Iterable<MarketEntranceDAO> getMarketEntranceList() {
        return marketEntranceRepository.findAll();
    }

    public MarketEntranceDAO addMarketEntrance(MarketEntrance param) {
        MarketEntranceDAO marketEntranceDAO = new MarketEntranceDAO(param.getDatasource(), param.getCampaign(), param.getDaily(), param.getClicks(), param.getImpressions());
        return marketEntranceRepository.save(marketEntranceDAO);
    }
}
