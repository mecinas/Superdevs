package com.warehouse.superdevs.model.mappers;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import com.warehouse.superdevs.model.dto.MarketEntranceDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarketEntranceMapper {

    public static MarketEntranceDAO convertDTOtoDAO(MarketEntranceDTO marketEntranceDTO){
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(marketEntranceDTO.getDaily());
            return new MarketEntranceDAO(marketEntranceDTO.getDataSource(), marketEntranceDTO.getCampaign(),
                    date, marketEntranceDTO.getClicks(), marketEntranceDTO.getImpressions());
        } catch (ParseException e) {
            return null;
        }
    }
    public static MarketEntranceDTO convertDAOtoDTO(MarketEntranceDAO marketEntranceDAO){
        String date = new SimpleDateFormat("MM/dd/yy").format(marketEntranceDAO.getDaily());
        return new MarketEntranceDTO(marketEntranceDAO.getDataSource(), marketEntranceDAO.getCampaign(),
                    date, marketEntranceDAO.getClicks(), marketEntranceDAO.getImpressions());

    }

    public static List<MarketEntranceDTO> convertDAOListToDTOList(Iterable<MarketEntranceDAO> listOfMarketEntranceDAOs){
        List<MarketEntranceDTO> listOfMarketEntranceDTOs = new ArrayList<MarketEntranceDTO>();
        for(MarketEntranceDAO marketEntranceDAO : listOfMarketEntranceDAOs){
            MarketEntranceDTO newDTO = MarketEntranceMapper.convertDAOtoDTO(marketEntranceDAO);
            listOfMarketEntranceDTOs.add(newDTO);
        }
        return listOfMarketEntranceDTOs;

    }

}
