package com.cibertec.dawiCL3grupo6.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/home")
	public String homefrm() {
		return"home";
	}
	
	
}
