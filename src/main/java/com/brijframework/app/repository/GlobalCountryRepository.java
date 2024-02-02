package com.brijframework.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.app.entities.EOGlobalCountry;

@Repository
@Transactional
public interface GlobalCountryRepository extends JpaRepository<EOGlobalCountry, Long>{

	@Query(nativeQuery = true,  value="select * from EOGLOBAL_COUNTRY EC where EC.NAME in (:names)")
	List<EOGlobalCountry> findByNames(List<String> names);

	@Query(nativeQuery = true, value = "select * from EOGLOBAL_COUNTRY where RECORD_STATUS in (?1)")
	List<EOGlobalCountry> getCountryListByStatus(List<String> statusIds);

}
