package com.warehouse.superdevs.repository;

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

    @Query(value = "SELECT * FROM MARKET_ENTRANCEDAO ME WHERE ME.DATA_SOURCE = :DATASOURCE AND DAILY BETWEEN :STARTDATE AND :ENDDATE", nativeQuery = true)
    List<MarketEntranceDAO> findClicksByDataSourceAndTime(@Param("DATASOURCE") String dataSource,
                                                          @Param("STARTDATE") Date startDate, @Param("ENDDATE") Date endDate);
}
