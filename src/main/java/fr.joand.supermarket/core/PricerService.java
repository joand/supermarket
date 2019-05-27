package fr.joand.supermarket.core;

import fr.joand.supermarket.model.Basket;
import fr.joand.supermarket.model.Item;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
class PricerService implements Pricer {

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
        return item.getPrice() * occurrence; // todo : apply special offer
    }
}
