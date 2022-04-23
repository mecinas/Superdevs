package com.warehouse.superdevs;

import com.warehouse.superdevs.model.dao.MarketEntranceDAO;
import com.warehouse.superdevs.repository.MarketEntranceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class SuperdevsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(SuperdevsApplication.class, args);
		MarketEntranceRepository marketEntranceRepository =
				configurableApplicationContext.getBean(MarketEntranceRepository.class);
//		MarketEntranceDAO myEntrance = new MarketEntranceDAO("Google Ads", "Adventmarkt Touristik", new Date(), 7, 2213);
//		marketEntranceRepository.save(myEntrance);

	}

}
