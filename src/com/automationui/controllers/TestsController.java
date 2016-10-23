package com.automationui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.automationui.beans.Driver;
import com.automationui.services.TestService;

@Controller
public class TestsController {
	
	@Autowired
	TestService testService;

	@RequestMapping(value="/tests", method=RequestMethod.GET)
	public String getTests(Model model){
		List<Driver> drivers = testService.getTests();
		model.addAttribute("tests", drivers);
		model.addAttribute("search", new Driver());
		return "tests";
	}
	
	@RequestMapping(value="/tests", method=RequestMethod.POST)
	public String getFilteredTests(@RequestParam("tc_id")int tc_id, Model model){
		List<Driver> drivers = testService.getTests(tc_id);
		model.addAttribute("tests", drivers);
		model.addAttribute("search", new Driver());
		return "tests";
	}
}
