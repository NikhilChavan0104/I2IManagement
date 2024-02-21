package com.i2imanagement.modeladmin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HomeSlider {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sliderImage = "";

	public HomeSlider() {
		super();
	}

	@Override
	public String toString() {
		return "HomeSlider [id=" + id + ", sliderImage=" + sliderImage + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSliderImage() {
		return sliderImage;
	}

	public void setSliderImage(String sliderImage) {
		this.sliderImage = sliderImage;
	}

	public HomeSlider(Long id, String sliderImage) {
		super();
		this.id = id;
		this.sliderImage = sliderImage;
	}
	
	
}
