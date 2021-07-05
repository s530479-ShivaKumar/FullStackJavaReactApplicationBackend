package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World shiva kumar";
	}
	
	//hello-world-bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello bean");
	}
	
	//hello-world-bean
		@GetMapping(path = "/hello-world-bean/path-variable/{name}")
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
//			throw new RuntimeException("Something's wrong");
			return new HelloWorldBean(String.format("Hello %s", name));
		}
}
