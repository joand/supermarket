package fr.joand.supermarket.core;

import fr.joand.supermarket.model.Basket;
import fr.joand.supermarket.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
class PricerService implements Pricer {
    private final Logger logger = LoggerFactory.getLogger(PricerService.class);

    @Override
    public double computePrice(Basket basket) {
        double totalPrice = 0;
        for (Map.Entry<Item, Long> entry : basket.getContent().entrySet()) {
            Item item = entry.getKey();
            Long occurrence = entry.getValue();
            totalPrice += computePrice(item, occurrence);
        }
        return totalPrice;
    }

    @Override
    public double computePrice(Item item, long occurrence) {
        logger.info("computePrice for item : {}, occurrence : {}", item, occurrence);

        double ndOfSpecialOffer = Math.floor(occurrence / item.getCurrentOccurence());
        logger.info("ndOfSpecialOffer : {}", ndOfSpecialOffer);

        long remainder = occurrence % item.getCurrentOccurence();
        logger.info("remainder : {}", remainder);

        return item.getPrice() * ndOfSpecialOffer * item.getChargedOccurence() + item.getPrice() * remainder;
    }
}
