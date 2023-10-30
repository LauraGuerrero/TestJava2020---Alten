package com.store.storeDemo.controller;

import com.store.storeDemo.dto.PricesDtoRequest;
import com.store.storeDemo.dto.PricesDtoResponse;
import com.store.storeDemo.exceptions.PricesException;
import com.store.storeDemo.model.Prices;
import com.store.storeDemo.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Controlador encargado de administrar los endPoints
 */
@RestController
@RequestMapping(value = "/storeDemo")
public class StoreController {

    @Autowired
    private PricesService pricesService;

    /**
     * Metodo encargado de realizar una consulta de precios de productos
     *
     * @param dtoIn
     * @return dtoResponse
     * @throws Exception
     */
    @GetMapping(value = "/prices")
    public PricesDtoResponse getPrice(@RequestBody PricesDtoRequest dtoIn) throws Exception {
        try {
            Prices price = pricesService.getPrices(dtoIn.getProductId(), dtoIn.getBrandId(), dtoIn.getStartDate());
            if (price == null) {// si no encuentra resultados
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
            }
            PricesDtoResponse dtoResponse = new PricesDtoResponse();
            dtoResponse.setProductId(price.getProductId());
            dtoResponse.setPrice(price.getPrice());
            dtoResponse.setBrandId(price.getBrandId());
            dtoResponse.setEndDate(price.getEndDate());
            dtoResponse.setStartDate(price.getStartDate());
            dtoResponse.setPriceList(price.getPriceList());
            return dtoResponse;
        } catch (PricesException pricesException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error :", pricesException);
        }
    }
}
