package com.ahsan.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.ahsan.calculator.controller.CalculatorController;
import com.ahsan.calculator.controller.Total;

@SpringBootTest
public class CalculatorControllerTest {
	
	@Autowired
	CalculatorController controller;

	@Test
	void addtest(){
		ResponseEntity<Total> response = controller.add(25, 25);
		double result = response.getBody().getTotal();
		double expected = 25 + 25;
		assertEquals(expected, result);
	}
	
	@Test
	void subtractTest() {
		ResponseEntity<Total> response = controller.substract(25, 25);
		double result = response.getBody().getTotal();
		double expected = 25 - 25;
		assertEquals(expected, result);
	}
	
	@Test
	void multiplyTest() {
		ResponseEntity<Total> response = controller.multiply(25, 25);
		double result = response.getBody().getTotal();
		double expected = 25 * 25;
		assertEquals(expected, result);
	}
	
	@Test
	void divideTest() {
		ResponseEntity<Total> response = controller.divide(25, 25);
		double result = response.getBody().getTotal();
		double expected = 25 / 25;
		assertEquals(expected, result);
	}
	
	@Test
	void percentageTest() {
		double a = 25, b =90;
		ResponseEntity<Total> response = controller.percentage(a, b);
		double result = response.getBody().getTotal();
		double expected = a /b;
		expected *= 100;
		assertEquals(expected, result);
	}
}
