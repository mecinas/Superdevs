package com.warehouse.superdevs.repository;

import com.warehouse.superdevs.agregate.AgregateClicksByDataSource;
import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MarketEntranceRepository extends JpaRepository<MarketEntranceDAO, Long> {

    List<MarketEntranceDAO> findByDataSource(@Param("DATASOURCE") String dataSource);

    @Query(value = "SELECT RES.DATA_SOURCE, SUM(RES.CLICKS) FROM " +
            "(SELECT * FROM MARKET_ENTRANCEDAO ME WHERE DATA_SOURCE = :DATA_SOURCE AND DAILY BETWEEN :STARTDATE AND :ENDDATE) RES GROUP BY RES.DATA_SOURCE"
            , nativeQuery = true)
    List<Object> findClicksByDataSourceAndTime(@Param("DATA_SOURCE") String dataSource, @Param("STARTDATE") Date startDate, @Param("ENDDATE") Date endDate);
}
