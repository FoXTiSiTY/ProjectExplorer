package com.assignment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.assignment.dto.Projects;
import com.assignment.dto.Resources;
import com.assignment.dto.TaskProjectData;
import com.assignment.dto.Tasks;

@Controller
public class ProjectExplorerController 
{
	@Autowired(required=true)
	private HttpServletRequest request;
	
	private Map<Integer, Projects> projectsMapped;
	private Map<Integer, Tasks> tasksMapped;
	private Map<Integer, Resources> resourcesMapped;
	
	@GetMapping("/projectexplorer")
<<<<<<< HEAD
	public String loginForm(Model model) 
	{
		
>>>>>>> 6cf4bc429015f3a02fd362bb193eaf2e0f63d7c4
		String token = (String) request.getSession().getAttribute("Token"); // Request token from Session.
		
		HttpHeaders header = new HttpHeaders();
		header.add("content-type", "application/json");
		header.add("Authorization", token);
		
		HttpEntity<?> httpEntity = new HttpEntity<Object>(header);
		
		RestTemplate template = new RestTemplate();
		ResponseEntity<Projects[]> projects = template.exchange("http://projectservice.staging.tangentmicroservices.com:80/api/v1/projects/", HttpMethod.GET, httpEntity, Projects[].class, Tasks[].class, TaskProjectData.class, Resources[].class);
		
		projectsMapped = new HashMap<>();
		tasksMapped = new HashMap<>();
		resourcesMapped = new HashMap<>();
		
		// Map all objects to find easily. 
		Projects[] projectsList = projects.getBody();
		for (Projects project : projectsList)
		{
			projectsMapped.put(project.getPk(), project);
			
			for (Tasks task : project.getTask_set())
				tasksMapped.put(task.getId(), task);
			
			for (Resources res : project.getResource_set())
				resourcesMapped.put(res.getId(), res);
		}
		
		model.addAttribute("projects", projectsList);
		return "projectexplorer";
	}
	
	@GetMapping("/viewproject")
	public String viewProjectPost(@RequestParam(value="action", required=false) Integer action, Model model)
	{
		Projects project = action != null ? projectsMapped.get(action) : null;
		
		if (project == null) // If project could not be found return to projects view. This could happen when going to the /viewproject url.
			return "redirect:projectexplorer"; 
			
		model.addAttribute("project", project);
		
		return "viewproject";
	}
	
	@GetMapping("/viewtask")
	public String viewTaskPost(@RequestParam(value="action", required=false) Integer action, Model model)
	{
		Tasks task = action != null ? tasksMapped.get(action) : null;
		
		if (task == null) // If project could not be found return to projects view. This could happen when going to the /viewtask url.
			return "redirect:projectexplorer"; 
			
		model.addAttribute("task", task);
		
		return "viewtask";
	}
	
	@GetMapping("/viewresource")
	public String viewResourcePost(@RequestParam(value="action", required=false) Integer action, Model model)
	{
		Resources res = action != null ? resourcesMapped.get(action) : null;
		
		if (res == null) // If project could not be found return to projects view. This could happen when going to the /viewresource url.
			return "redirect:projectexplorer"; 
			
		model.addAttribute("resource", res);
		
		return "viewresource";
	}
}
