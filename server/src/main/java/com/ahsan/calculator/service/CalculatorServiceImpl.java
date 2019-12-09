package com.ahsan.calculator.service;

import org.springframework.stereotype.Component;

@Component
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public double add(double a, double b) {
		double sum = a + b;
		return sum;
	}

	@Override
	public double substract(double a, double b) {
		double total = a - b;
		return total;
	}

	@Override
	public double divide(double a, double b) {
		double total = a / b;
		return total;
	}

	@Override
	public double multiply(double a, double b) {
		double total = a * b;
		return total;
	}

	@Override
	public double percentage(double a, double b) {
		double total = a / b;
		total *= 100;
		return total;
	}

}
