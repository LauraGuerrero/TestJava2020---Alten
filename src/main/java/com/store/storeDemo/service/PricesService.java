package com.store.storeDemo.service;

import com.store.storeDemo.model.Prices;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Servicio de Precios
 */
@Service
public interface PricesService {
    Prices getPrices(Long productId, Long brandId, Date startDate);
}
