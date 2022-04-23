package com.warehouse.superdevs.service;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import com.warehouse.superdevs.model.pojo.MarketEntrance;
import com.warehouse.superdevs.repository.MarketEntranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MarketEntranceService {
    @Autowired
    private MarketEntranceRepository marketEntranceRepository;

    public List<MarketEntranceDAO> getMarketEntranceList() {
        Iterable<MarketEntranceDAO> iterableList = marketEntranceRepository.findAll();
        return Streamable.of(iterableList).toList();
    }

    public MarketEntranceDAO addMarketEntrance(MarketEntrance param) {
        MarketEntranceDAO marketEntranceDAO = new MarketEntranceDAO(param.getDatasource(), param.getCampaign(), param.getDaily(), param.getClicks(), param.getImpressions());
        return marketEntranceRepository.save(marketEntranceDAO);
    }
}
