package com.crud_thymeleaf.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MenuResource {
	
	@GetMapping("/")
	public String menu() {
		return "/menu";
	}
	
}
