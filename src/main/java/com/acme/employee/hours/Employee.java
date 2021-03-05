package com.acme.employee.hours;

import java.math.BigDecimal;
import java.util.List;

public class Employee {
	
	private String employeeName;
	private List<WorkSchedule> employeeWorkSchedules;
	private BigDecimal employeeTotalAmountPayed;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public List<WorkSchedule> getEmployeeWorkSchedules() {
		return employeeWorkSchedules;
	}
	public void setEmployeeWorkSchedules(List<WorkSchedule> employeeWorkSchedules) {
		this.employeeWorkSchedules = employeeWorkSchedules;
	}
	public BigDecimal getEmployeeTotalAmountPayed() {
		return employeeTotalAmountPayed;
	}
	public void setEmployeeTotalAmountPayed(BigDecimal employeeTotalAmountPayed) {
		this.employeeTotalAmountPayed = employeeTotalAmountPayed;
	}
	
		

}
