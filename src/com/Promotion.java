package com;

/**
 * Created by ananmoha
 * Date: 2/24/2015
 * Time: 8:42 PM
 */
public class Promotion {

    public enum PromotionType {
        PERCENT_OFF_ITEM, TOTAL_PERCENT_OFF
    }

    private PromotionType promotionType;
    private int percentOff;

    // PERCENTAGE of only if buy more than n items
    private int minimumItemCount;

    private boolean isPromotionRepeatForEveryMinimumCount;

    public Promotion(PromotionType promotionType, int percentOff, int minimumItemCount,
                     boolean isPromotionRepeatForEveryMinimumCount) {
        this.promotionType = promotionType;
        this.percentOff = percentOff;
        this.minimumItemCount = minimumItemCount;
        this.isPromotionRepeatForEveryMinimumCount = isPromotionRepeatForEveryMinimumCount;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public int getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(int percentOff) {
        this.percentOff = percentOff;
    }

    public int getMinimumItemCount() {
        return minimumItemCount;
    }

    public void setMinimumItemCount(int minimumItemCount) {
        this.minimumItemCount = minimumItemCount;
    }

    public boolean isPromotionRepeatForEveryMinimumCount() {
        return isPromotionRepeatForEveryMinimumCount;
    }

    public void setPromotionRepeatForEveryMinimumCount(boolean isPromotionRepeatForEveryMinimumCount) {
        this.isPromotionRepeatForEveryMinimumCount = isPromotionRepeatForEveryMinimumCount;
    }
}
