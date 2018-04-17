package com.sorkehdcjf.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
}
