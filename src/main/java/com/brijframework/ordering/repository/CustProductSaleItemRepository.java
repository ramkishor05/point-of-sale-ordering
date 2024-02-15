package com.brijframework.ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.ordering.entities.sales.EOCustProductSaleItem;

@Repository
@Transactional
public interface CustProductSaleItemRepository extends JpaRepository<EOCustProductSaleItem, Long>{

	void deleteByCustProductSaleId(Long id);
	
}
