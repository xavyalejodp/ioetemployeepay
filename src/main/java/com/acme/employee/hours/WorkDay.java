package com.acme.employee.hours;

public class WorkDay {
	
	private String dayCode;
	private String dayDescription;
	
	private WorkHour workHour;

	public String getDayCode() {
		return dayCode;
	}

	public WorkDay(String dayCode, String dayDescription, WorkHour workHour) {
		super();
		this.dayCode = dayCode;
		this.dayDescription = dayDescription;
		this.workHour = workHour;
	}

	public void setDayCode(String dayCode) {
		this.dayCode = dayCode;
	}

	public String getDayDescription() {
		return dayDescription;
	}

	public void setDayDescription(String dayDescription) {
		this.dayDescription = dayDescription;
	}

	public WorkHour getWorkHour() {
		return workHour;
	}

	public void setWorkHour(WorkHour workHour) {
		this.workHour = workHour;
	}
	

}
