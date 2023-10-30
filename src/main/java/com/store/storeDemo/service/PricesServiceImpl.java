package com.store.storeDemo.service;

import com.store.storeDemo.model.Prices;
import com.store.storeDemo.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Implementacion del servicio de precios
 */
@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepository repository;

    @Override
    public Prices getPrices(Long productId, Long brandId, Date startDate) {
        return repository.findByProductIdAndBrandIdAndStartDate(productId,brandId,startDate);
    }
}
