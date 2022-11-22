package com.example.server.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.model.Label;
import com.example.server.model.UserData;

@RestController
public class ServerRestController {
	
	Logger logger = LoggerFactory.getLogger(ServerRestController.class);

	@PostMapping(value = "/api", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<UserData> postData(@RequestBody UserData user) throws Exception {
		logger.info("Welcome to server...............");
		Label label = new Label();
		label.setTrackingNumber("02393000043620905722");
		label.setTrackingUrl(
				"https://wwwtest.fedex.com/document/v1/cache/retrieve/SH,fed7eefdfd528a7e02393000043620905722_SHIPPING_P?isLabel=true&autoPrint=false");
		ResponseEntity<UserData> responseEntity = null;
		try {
			user.getData().getAttributes().setLable(label);
			user.getData().getAttributes().setLable(label);
			responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(" Error while getting the data "+e.getMessage());
		}
		return responseEntity;
	}
}
