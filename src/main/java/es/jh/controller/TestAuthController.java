package es.jh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {
	
	@GetMapping("/hello")
	@PreAuthorize("permitAll()")
	public String hello() {
		return "Hello world";
	}
	
	@GetMapping("/hello-secured")
	@PreAuthorize("hasAuthority('READ')")
	public String helloSecured(){
		return "Hello world secured";
	}
	
	@GetMapping("/hello-secured2")
	@PreAuthorize("hasAuthority('CREATE')")
	public String helloSecured2(){
		return "Hello world secured2";
	}
}
