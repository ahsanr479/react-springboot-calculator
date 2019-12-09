package com.ahsan.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahsan.calculator.service.CalculatorServiceImpl;


@RestController
public class CalculatorController {
	
	@Autowired
	CalculatorServiceImpl calculatorService;
	
	@Autowired
	Total total;

	@PostMapping("/add")
	public ResponseEntity<Total> add(@RequestParam(name="firstNum") double firstNum, @RequestParam(name="secondNum") double secondNum){
		total.setTotal(calculatorService.add(firstNum, secondNum)); 
		ResponseEntity<Total> response =  ResponseEntity.ok(total);
		return response;
 
	}
	
	@PostMapping("/substract")
	public ResponseEntity<Total> substract(@RequestParam(name="firstNum") double firstNum, @RequestParam(name="secondNum") double secondNum){		
		System.out.println(firstNum);
		total.setTotal(calculatorService.substract(firstNum, secondNum)); 
		ResponseEntity<Total> response =  ResponseEntity.ok(total);
		System.out.println(response);
		return response;	
	}
	
	@PostMapping("/multiply")
	public ResponseEntity<Total> multiply(@RequestParam(name="firstNum") double firstNum, @RequestParam(name="secondNum") double secondNum){		
		total.setTotal(calculatorService.multiply(firstNum, secondNum)); 
		ResponseEntity<Total> response =  ResponseEntity.ok(total);
		System.out.println(response);
		return response;
	}
	
	@PostMapping("/divide")
	public  ResponseEntity<Total> divide(@RequestParam(name="firstNum") double firstNum, @RequestParam(name="secondNum") double secondNum){		
		total.setTotal(calculatorService.divide(firstNum, secondNum)); 
		ResponseEntity<Total> response =  ResponseEntity.ok(total);
		return response;
	}
	
	@PostMapping("/percentage")
	public  ResponseEntity<Total> percentage(@RequestParam(name="firstNum") double firstNum, @RequestParam(name="secondNum") double secondNum){		
		total.setTotal(calculatorService.percentage(firstNum, secondNum)); 
		ResponseEntity<Total> response =  ResponseEntity.ok(total);
		return response;
	}

	
	

	
	
}
