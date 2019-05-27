package fr.joand.supermarket.core;

import fr.joand.supermarket.model.Basket;
import fr.joand.supermarket.model.Item;

public interface Pricer {
    double computePrice(Basket basket);

    double computePrice(Item item, long occurrence);
}
