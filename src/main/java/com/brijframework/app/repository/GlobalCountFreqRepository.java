package com.brijframework.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.app.entities.EOGlobalCountFreq;

@Repository
@Transactional
public interface GlobalCountFreqRepository extends JpaRepository<EOGlobalCountFreq, Long>{
	
	EOGlobalCountFreq findOneByTypeId(String typeId);

	int countByTypeId(String typeId);

}
