package com.brijframework.ordering.repository.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.ordering.entities.cart.EOCustCartPurchaseAdditional;

@Repository
@Transactional
public interface CustCartPurchaseAdditionalRepository extends JpaRepository<EOCustCartPurchaseAdditional, Long> {

}
