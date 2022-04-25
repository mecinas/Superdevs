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


    @Query(value = "SELECT RES.DATA_SOURCE, SUM(RES.CLICKS) FROM " +
            "(SELECT * FROM MARKET_ENTRANCEDAO ME WHERE ME.DAILY BETWEEN :STARTDATE AND :ENDDATE) RES " +
            "GROUP BY RES.DATA_SOURCE"
            , nativeQuery = true)
    List<Object> findClicksByDataSourceAndDateRange(@Param("STARTDATE") Date startDate, @Param("ENDDATE") Date endDate);

    @Query(value = "SELECT RES.DATA_SOURCE, SUM(RES.CLICKS) FROM " +
            "(SELECT * FROM MARKET_ENTRANCEDAO ME WHERE ME.DATA_SOURCE = :DATA_SOURCE AND ME.DAILY BETWEEN :STARTDATE AND :ENDDATE) RES " +
            "GROUP BY RES.DATA_SOURCE"
            , nativeQuery = true)
    List<Object> findClicksByDataSourceAndDateRange(@Param("DATA_SOURCE") String dataSource, @Param("STARTDATE") Date startDate, @Param("ENDDATE") Date endDate);

    @Query(value = "SELECT RES.CAMPAIGN, SUM(RES.CLICKS) FROM " +
            "(SELECT * FROM MARKET_ENTRANCEDAO ME WHERE ME.CAMPAIGN = :CAMPAIGN AND ME.DAILY BETWEEN :STARTDATE AND :ENDDATE) RES " +
            "GROUP BY RES.CAMPAIGN"
            , nativeQuery = true)
    List<Object> findClicksByCampaignAndDataRange(@Param("CAMPAIGN") String campaign, @Param("STARTDATE") Date startDate, @Param("ENDDATE") Date endDate);

    @Query(value = "SELECT RES.CAMPAIGN, SUM(RES.CLICKS) FROM " +
            "(SELECT * FROM MARKET_ENTRANCEDAO ME WHERE ME.DAILY BETWEEN :STARTDATE AND :ENDDATE) RES " +
            "GROUP BY RES.CAMPAIGN"
            , nativeQuery = true)
    List<Object> findClicksByCampaignAndDataRange(@Param("STARTDATE") Date startDate, @Param("ENDDATE") Date endDate);

    @Query(value = "SELECT RES.DATA_SOURCE, RES.CAMPAIGN, SUM(RES.CLICKS) FROM " +
            "(SELECT * FROM MARKET_ENTRANCEDAO ME WHERE ME.DATA_SOURCE = :DATA_SOURCE AND ME.CAMPAIGN = :CAMPAIGN AND ME.DAILY BETWEEN :STARTDATE AND :ENDDATE) RES " +
            "GROUP BY RES.DATA_SOURCE, RES.CAMPAIGN"
            , nativeQuery = true)
    List<Object> findClicksByDataSourceCampaignAndDateRange(@Param("DATA_SOURCE") String dataSource, @Param("CAMPAIGN") String campaign,
                                                            @Param("STARTDATE") Date startDate, @Param("ENDDATE") Date endDate);

    @Query(value = "SELECT RES.DATA_SOURCE, RES.CAMPAIGN, SUM(RES.CLICKS) FROM " +
            "(SELECT * FROM MARKET_ENTRANCEDAO ME WHERE ME.DAILY BETWEEN :STARTDATE AND :ENDDATE) RES " +
            "GROUP BY RES.DATA_SOURCE, RES.CAMPAIGN"
            , nativeQuery = true)
    List<Object> findClicksByDataSourceCampaignAndDateRange(@Param("STARTDATE") Date startDate, @Param("ENDDATE") Date endDate);

    @Query(value = "SELECT RES.DATA_SOURCE, RES.CAMPAIGN, AVG(RES.CLICKS) FROM MARKET_ENTRANCEDAO RES " +
            "GROUP BY RES.DATA_SOURCE, RES.CAMPAIGN"
            , nativeQuery = true)
    List<Object> findClickThroughRateByDataSourceAndCampaign();

    @Query(value = "SELECT RES.DATA_SOURCE, RES.CAMPAIGN, AVG(RES.CLICKS) FROM " +
            "(SELECT * FROM MARKET_ENTRANCEDAO ME WHERE ME.DATA_SOURCE = :DATA_SOURCE AND ME.CAMPAIGN = :CAMPAIGN) RES " +
            "GROUP BY RES.DATA_SOURCE, RES.CAMPAIGN"
            , nativeQuery = true)
    List<Object> findClickThroughRateByDataSourceAndCampaign(@Param("DATA_SOURCE") String dataSource, @Param("CAMPAIGN") String campaign);

    @Query(value = "SELECT RES.DATA_SOURCE, RES.CAMPAIGN, AVG(RES.IMPRESSIONS) FROM MARKET_ENTRANCEDAO RES " +
            "GROUP BY RES.DATA_SOURCE, RES.CAMPAIGN"
            , nativeQuery = true)
    List<Object> findImpressionThroughRateByDataSourceAndCampaign();

    @Query(value = "SELECT RES.DATA_SOURCE, RES.CAMPAIGN, AVG(RES.IMPRESSIONS) FROM " +
            "(SELECT * FROM MARKET_ENTRANCEDAO ME WHERE ME.DATA_SOURCE = :DATA_SOURCE AND ME.CAMPAIGN = :CAMPAIGN) RES " +
            "GROUP BY RES.DATA_SOURCE, RES.CAMPAIGN"
            , nativeQuery = true)
    List<Object> findImpressionThroughRateByDataSourceAndCampaign(@Param("DATA_SOURCE") String dataSource, @Param("CAMPAIGN") String campaign);
}
