package com.assignment.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Projects implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int pk;
	private String title;
	private String description;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_date;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_date;
	
	private boolean is_billable;
	private boolean is_active;
	private Tasks[] task_set;
	private Resources[] resource_set;

	public Projects()
	{

	}

	public Projects(int pk, String title, String description, Date start_date, Date end_date, boolean is_billable,
			boolean is_active, Tasks[] task_set, Resources[] resource_set)
	{
		super();
		this.pk = pk;
		this.title = title;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.is_billable = is_billable;
		this.is_active = is_active;
		this.task_set = task_set;
		this.resource_set = resource_set;
	}

	public int getPk()
	{
		return pk;
	}

	public void setPk(int pk)
	{
		this.pk = pk;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getStart_date()
	{
		return start_date;
	}

	public void setStart_date(Date start_date)
	{
		this.start_date = start_date;
	}

	public Date getEnd_date()
	{
		return end_date;
	}

	public void setEnd_date(Date end_date)
	{
		this.end_date = end_date;
	}

	public boolean isIs_billable()
	{
		return is_billable;
	}

	public void setIs_billable(boolean is_billable)
	{
		this.is_billable = is_billable;
	}

	public boolean isIs_active()
	{
		return is_active;
	}

	public void setIs_active(boolean is_active)
	{
		this.is_active = is_active;
	}

	public Tasks[] getTask_set()
	{
		return task_set;
	}

	public void setTask_set(Tasks[] task_set)
	{
		this.task_set = task_set;
	}

	public Resources[] getResource_set()
	{
		return resource_set;
	}

	public void setResource_set(Resources[] resource_set)
	{
		this.resource_set = resource_set;
	}

}
