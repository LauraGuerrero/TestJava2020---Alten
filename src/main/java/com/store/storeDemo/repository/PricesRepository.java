package com.store.storeDemo.repository;

import com.store.storeDemo.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Repositorio de precios
 */
@Repository
public interface PricesRepository extends JpaRepository<Prices,Long> {
   Prices findByProductIdAndBrandIdAndStartDate(Long productId, Long brandId,Date startDate);
}
