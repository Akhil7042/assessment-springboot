package com.asde.springboot.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringbootControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("/home page api test")
	void testMessage() {

		URI targetUrl = UriComponentsBuilder.fromUriString("/").build().encode().toUri();

		String message = this.restTemplate.getForObject(targetUrl, String.class);
		assertEquals("This is an app that helps you find hospital beds", message);
	}

	@Test
	@DisplayName("/beds data")
	void testHospitalBedsData() {

		URI targetUrl = UriComponentsBuilder.fromUriString("/getHospitalBeds").build().encode().toUri();

		Object hospitalBeds = this.restTemplate.getForObject(targetUrl, Object.class);
		assertTrue(hospitalBeds instanceof List<?>);
	}

	@Test
	@DisplayName("/beds for location")
	void testHospitalBedsDataForLocation() {

		URI targetUrl = UriComponentsBuilder.fromUriString("/getBedsForLocation?location=gurugram&bedType=icu")
				.build().encode().toUri();

		Object hospitalBeds = this.restTemplate.getForObject(targetUrl, Object.class);
		assertTrue(hospitalBeds instanceof Integer);
	}
}
