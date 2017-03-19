package com.assignment.dto;

import java.util.Date;

public class Tasks
{
	private int id;
	private String title;
	private Date due_date;
	private double estimated_hours;
	private String project;
	private TaskProjectData project_data;
	
	public Tasks()
	{
		
	}
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Date getDue_date()
	{
		return due_date;
	}

	public void setDue_date(Date due_date)
	{
		this.due_date = due_date;
	}

	public double getEstimated_hours()
	{
		return estimated_hours;
	}

	public void setEstimated_hours(double estimated_hours)
	{
		this.estimated_hours = estimated_hours;
	}

	public String getProject()
	{
		return project;
	}

	public void setProject(String project)
	{
		this.project = project;
	}

	public TaskProjectData getProject_data()
	{
		return project_data;
	}

	public void setProject_data(TaskProjectData project_data)
	{
		this.project_data = project_data;
	}

}
