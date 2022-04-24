package com.warehouse.superdevs.model.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class MarketEntranceDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dataSource;
    private String campaign;
    private Date daily;
    private int clicks;
    private int impressions;

    public MarketEntranceDAO(String dataSource, String campaign, Date daily, int clicks, int impressions) {
        this.dataSource = dataSource;
        this.campaign = campaign;
        this.daily = daily;
        this.clicks = clicks;
        this.impressions = impressions;
    }
    public MarketEntranceDAO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getDataSource() {
        return dataSource;
    }

    public String getCampaign() {
        return campaign;
    }

    public Date getDaily() {
        return daily;
    }

    public int getClicks() {
        return clicks;
    }

    public int getImpressions() {
        return impressions;
    }
}
