package com.brijframework.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.app.entities.EOGlobalUnitConversion;

@Repository
@Transactional
public interface GlobalUnitConversionRepository extends JpaRepository<EOGlobalUnitConversion, Long>{
	
	EOGlobalUnitConversion findOneByTypeId(String typeId);

	int countByTypeId(String typeId);

}
