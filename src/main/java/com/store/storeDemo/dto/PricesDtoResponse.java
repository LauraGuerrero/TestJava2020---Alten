package com.store.storeDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DTO de Salida para las respuestas REST
 */
@Getter
@Setter
@AllArgsConstructor
public class PricesDtoResponse {
    private Long productId;
    private Long brandId;
    private Long priceList;
    private Float price;
    private Date startDate;
    private Date endDate;

    public PricesDtoResponse() {

    }
}
