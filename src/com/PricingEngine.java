package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ananmoha
 * Date: 2/24/2015
 * Time: 9:08 PM
 */
public class PricingEngine {

    private Map<String, List<Promotion>> promotionEngine = new HashMap<String, List<Promotion>>();

    public void addToPromotionEngine(String sku, List<Promotion> promotions) {
        if (promotionEngine.containsKey(sku)) {
            List<Promotion> existingPromotins = promotionEngine.get(sku);
            existingPromotins.addAll(promotions);
        } else {
            promotionEngine.put(sku, promotions);
        }
    }

    public double calculatePrice(Sku sku, int itemCount) {
        if (promotionEngine.containsKey(sku.getSkuName())) {
            List<Promotion> existingPromotins = promotionEngine.get(sku.getSkuName());
            Promotion bestPromotion = null;
            for (Promotion promotion : existingPromotins) {
                if (bestPromotion == null && promotion.getMinimumItemCount() <= itemCount) {
                    bestPromotion = promotion;
                } else if (bestPromotion.getPercentOff() < promotion.getPercentOff() && promotion.getMinimumItemCount
                        () <= itemCount) {
                    bestPromotion = promotion;
                }
            }
            if (bestPromotion != null) {
                int promotionNotApplicableItems = 0;
                if (bestPromotion.isPromotionRepeatForEveryMinimumCount()) {
                    promotionNotApplicableItems = itemCount % bestPromotion.getMinimumItemCount();
                } else {
                    promotionNotApplicableItems = itemCount - bestPromotion.getMinimumItemCount();
                }
                double totalPrice = (((itemCount - promotionNotApplicableItems) * sku.getPrice() *
                        (100 -bestPromotion.getPercentOff())) / 100.0) + (promotionNotApplicableItems * sku.getPrice());
                return totalPrice;
            }
        }
        return sku.getPrice() * itemCount;
    }
}
