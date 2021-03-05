package com.acme.employee.hours;

import java.util.List;

public class Main {
	
	public static void main(String [] args) {
		
		try {
			String path = args[0];
			String file = args[1];
			
			List<Employee> employees = ReadEmployeesFileBusiness.readEmployeeFile(path, file);

			employees = EmployeeIncomeBusiness.getPaymentForEmployees(employees);
			PrintEmployeeUtil.printEmployeesPaymentConsole(employees);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
