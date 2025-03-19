package com.DKB.Rest.Examples.RestExamples.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
    
	@GetMapping(path="/hello-world") //for method GET
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean") //for method GET
	public HelloWorld HelloWorld() {
		return new HelloWorld("Hello World 2");
	}
	//path parameters
	///user/{id}/todos/{id}
	// pathVariable rest API  :  /hello-world/path-variable/{name}
	@GetMapping(path="/hello-world/path-variable/{name}") //for method GET
	public HelloWorld HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld(String.format("Hello World ,%s", name));
	}
	
	@GetMapping(path="/hello-world-internationalized") //for method GET
	public String helloWorldInternationalized() {
		Locale Locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Defalut Message", Locale);
	}
}
