package com.i2imanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2imanagement.modeladmin.HomeSlider;
import com.i2imanagement.repository.HomeSliderRepo;

@Service
public class HomeSliderService {
	
	@Autowired
	HomeSliderRepo homeSliderRepo;

	public List<HomeSlider> getAllImages() {
		// TODO Auto-generated method stub
		return homeSliderRepo.findAll();
	}

	public void save(HomeSlider homeSlider) {
		homeSliderRepo.save(homeSlider);
		
	}

	
		
	

}
