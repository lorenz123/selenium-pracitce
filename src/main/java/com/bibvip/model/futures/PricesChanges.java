package com.bibvip.model.futures;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PricesChanges {
    /**
     * This class is used as an input parameter for the endpoint
     * <br>
     * 此类用作端点的输入参数
     */
    private String pairs;
    private BigDecimal last_price;
    private float change;
}
