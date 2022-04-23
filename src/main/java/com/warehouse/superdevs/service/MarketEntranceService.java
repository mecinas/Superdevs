package com.warehouse.superdevs.service;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import com.warehouse.superdevs.model.pojo.MarketEntranceDTO;
import com.warehouse.superdevs.repository.MarketEntranceRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class MarketEntranceService {
    @Autowired
    private MarketEntranceRepository marketEntranceRepository;

    public List<MarketEntranceDAO> getMarketEntranceList() {
        Iterable<MarketEntranceDAO> iterableList = marketEntranceRepository.findAll();
        return Streamable.of(iterableList).toList();
    }

    public MarketEntranceDAO addMarketEntrance(MarketEntranceDTO dto) {
        try {
            Date entranceDate = new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDaily());
            MarketEntranceDAO marketEntranceDAO = new MarketEntranceDAO(dto.getDatasource(), dto.getCampaign(), entranceDate, dto.getClicks(), dto.getImpressions());
            return marketEntranceRepository.save(marketEntranceDAO);
        } catch (ParseException e) {
            return null;
        }

    }

    public void clearMarketEntrances() {
        marketEntranceRepository.deleteAll();
    }

    public boolean isCSV(MultipartFile file){
        String csvContentType = "text/csv";
        return csvContentType.equals(file.getContentType());
    }

    public boolean convertCSVToMarketEntrances(MultipartFile file){
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader,  CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            List<MarketEntranceDAO> marketEntranceDAOs = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : csvRecords){
                MarketEntranceDAO marketEntranceDAO = new MarketEntranceDAO(
                        csvRecord.get("Datasource"),
                        csvRecord.get("Campaign"),
                        new SimpleDateFormat("MM/dd/yy").parse(csvRecord.get("Daily")),
                Integer.parseInt(csvRecord.get("Clicks")),
                        Integer.parseInt(csvRecord.get("Impressions"))
                );
                marketEntranceDAOs.add(marketEntranceDAO);
            }
            marketEntranceRepository.saveAll(marketEntranceDAOs);
            return true;
        } catch (IOException | ParseException e ) {
            return false;
        }
    }
}
