package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author   czq
 * @Date 2020-06-19 14:18:10    
 */
@RestController
@RequestMapping("/user/api")
public class UserController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello, user";
	}
}
