package com.i2imanagement.adminController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.i2imanagement.modeladmin.JsonResponse;
import com.i2imanagement.modeladmin.User;
import com.i2imanagement.service.UserApplicationService;

@Controller

@RequestMapping("/user")
public class SuperUserApplicationController {

	@Autowired
	UserApplicationService userApplicationService;

	@RequestMapping("/login-page")
	public String empLogin() {
		return "user/login-form";
	}

	@RequestMapping("/user-resistration-form")
	public String userResistration() {
		return "user/user-resistration-form";
	}

	@RequestMapping(value = "/resistration", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveUser(User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		JsonResponse resp = new JsonResponse();
		try {

			User userManager = userApplicationService.fetchByEmailId(user.getEmail());
			if (userManager == null) {
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

				userApplicationService.saveUser(user);
				resp.setStatusCode("True");
				resp.setResult("Registration successful");
				resp.setMessage("User Registered Successfully !!!");
			} else {
				resp.setStatusCode("False");
				resp.setResult("Registration Unsuccessful");
				resp.setMessage("User with this email ID already exists");
			}
		} catch (Exception exception) {
			redirectAttributes.addFlashAttribute("message", "Error:" + exception.getMessage());
			exception.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message", "Invalid Credintials");
		return resp;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse UserLogin(User user, HttpSession session) {
		User UserDetails = userApplicationService.fetchByEmailId(user.getEmail());

		JsonResponse jsonResponse = new JsonResponse();
		if (UserDetails != null) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

			if (bCryptPasswordEncoder.matches(user.getPassword(), UserDetails.getPassword())) {
				session.setAttribute("sign-in-user", UserDetails.getId());

				session.setAttribute("UserEmail", UserDetails.getEmail());

				jsonResponse.setStatusCode("True");
				jsonResponse.setResult("Login Successful");
				jsonResponse.setMessage("User Logged in Successfully !!!");
			} else {
				jsonResponse.setStatusCode("False");
				jsonResponse.setResult("Bad Credentials");
				jsonResponse.setMessage("Incorrect Password Entered !!!");
			}
		} else {
			jsonResponse.setStatusCode("False");
			jsonResponse.setResult("User Doesn't exists");
			jsonResponse.setMessage("User with this email ID does not exists");
		}
		return jsonResponse;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public JsonResponse logout(HttpSession session) {
		Object checkSession = session.getAttribute("sign-in-user");
		JsonResponse jsonResponse = new JsonResponse();
		if (checkSession != null) {
			session.setAttribute("sign-in-user", null);
			session.invalidate();
			jsonResponse.setStatusCode("True");
			jsonResponse.setResult("Logout Successful");
			jsonResponse.setMessage("User Logout Successfully !!!");
			return jsonResponse;
		} else {

			jsonResponse.setStatusCode("False");
			jsonResponse.setResult("Fail Logout");
			jsonResponse.setMessage("Session Expired...");
			return jsonResponse;
		}

	}

}
