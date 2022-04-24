package com.warehouse.superdevs.repository;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketEntranceRepository extends CrudRepository<MarketEntranceDAO, Long> {

    //@Query("SELECT ME FROM MARKET_ENTRANCEDAO ME")
    List<MarketEntranceDAO> findByDataSource(String dataSource);
}
