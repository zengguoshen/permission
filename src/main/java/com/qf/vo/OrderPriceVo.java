package com.qf.vo;

import java.math.BigDecimal;

/**
 * Created by DELL on 2019/5/10.
 */
public class OrderPriceVo {
    BigDecimal startPrice;
    BigDecimal endPrice;

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(BigDecimal endPrice) {
        this.endPrice = endPrice;
    }
}
