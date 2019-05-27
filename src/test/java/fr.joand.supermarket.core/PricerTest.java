package fr.joand.supermarket.core;

import fr.joand.supermarket.Application;
import fr.joand.supermarket.model.Basket;
import fr.joand.supermarket.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
public class PricerTest {

    @Autowired
    private Pricer pricer;

    @Test
    public void computePriceBasket() {
        double expectedPrice = 0.4 + 1.5 + 3.2;

        Basket basket = new Basket();
        basket.getContent().put(Item.apple, Long.valueOf(4));
        basket.getContent().put(Item.orange, Long.valueOf(3));
        basket.getContent().put(Item.watermelon, Long.valueOf(5));
        double actualPrice = pricer.computePrice(basket);

        double delta = 0;
        assertEquals(expectedPrice, actualPrice, delta);
    }

    @Test
    public void computePriceApples() {
        double expectedPrice = 0.4;
        double actualPrice = pricer.computePrice(Item.apple, 4);
        double delta = 0;
        assertEquals(expectedPrice, actualPrice, delta);
    }

    @Test
    public void computePriceOranges() {
        double expectedPrice = 1.5;
        double actualPrice = pricer.computePrice(Item.orange, 3);
        double delta = 0;
        assertEquals(expectedPrice, actualPrice, delta);
    }

    @Test
    public void computePriceWatermelons() {
        double expectedPrice = 3.2;
        double actualPrice = pricer.computePrice(Item.watermelon, 5);
        double delta = 0;
        assertEquals(expectedPrice, actualPrice, delta);
    }
}
