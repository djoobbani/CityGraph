package com.mastercard.codechallenge.citygraph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;

@WebMvcTest(CityGraphController.class)
@ComponentScan("com.mastercard.codechallenge.citygraph")
@AutoConfigureMockMvc
class CityGraphServiceTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
