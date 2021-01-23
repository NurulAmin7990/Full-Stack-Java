package com.example.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//This class is now a controller to route all requests
@RestController
@RequestMapping("/greeting")
public class HelloController {
	
	//Get methods
	@RequestMapping("/basic")
	public String sayHello() {
		return "<h1>Hello</h1>";
	}
	
	@RequestMapping("/proper")
	public String sayProperHello() {
		return "<h1>Hello there, how are you?</h1>";
	}
	
	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method=\"POST\">\r\n"
				+ "  <label for=\"firstname\">First name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"firstname\" name=\"firstname\"><br>\r\n"
				+ "  <label for=\"lastname\">Last name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"lastname\" name=\"lastname\"><br><br>\r\n"
				+ "  <input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form> ";
	}
	
	//Post methods
	@RequestMapping(value = "/user_greeting", method = RequestMethod.POST)
	public String printUserGreeting(@RequestParam String firstname, @RequestParam String lastname) {
		return "Hello there,"+ " " + firstname + " " + lastname;
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order ID: " + id;
	}
}
