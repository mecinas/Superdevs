package com.warehouse.superdevs.agregate;

public class AgregateClicksByDataSource {

    private String DATA_SOURCE;
    private String CAMPAIGN;


    public void setDATA_SOURCE(String DATA_SOURCE) {
        this.DATA_SOURCE = DATA_SOURCE;
    }

    public void setCAMPAIGN(String CAMPAIGN) {
        this.CAMPAIGN = CAMPAIGN;
    }

    public String getDATA_SOURCE() {
        return DATA_SOURCE;
    }

    public String getCAMPAIGN() {
        return CAMPAIGN;
    }

    public AgregateClicksByDataSource(String DATA_SOURCE, String CAMPAIGN) {
        this.DATA_SOURCE = DATA_SOURCE;
        this.CAMPAIGN = CAMPAIGN;
    }
}
