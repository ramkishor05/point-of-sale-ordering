package com.brijframework.ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.ordering.entities.purchases.EOCustProductPurchasePayment;

@Repository
@Transactional
public interface CustProductPurchasePaymentRepository extends JpaRepository<EOCustProductPurchasePayment, Long> {

}

