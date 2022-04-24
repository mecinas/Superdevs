package com.warehouse.superdevs.model.mappers;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarketEntranceRowMapper implements RowMapper<MarketEntranceDAO> {
    @Override
    public MarketEntranceDAO mapRow(ResultSet rs, int rowNum) throws SQLException {
        MarketEntranceDAO marketEntranceDTO = new MarketEntranceDAO(rs.getString("DATASOURCE"), rs.getString("CAMPAIGN"),
                rs.getDate("DAILY"), rs.getInt("CLICKS"), rs.getInt("IMPRESSIONS"));
        return marketEntranceDTO;
    }
}
