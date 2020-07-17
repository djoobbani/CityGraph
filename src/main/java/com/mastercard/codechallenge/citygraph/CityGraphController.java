package com.mastercard.codechallenge.citygraph;

import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/connected")
@Api("REST API for City Graph")
public class CityGraphController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityGraphController.class);

	@Autowired
	CityGraphService cityGraphService;

	@GetMapping
	@ApiOperation("Returns 'yes' if two given cities are connected, 'no' if they are not")
	public ResponseEntity<String> isConnected(
			@RequestParam(required = true, defaultValue = "") final @NotBlank String origin,
			@RequestParam(required = true, defaultValue = "") final @NotBlank String destination) {
		LOGGER.debug("isConnected is called with origin city = {} and destination city = {}", origin, destination);
		
		return new ResponseEntity<String>(cityGraphService.areCitiesConnected(origin, destination), HttpStatus.OK);
	}

}
