package com.acme.employee.hours;

import java.math.BigDecimal;

public class WorkSchedule {
	
	public WorkSchedule(String code, String description, WorkDay workDay, BigDecimal amount) {
		super();
		this.code = code;
		this.description = description;
		this.workDay = workDay;
		this.amount = amount;
	}
	private String code;
	private String description;
	
	private WorkDay workDay;
	
	private BigDecimal amount;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public WorkDay getWorkDay() {
		return workDay;
	}
	public void setWorkDay(WorkDay workDay) {
		this.workDay = workDay;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
