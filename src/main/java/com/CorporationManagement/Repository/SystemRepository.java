package com.CorporationManagement.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.CorporationManagement.Entity.SystemEntity;

public interface SystemRepository extends JpaRepository<SystemEntity , Integer> {
	//public List<SystemEntity> findAllByOrderByIdAsc();
	
//	 @Query("FROM SysDtls ORDER BY Ward ASC")
//	List<SystemEntity> SortAllAsc();

}