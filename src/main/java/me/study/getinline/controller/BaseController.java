package me.study.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BaseController {

	@GetMapping("/")
	public String root() throws Exception {
		return "index";
	}
}
