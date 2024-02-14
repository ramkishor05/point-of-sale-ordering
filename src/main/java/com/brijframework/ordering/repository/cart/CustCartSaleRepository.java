package com.brijframework.ordering.repository.cart;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.ordering.entities.cart.EOCustCartSale;

@Repository
@Transactional
public interface CustCartSaleRepository extends JpaRepository<EOCustCartSale, Long>{
	
	List<EOCustCartSale> findAllByCustBusinessAppId(long custBusinessAppId);

	EOCustCartSale findByCustBusinessAppIdAndTypeId(long custBusinessAppId, String typeId);

	@Query(nativeQuery = true, value = "select * from EOCUST_CART_SALE where CUST_BUSINESS_APP_ID =?1 and CREATED_AT between ?2 AND ?3")
	List<EOCustCartSale> filterCartSaleList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate);

	@Query(nativeQuery = true, value = "select * from EOCUST_CART_SALE where CUST_BUSINESS_APP_ID =?1 and CUSTOMER_ID=?2")
	List<EOCustCartSale> findByCustBusinessAppIdAndCustomerId(long custAppId, Long customerId);

	@Query(nativeQuery = true, value = "select * from EOCUST_CART_SALE where CUST_BUSINESS_APP_ID =?1 and USER_ID=?2")
	List<EOCustCartSale> findByCustBusinessAppIdAndUserId(long custAppId, Long userId);

}
