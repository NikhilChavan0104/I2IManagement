package com.i2imanagement.springjwtAdminResponse;

import java.util.List;

import com.i2imanagement.modeladmin.HomeSlider;

public class ManageSliderImageJson {
	
	private String message;
    private String statusCode;
  private  List<HomeSlider>  sliderImage;


public ManageSliderImageJson(String message, String statusCode, List<HomeSlider> sliderImage) {
	super();
	this.message = message;
	this.statusCode = statusCode;
	this.sliderImage = sliderImage;
}


@Override
public String toString() {
	return "ManageSliderImageJson [message=" + message + ", statusCode=" + statusCode + ", sliderImage=" + sliderImage
			+ "]";
}


public String getMessage() {
	return message;
}


public void setMessage(String message) {
	this.message = message;
}


public String getStatusCode() {
	return statusCode;
}


public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}


public List<HomeSlider> getSliderImage() {
	return sliderImage;
}


public void setSliderImage(List<HomeSlider> sliderImage) {
	this.sliderImage = sliderImage;
}


public ManageSliderImageJson() {
	super();
}
  
  

}
