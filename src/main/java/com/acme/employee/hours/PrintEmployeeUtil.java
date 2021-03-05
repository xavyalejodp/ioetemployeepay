package com.acme.employee.hours;

import java.util.List;

public class PrintEmployeeUtil {
	
	public static void printEmployeesPaymentConsole(List<Employee> employees) {
		try {
			
			for (Employee employee : employees) {
				System.out.println("INPUT");
				System.out.print(employee.getEmployeeName().concat("="));
				List<WorkSchedule> workSchedules = employee.getEmployeeWorkSchedules();
				
				String outputDetail = "";
				for (WorkSchedule workSchedule : workSchedules) {
					outputDetail = outputDetail.concat(workSchedule.getCode());
					outputDetail = outputDetail.concat(workSchedule.getWorkDay().getWorkHour().getHourStart().toString());
					outputDetail = outputDetail.concat("-");
					outputDetail = outputDetail.concat(workSchedule.getWorkDay().getWorkHour().getHourEnd().toString());
					outputDetail = outputDetail.concat(",");
				}
				int lastIndex = outputDetail.lastIndexOf(",");
				outputDetail = outputDetail.substring(0, lastIndex);
				System.out.println(outputDetail);
				
				System.out.println("OUTPUT");
				
				System.out.println("The amount to pay "+ employee.getEmployeeName() + " is: " + employee.getEmployeeTotalAmountPayed() +" USD");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
