package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ananmoha
 * Date: 2/24/2015
 * Time: 8:36 PM
 */
public class SuperMarketImpl implements SuperMarket {

    private Map<String, Sku> availableProducts = new HashMap<String, Sku>();

    private PricingEngine pricingEngine = new PricingEngine();

    public Map<String, Sku> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(Map<String, Sku> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public PricingEngine getPricingEngine() {
        return pricingEngine;
    }

    public void setPricingEngine(PricingEngine pricingEngine) {
        this.pricingEngine = pricingEngine;
    }

    @Override
    public double checkout(String items) {

        Map<String, Integer> itemMap = new HashMap<String, Integer>();
        for (int i = 0; i < items.length(); ++i) {
            String charAt = String.valueOf(items.charAt(i));
            if (!itemMap.containsKey(charAt)) {
                itemMap.put(charAt, 1);
            } else {
                itemMap.put(charAt, itemMap.get(charAt) + 1);
            }
        }

        double totalPrice = 0.0;
        for(Map.Entry<String, Integer> entry : itemMap.entrySet()) {
            totalPrice += getPricingEngine().calculatePrice(availableProducts.get(entry.getKey()), entry.getValue());
        }

        return totalPrice;
    }

    public static void main(String args[]) {
        SuperMarketImpl superMarket = new SuperMarketImpl();

        //Create available product list
        Map<String, Sku> availableProducts = new HashMap<String, Sku>();
        availableProducts.put("A", new Sku("A", 100, 20));
        availableProducts.put("B", new Sku("B", 100, 50));
        availableProducts.put("C", new Sku("C", 100, 30));
        superMarket.setAvailableProducts(availableProducts);

        // 5 items at 3 items prize == 40% off of 5 items
        Promotion promotion = new Promotion(Promotion.PromotionType.PERCENT_OFF_ITEM, 40, 5, true);
        List<Promotion> promotinList = new ArrayList<Promotion>();
        promotinList.add(promotion);

        // Add promotions to the pricing engine
        superMarket.getPricingEngine().addToPromotionEngine("B", promotinList);

        System.out.println(superMarket.checkout("ABBACBBAB"));
    }
}
