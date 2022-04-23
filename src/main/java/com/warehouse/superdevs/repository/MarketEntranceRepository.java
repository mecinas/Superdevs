package com.warehouse.superdevs.repository;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketEntranceRepository extends CrudRepository<MarketEntranceDAO, Long> {
}
