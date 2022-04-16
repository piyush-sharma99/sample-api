package com.piyush.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200/") //This allows the mapping below to be called from other webservers as by default spring blocks other server communicaiton
@RestController //First tell spring this is a controller
public class HelloWorldController {
	
	//What Rest method?
	//Get
	//Endpoint?
	//URI-/hello-world
	//method - "Hello World"  //This method would usually kick of a webservice where business logic and data access layer would be used
	@GetMapping(path="/hello-world")
	public String hellowWorld() {
		return "Hello World";
	}
	
	//This one returns a bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean hellowWorldBean() {
//		throw new RuntimeException("Some error has happened and contact customer support!");
		return new HelloWorldBean("Hello World");
	}
	
	//This is an example of a mapping where we are passed a path variable and we use it
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean hellowWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name)); // the %s will be replaced with name
	}
}




/*
 * NOTES---
 * @RestController tag test spring that this is a controller. REMEMBER MVC
 * @RestMapping tag allows us to tell spring the type of rest service that should be invoked when the following URI is hit
 * Alternative for RestMapping when we know we are using GET we use @GetMapping. There is also alternative for other rest mappings like post
 * All these annotations are coming from the web framework*/


//Some Questions?

//What is a dispatcher servlet? Handles all the requests. 
//Request -> dispatcher serverlet(This knows all the mapping available in the projecct) -> Response (here the @RestController annotation has a @Responsebody annotation which in this case calls jackson and sends response as JSON)
//Who is configuring dispatcher servlet? spring boot autoconfiguration
//How does the HelloWorldBean object get converted to JSON? autoconfiguration/jackson  this coverts beans to json and json to beans
