package com.store.storeDemo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DTO de Entrada para las llamadas a REST
 */
@Getter
@Setter
public class PricesDtoRequest {
    @NotNull
    private Long brandId;
    @NotNull
    private Date startDate;
    @NotNull
    private Long productId;


}
