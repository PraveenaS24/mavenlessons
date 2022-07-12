package com.chainsys.mavenlessons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.chainsys.mavenlessons.entity.Passport;
import com.chainsys.mavenlessons.entity.User;
import com.chainsys.mavenlessons.service.PassportServices;

@RestController
@RequestMapping("passport")
public class PassportControl {
	@Autowired
	private PassportServices passportservices;
	private String redirectUrl = "/passport/fetchpassports";
	@GetMapping(value = "/fetchpassportbyid", produces = "application/json")
	public Passport getPassport(int id) {
		return passportservices.findPassportById(id);
	}
	@GetMapping(value = "/fetchpassports", produces = "application/json")
	public List<Passport> getAllPassport() {
		return passportservices.getPassports();
	}
	@PostMapping(value = "/addpassport", consumes = "application/json")
	public RedirectView addPassport(@RequestBody Passport passport) {
		passportservices.addPassport(passport);
		return new RedirectView(redirectUrl);
	}
	@PostMapping(value = "/modifypassport", consumes = "application/json")
	public RedirectView updatePassport(@RequestBody Passport passport) {
		passportservices.modifyPassport(passport);
		return new RedirectView(redirectUrl);
	}
	@DeleteMapping(value = "/removepassportbyid")
	public RedirectView removePassport(int id) {
	passportservices.deletePassportById(id);
	return new RedirectView(redirectUrl);
	}
	
}