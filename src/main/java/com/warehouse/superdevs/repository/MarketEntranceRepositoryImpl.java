package com.warehouse.superdevs.repository;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import com.warehouse.superdevs.model.mappers.MarketEntranceRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class MarketEntranceRepositoryImpl implements MarketEntranceRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MarketEntranceDAO> filterByDataSource(String dataSource){
        String query = String.format("SELECT * FROM MARKET_ENTRANCEDAO WHERE DATASOURCE %s", dataSource);
        return jdbcTemplate.query(query, new MarketEntranceRowMapper());
    }
}
