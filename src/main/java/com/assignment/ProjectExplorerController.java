package com.assignment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.assignment.dto.test;

@Controller
public class ProjectExplorerController {
	@Autowired(required=true)
	private HttpServletRequest request;
	
	@GetMapping("/projectexplorer")
	public String loginForm(Model model) {
		
		model.addAttribute("test", new test((String) request.getSession().getAttribute("Token")));
		return "projectexplorer";
	}
}
