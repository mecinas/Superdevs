package com.warehouse.superdevs.model.dto;

public class MarketEntranceDTO {
    private String dataSource;
    private String campaign;
    private String daily;
    private int clicks;
    private int impressions;

    public MarketEntranceDTO(String dataSource, String campaign, String daily, int clicks, int impressions) {
        this.dataSource = dataSource;
        this.campaign = campaign;
        this.daily = daily;
        this.clicks = clicks;
        this.impressions = impressions;
    }

    public String getDataSource() {
        return dataSource;
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
