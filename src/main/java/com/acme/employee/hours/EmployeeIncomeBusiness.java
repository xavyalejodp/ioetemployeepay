package com.acme.employee.hours;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class EmployeeIncomeBusiness {
	
	public static List<Employee> getPaymentForEmployees( List<Employee> employees){
		
		for (Employee employee : employees) {
			BigDecimal total = getTotalPayment(employee);
			employee.setEmployeeTotalAmountPayed(total);
		}
		
		return employees;
		
	}
	
	public static BigDecimal getTotalPayment(Employee employee) {
		
		BigDecimal total = new BigDecimal(0.0);
		try {
			
			List<WorkSchedule> workSchedules = employee.getEmployeeWorkSchedules();
			
			for (WorkSchedule workSchedule : workSchedules) {
				total = total.add(getPayByPeriod(workSchedule));
			}
			
		} catch (Exception e) {
			
		}
		
		return total;
	}
	
	
	private static BigDecimal getPayByPeriod(WorkSchedule workSchedule) {
		BigDecimal payment = new BigDecimal(0.0);
		
		
		if(workSchedule != null && 
				(			workSchedule.getWorkDay().getDayCode().equalsIgnoreCase("MO") ||
							workSchedule.getWorkDay().getDayCode().equalsIgnoreCase("TU") ||
							workSchedule.getWorkDay().getDayCode().equalsIgnoreCase("WE") ||
							workSchedule.getWorkDay().getDayCode().equalsIgnoreCase("TH") ||
							workSchedule.getWorkDay().getDayCode().equalsIgnoreCase("FR") 
		        )) 
			{
			
				payment = getPayFromTime(0, 1, 9, 0, workSchedule, new BigDecimal(25.0));
				
				payment = payment == null ? getPayFromTime(9, 1, 18, 0, workSchedule, new BigDecimal(15.0)):payment;
				
				payment = payment == null ? getPayFromTime(18, 1, 0, 0, workSchedule, new BigDecimal(20.0)):payment;
				
				payment = payment == null ? new BigDecimal(0.0):payment;
				
				return payment;
				
				
			}
		else if(workSchedule.getWorkDay().getDayCode().equalsIgnoreCase("SA") ||
				workSchedule.getWorkDay().getDayCode().equalsIgnoreCase("SU") )
		{
			payment = getPayFromTime(0, 1, 9, 0, workSchedule, new BigDecimal(30.0));
			
			payment = payment == null ? getPayFromTime(9, 1, 18, 0, workSchedule, new BigDecimal(20.0)):payment;
			
			payment = payment == null ? getPayFromTime(18, 1, 0, 0, workSchedule, new BigDecimal(25.0)):payment;
			
			payment = payment == null ? new BigDecimal(0.0):payment;
			
			return payment;
			
		}
		
		return payment;
	}
	
	public static BigDecimal getTotalPayByHour(WorkHour workHour, BigDecimal payPerHour) {
		
		BigDecimal total = new BigDecimal(0.0);
		LocalTime result = LocalTime.of(0, 1);
		result = workHour.getHourEnd().minus(workHour.getHourStart().getMinute(), ChronoUnit.MINUTES).minus(workHour.getHourStart().getHour(), ChronoUnit.HOURS);
		
		double workedHours = result.getHour();
		double workedMinutes = result.getMinute() / 60.0;
		
		workedHours = workedHours + workedMinutes;
		
		total = new BigDecimal(workedHours).multiply(payPerHour);
		
		return total;
		
	}
	
	public static BigDecimal getPayFromTime(int startHour, int startMinute, int endHour, int endMinute, WorkSchedule workSchedule, BigDecimal payPerHour) {
		
		BigDecimal payment  = null; 
		
		LocalTime start = LocalTime.of(startHour, startMinute);
		
		if(endHour == 0) {
			endHour = 23;
			endMinute = 59;
		}
		
		LocalTime end = LocalTime.of(endHour, endMinute);
		
		LocalTime e_start = workSchedule.getWorkDay().getWorkHour().getHourStart();
		LocalTime e_end = workSchedule.getWorkDay().getWorkHour().getHourEnd();
		
		
		if(e_start.compareTo(start) >= 0 && e_end.compareTo(end) <= 0) {
			payment = getTotalPayByHour(workSchedule.getWorkDay().getWorkHour(), payPerHour);
			return payment;
		}
		
		return payment;
	}
	
}
