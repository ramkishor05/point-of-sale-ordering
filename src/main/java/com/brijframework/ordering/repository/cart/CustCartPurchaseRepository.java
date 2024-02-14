package com.brijframework.ordering.repository.cart;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.ordering.entities.cart.EOCustCartPurchase;

@Repository
@Transactional
public interface CustCartPurchaseRepository extends JpaRepository<EOCustCartPurchase, Long>{
	
	List<EOCustCartPurchase> findAllByCustBusinessAppId(long custBusinessAppId);

	EOCustCartPurchase findByCustBusinessAppIdAndTypeIdAndRecordState(long custBusinessAppId, String typeId, String recordState);

	@Query(nativeQuery = true, value = "select * from EOCUST_CART_PURCHASE where CUST_BUSINESS_APP_ID =?1 and CREATED_AT between ?2 AND ?3")
	List<EOCustCartPurchase> filterCartPurchaseList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate);
	
	@Query(nativeQuery = true, value = "select * from EOCUST_CART_PURCHASE where CUST_BUSINESS_APP_ID =?1 and SUPPLIER_ID =?2 and CREATED_AT between ?3 AND ?4")
	List<EOCustCartPurchase> filterCartPurchaseList(long custAppId, Long supplierId, LocalDateTime fromDate, LocalDateTime toDate);

	@Query(nativeQuery = true, value = "select * from EOCUST_CART_PURCHASE where CUST_BUSINESS_APP_ID =?1 and SUPPLIER_ID =?2 order by CREATED_AT desc")
	List<EOCustCartPurchase> findAllByCustBusinessAppIdAndSupplierId(long custAppId, Long supplierId);
	

	@Query(nativeQuery = true, value = "select * from EOCUST_CART_PURCHASE where CUST_BUSINESS_APP_ID =?1 and USER_ID =?2 order by CREATED_AT desc")
	List<EOCustCartPurchase> findAllByCustBusinessAppIdAndUserId(long custAppId, Long userId);

	List<EOCustCartPurchase> findAllByCustBusinessAppIdAndUserIdAndRecordState(long custAppId, Long userId, String status);
}
