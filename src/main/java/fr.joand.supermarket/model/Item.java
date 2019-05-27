package fr.joand.supermarket.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Item {
    apple(0.2, 2, 1), orange(0.5, 1, 1), watermelon(0.8, 3, 2);

    private final double price;
    private final long currentOccurence;
    private final long chargedOccurence;

    Item(double price, long currentOccurence, long chargedOccurence) {
        this.price = price;
        this.currentOccurence = currentOccurence;
        this.chargedOccurence = chargedOccurence;
    }
}
