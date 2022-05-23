package com.sample.store.driversuggestionservice.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.store.driversuggestionservice.entity.DriverDetail;

@Repository
public interface DriverDetailRepository  extends JpaRepository<DriverDetail, String>{


	//6371: radius of the earth in KM
	// If you want to search using miles then you need to change it to 3961 from 6371.
	String HAVERSINE_FORMULA = "(6371 * acos(cos(radians(:startlat)) * cos(radians(d.latitude)) *" +
	        " cos(radians(d.longitude) - radians(:startlng)) + sin(radians(:startlat)) * sin(radians(d.latitude))))";
	
	String sqlSelectAllPersons = "SELECT *, " + HAVERSINE_FORMULA + " as distance, latitude   "
			+ "FROM driver_detail d ORDER BY distance ";
	

	@Query(value=sqlSelectAllPersons
			, nativeQuery = true)
	List<DriverDetail> getNearestStore(Double startlat, Double startlng, Pageable pageable);
	
}
