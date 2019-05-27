package fr.joand.supermarket.model;

import lombok.Getter;

public enum Item {
    apple(0.2), orange(0.5), watermelon(0.8);

    @Getter
    private final double price;

    Item(double price) {
        this.price = price;
    }
}
