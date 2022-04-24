package com.warehouse.superdevs.model.pojo;

public class MarketEntranceDTO {
    private String datasource;
    private String campaign;
    private String daily;
    private int clicks;
    private int impressions;

    public MarketEntranceDTO(String datasource, String campaign, String daily, int clicks, int impressions) {
        this.datasource = datasource;
        this.campaign = campaign;
        this.daily = daily;
        this.clicks = clicks;
        this.impressions = impressions;
    }

    public String getDatasource() {
        return datasource;
    }

    public String getCampaign() {
        return campaign;
    }

    public String getDaily() {
        return daily;
    }

    public int getClicks() {
        return clicks;
    }

    public int getImpressions() {
        return impressions;
    }
}
