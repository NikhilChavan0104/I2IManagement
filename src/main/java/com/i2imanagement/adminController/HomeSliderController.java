package com.i2imanagement.adminController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i2imanagement.modeladmin.Constants;
import com.i2imanagement.modeladmin.HomeSlider;
import com.i2imanagement.modeladmin.JsonResponse;
import com.i2imanagement.service.HomeSliderService;
import com.i2imanagement.springjwt.security.jwt.JwtUtils;
import com.i2imanagement.springjwtAdminResponse.ManageSliderImageJson;

@Controller
@RequestMapping("/admin")
public class HomeSliderController {

	@Autowired
	HomeSliderService homeSliderService;

	@Autowired
	JwtUtils jwtUtils;

	String uploadSliderImageDirectory = Constants.UPLOADSLIDERIMAGEDIRECTORY.constant;

	@RequestMapping(value = "/save-slider-images", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveSliderImage(HomeSlider homeSlider, BindingResult bindingResult,
			@RequestParam("sliderImage") MultipartFile sliderPicture, RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpSession session) {

		JsonResponse response = new JsonResponse();

		Object jwtToken = session.getAttribute("adminJwtToken");

		if (jwtToken != null) {

			if (jwtUtils.validateJwtToken(request.getHeader(Constants.AUTHORIZATION.constant))) {

				if (!sliderPicture.isEmpty() && sliderPicture != null) {
					String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
					String originalFileName = dateName + "-"
							+ sliderPicture.getOriginalFilename().replace(" ", "-").toLowerCase();
					Path fileNameAndPath = Paths.get(uploadSliderImageDirectory, originalFileName);
					try {
						Files.write(fileNameAndPath, sliderPicture.getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
					homeSlider.setSliderImage(originalFileName);
				} else {
					homeSlider.setSliderImage("");
				}
				homeSliderService.save(homeSlider);
				response.setMessage("Slider Image Store Successfully");
				response.setResult("Success");
				response.setStatusCode(Constants.CREATED.constant);

			} else {
				response.setMessage(Constants.INVALID_TOKEN_MESSAGE.constant);
				response.setStatusCode(Constants.INVALID_TOKEN.constant);

			}
		} else {
			response.setMessage(Constants.SESSION_EXPIRED_MESSAGE.constant);
			response.setStatusCode(Constants.SESSION_EXPIRED.constant);
			response.setResult("UnSuccess");

		}

		return response;
	}

	@RequestMapping(value = "/get-slider-image", method = RequestMethod.GET)
	@ResponseBody
	public ManageSliderImageJson getAllImages(HttpServletRequest request, HttpSession session) {
		ManageSliderImageJson manageSliderImageJson = new ManageSliderImageJson();

		Object jwtToken = session.getAttribute("adminJwtToken");
		List<HomeSlider> list = null;
		if (jwtToken != null) {

			if (jwtUtils.validateJwtToken(request.getHeader(Constants.AUTHORIZATION.constant))) {

				manageSliderImageJson.setSliderImage(homeSliderService.getAllImages());
				manageSliderImageJson.setMessage("Successfully Fetched");

			} else {
				manageSliderImageJson.setMessage(Constants.INVALID_TOKEN_MESSAGE.constant);
				manageSliderImageJson.setSliderImage(list);
				manageSliderImageJson.setStatusCode(Constants.INVALID_TOKEN.constant);

			}
		} else {
			
			manageSliderImageJson.setMessage(Constants.SESSION_EXPIRED_MESSAGE.constant);
			manageSliderImageJson.setSliderImage(list);
			manageSliderImageJson.setStatusCode(Constants.SESSION_EXPIRED.constant);

		}
		return manageSliderImageJson;

	}

	@RequestMapping("/get-slider-image/{sliderImage}")
	public String getAdminProfileImage(@PathVariable("sliderImage") String sliderImage, HttpServletResponse response,
			HttpSession session) {
		Object checkToken = session.getAttribute("adminJwtToken");
		String message;
		// if (checkToken != null) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(uploadSliderImageDirectory + sliderImage));
			response.setContentLength(b.length);
			response.setContentType("image/jpg");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		message = "Image Fetch Successfully....";

//			}else {
//				message=Constants.SESSION_EXPIRED_MESSAGE.constant;
//			}
		return null;
	}
}
