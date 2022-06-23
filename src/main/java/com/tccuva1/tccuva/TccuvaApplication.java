package com.tccuva1.tccuva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class TccuvaApplication {


	@GetMapping("/")
	String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TccuvaApplication.class, args);
	}

}
