package com.assignment.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Resources
{
	private int id;
	private String user;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start_date;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end_date;

	private float rate;
	private double agreed_hours_per_month;
	private Date created;
	private Date updated;
	private String project;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
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

	public float getRate()
	{
		return rate;
	}

	public void setRate(float rate)
	{
		this.rate = rate;
	}

	public double getAgreed_hours_per_month()
	{
		return agreed_hours_per_month;
	}

	public void setAgreed_hours_per_month(double agreed_hours_per_month)
	{
		this.agreed_hours_per_month = agreed_hours_per_month;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(Date created)
	{
		this.created = created;
	}

	public Date getUpdated()
	{
		return updated;
	}

	public void setUpdated(Date updated)
	{
		this.updated = updated;
	}

	public String getProject()
	{
		return project;
	}

	public void setProject(String project)
	{
		this.project = project;
	}

}
