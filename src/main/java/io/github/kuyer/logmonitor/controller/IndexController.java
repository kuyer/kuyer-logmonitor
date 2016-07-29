package io.github.kuyer.logmonitor.controller;

import io.github.kuyer.logmonitor.exception.HtmlException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@Value("${io.github.kuyer.name}")
	private String name;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getIndex(Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getList() throws HtmlException {
		return "list";
	}
	
}
