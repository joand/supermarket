package fr.joand.supermarket.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Basket {

    private final Map<Item, Long> content = new HashMap<>();
}
