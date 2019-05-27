package fr.joand.supermarket;

import fr.joand.supermarket.core.Pricer;
import fr.joand.supermarket.model.Basket;
import fr.joand.supermarket.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;

@Profile("!test")
@Service
public class ApplicationRunner implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Autowired
    private Pricer pricer;

    @Override
    public void run(String... args) throws Exception {
        logger.info("build basket");
        Basket basket = new Basket();
        basket.getContent().put(Item.apple, Long.valueOf(4));
        basket.getContent().put(Item.orange, Long.valueOf(3));
        basket.getContent().put(Item.watermelon, Long.valueOf(5));

        logger.info("basket content : ");
        for (Map.Entry<Item, Long> entry : basket.getContent().entrySet()) {
            Item item = entry.getKey();
            Long occurence = entry.getValue();
            logger.info("{} {}(s)", occurence, item.name());
        }

        logger.info("compute basket price");
        double basketPrice = pricer.computePrice(basket);

        logger.info("basket price : {}£", basketPrice);
    }

}
