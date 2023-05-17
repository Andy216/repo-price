package com.price.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.price.domain.Price;

@Repository("priceRepository")
public interface PriceRepository extends JpaRepository<Price, Long>{

	@Query("select u from Price u "
			+ " where (:#{#pric.productId} is null or u.productId = :#{#pric.productId}) "
			+ " and (:#{#pric.brandId} is null or u.brandId = :#{#pric.brandId})"
			+ " and (:#{#pric.startDate} is null or "
			+ " (PARSEDATETIME(:#{#pric.startDate},'yyyy-MM-dd HH:mm:ss')  BETWEEN start_Date and end_date) )")
	List<Price> findCustom(@Param("pric") Price pric);
}
