package com.asde.springboot.service;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.asde.springboot.entities.HospitalBedsData;

public class FileReadingServiceImplTest {

	@Test
	void testHospitalBedsData() throws IOException {
		IFileReadingService fileReadingServie = new FileReadingServiceImpl();
		assertTrue(fileReadingServie.readBedsData("gurugram") instanceof Object);
	}

	@Test
	void testGetTotalSlotsForLocation() throws IOException {
		IFileReadingService fileReadingServie = new FileReadingServiceImpl();
		assertTrue(fileReadingServie.getTotalBedsForLocation("gurugram", "icu") instanceof Integer);
	}
}
