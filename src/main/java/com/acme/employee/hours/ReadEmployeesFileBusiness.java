package com.acme.employee.hours;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadEmployeesFileBusiness {
	
	public static List<Employee> readEmployeeFile(String pathName, String fileName) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
				  String resourse = pathName.concat(fileName);
			      File employeesFile = new File(resourse);
			      Scanner reader = new Scanner(employeesFile);
			      while (reader.hasNextLine()) {
			        String data = reader.nextLine();
			        Employee employee = loadEmployee(data);
			        employees.add(employee);
			        //System.out.println("INPUT");
			        //System.out.println(data);
			      }
			      reader.close();
			    } catch (FileNotFoundException e) {
			      //System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		
		return employees;
				
	}
	
	public static Employee loadEmployee(String data) {
		Employee employee = new Employee();
		
		//data = "RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
		
		String[] dataStruct = data.split("=");
		
		String name = dataStruct[0];
		data = dataStruct[1];
		dataStruct = data.split(",");

		List<WorkSchedule> workSchedules = new ArrayList<WorkSchedule>();
		
		for (String schedule : dataStruct) {
			String day = schedule.substring(0, 2);
			int startHour = Integer.parseInt(schedule.substring(2,4));
			int startMinute = Integer.parseInt(schedule.substring(5,7));
			int endtHour = Integer.parseInt(schedule.substring(8,10));
			int endMinute = Integer.parseInt(schedule.substring(11,13));
			
			WorkDay workDay = WorkScheduleUtil.fillWorkday(day, day, startHour, startMinute, endtHour, endMinute, day);
			WorkSchedule workSchedule = new WorkSchedule(day, day, workDay, null);
			
			workSchedules.add(workSchedule);
				
		}
		
		employee.setEmployeeName(name);
		employee.setEmployeeWorkSchedules(workSchedules);
		
	
		return employee;
		
		
		
	}

}
