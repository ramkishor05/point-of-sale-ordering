package com.brijframework.ordering.repository.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.ordering.entities.cart.EOCustCartPurchaseItem;

@Repository
@Transactional
public interface CustCartPurchaseItemRepository extends JpaRepository<EOCustCartPurchaseItem, Long> {

}

