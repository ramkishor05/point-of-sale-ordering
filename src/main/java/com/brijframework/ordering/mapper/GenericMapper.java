package com.brijframework.ordering.mapper;

import java.util.Date;
import java.util.List;

import com.brijframework.ordering.util.CommanUtil;

public interface GenericMapper<E, D> {

	D mapToDTO(E eoRole);

	E mapToDAO(D eoRoleDTO);
	
	List<E> mapToDAO(List<D> findAll);
	
	List<D> mapToDTO(List<E> eoRoleDTO);
	

	default Date toDate(String dateStr) {
		return CommanUtil.toDate(dateStr);
	}
	
	default String toString(Date dateStr) {
		return CommanUtil.toDate(dateStr);
	}
	
}
