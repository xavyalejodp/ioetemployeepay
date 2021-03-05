package com.acme.employee.hours;

import java.time.LocalTime;


public class WorkHour {

	private LocalTime hourStart;
	private LocalTime hourEnd;
	private String hourDescription;
	public LocalTime getHourStart() {
		return hourStart;
	}
	public void setHourStart(LocalTime hourStart) {
		this.hourStart = hourStart;
	}
	public WorkHour(LocalTime hourStart, LocalTime hourEnd, String hourDescription) {
		super();
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.hourDescription = hourDescription;
	}
	public LocalTime getHourEnd() {
		return hourEnd;
	}
	public void setHourEnd(LocalTime hourEnd) {
		this.hourEnd = hourEnd;
	}
	public String getHourDescription() {
		return hourDescription;
	}
	public void setHourDescription(String hourDescription) {
		this.hourDescription = hourDescription;
	}
	
		
}
