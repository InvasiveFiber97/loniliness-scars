package com.legerito.practice.abs;

import com.legerito.practice.abs.models.Bottle;
import com.legerito.practice.abs.models.OrderItem;
import com.legerito.practice.abs.models.ProductForSale;

public class Store {

    public static void main(String[] args) {
        ProductForSale bottle = new Bottle(10.0, "Glass", 750);
        OrderItem orderItem = new OrderItem(2, bottle);
        bottle.showDetails();
        bottle.getSalesPrice(orderItem.quantity());
        bottle.pricedLineItem(orderItem.quantity());
    }
}
