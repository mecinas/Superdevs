package com.warehouse.superdevs.model.pojo;

import java.util.Date;

public class MarketEntrance {
    private Long id;
    private String datasource;
    private String campaign;
    private Date daily;
    private int clicks;
    private int impressions;

    public MarketEntrance(String datasource, String campaign, Date daily, int clicks, int impressions) {
        this.datasource = datasource;
        this.campaign = campaign;
        this.daily = daily;
        this.clicks = clicks;
        this.impressions = impressions;
    }

    public Long getId() {
        return id;
    }

    public String getDatasource() {
        return datasource;
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
