package com.sample.store.driversuggestionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.store.driversuggestionservice.entity.StoreDetail;

@Repository
public interface StoreDetailRepository extends JpaRepository<StoreDetail, String>{
}
