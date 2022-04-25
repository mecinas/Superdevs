package com.warehouse.superdevs;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import com.warehouse.superdevs.repository.MarketEntranceRepository;
import jakarta.persistence.Tuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@DataJpaTest
public class MarketEntranceRepositoryTests {

    @Autowired
    private MarketEntranceRepository marketEntranceRepository;

    @BeforeEach
    public void setUp() {
        marketEntranceRepository.deleteAll();
        Date date_1 = Date.from(LocalDate.of(2021,11,2).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date_2 = Date.from(LocalDate.of(2021,11,3).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date_3 = Date.from(LocalDate.of(2021,11,4).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date_4 = Date.from(LocalDate.of(2021,11,5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        MarketEntranceDAO marketEntranceDAO_1 = new MarketEntranceDAO("Facebook", "AI ads", date_1, 20, 231);
        MarketEntranceDAO marketEntranceDAO_2 = new MarketEntranceDAO("Facebook", "AI ads", date_2, 40, 123);
        MarketEntranceDAO marketEntranceDAO_3 = new MarketEntranceDAO("Facebook", "AI ads", date_3, 210, 1);
        MarketEntranceDAO marketEntranceDAO_4 = new MarketEntranceDAO("Facebook", "AI ads", date_4, 90, 13);

        marketEntranceRepository.save(marketEntranceDAO_1);
        marketEntranceRepository.save(marketEntranceDAO_2);
        marketEntranceRepository.save(marketEntranceDAO_3);
        marketEntranceRepository.save(marketEntranceDAO_4);
    }



    @Test
    public void saveMarketEntranceTest(){
        Date date = Date.from(LocalDate.of(2022,10,12).atStartOfDay(ZoneId.systemDefault()).toInstant());
        MarketEntranceDAO marketEntranceDAO_1 = new MarketEntranceDAO("Google", "AI ads", date, 20, 231);
        marketEntranceRepository.save(marketEntranceDAO_1);

        Assertions.assertEquals(marketEntranceDAO_1.getDataSource(), "Google");
        Assertions.assertEquals(marketEntranceDAO_1.getCampaign(), "AI ads");
        Assertions.assertEquals(marketEntranceDAO_1.getDaily(), date);
    }

    @Test
    public void findHighestClickTest(){
        MarketEntranceDAO marketEntranceDAO = marketEntranceRepository.findHighestClickDayForDataSourceCampaign("Facebook", "AI ads");

        Date date_3 = Date.from(LocalDate.of(2021,11,4).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Assertions.assertEquals(marketEntranceDAO.getClicks(), 210);
        Assertions.assertEquals(marketEntranceDAO.getDaily(), date_3);
    }

    @Test
    public void findHighestImpressionTest(){
        MarketEntranceDAO marketEntranceDAO = marketEntranceRepository.findHighestImpressionDayForDataSourceCampaign("Facebook", "AI ads");

        Date date_1 = Date.from(LocalDate.of(2021,11,2).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Assertions.assertEquals(marketEntranceDAO.getImpressions(), 231);
        Assertions.assertEquals(marketEntranceDAO.getDaily(), date_1);
    }

}
