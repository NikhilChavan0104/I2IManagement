package com.i2imanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.i2imanagement.modeladmin.HomeSlider;

@Repository
public interface HomeSliderRepo extends JpaRepository<HomeSlider,Long> {

}
