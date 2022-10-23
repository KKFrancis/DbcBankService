package com.aiti.dbc.DbcBankService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/welcome")
	public String hello() {
		return "<h1>Thank you Jesus</h1>";
	}
}
