/**
 * 
 */
package com.acme.employee.hours;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sun.tools.javac.util.Assert;

/**
 * @author owner
 *
 */
public class TestEmployee {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void test() {
		Employee employee = new Employee();
		
		
		employee.getClass();
		
		System.out.println("Prueba");
		
		LocalTime start = LocalTime.of(0, 1);
		System.out.println(start);

		LocalTime end = LocalTime.of(9, 0);
		System.out.println(end);
		System.out.println(start);
		System.out.println(end);
		
		end.minus(start.getMinute(), ChronoUnit.HOURS);
		end.minus(start.getHour(), ChronoUnit.MINUTES);
		
		LocalTime result = LocalTime.of(0, 1);
		result = end.minus(start.getMinute(), ChronoUnit.MINUTES).minus(start.getHour(), ChronoUnit.HOURS);
		System.out.println(result);
		Assert.check(true);
		
	}
	
	//@Test
	public void testEmployee() {
		
		WorkDay workDay =  WorkScheduleUtil.fillWorkday("MO", "MONDAY", 10, 0, 12, 0, null);
		WorkSchedule workSchedule = new WorkSchedule("MO", "MON EMP 1", workDay, null);
		Employee employee = new Employee();
		employee.setEmployeeName("XD");
		
		List<WorkSchedule> workShedules = new  ArrayList<WorkSchedule>();
		workShedules.add(workSchedule);
		workDay =  WorkScheduleUtil.fillWorkday("TU", "TUESDAY", 10, 0, 12, 0, null);
		workSchedule = new WorkSchedule("TU", "TU EMP 1", workDay, null);
		workShedules.add(workSchedule);
		workDay =  WorkScheduleUtil.fillWorkday("TH", "THURSDAY", 1, 0, 3, 0, null);
		workSchedule = new WorkSchedule("TH", "TH EMP 1", workDay, null);
		workShedules.add(workSchedule);
		workDay =  WorkScheduleUtil.fillWorkday("SA", "SAT", 14, 0, 18, 0, null);
		workSchedule = new WorkSchedule("SA", "SA EMP 1", workDay, null);
		workShedules.add(workSchedule);
		workDay =  WorkScheduleUtil.fillWorkday("SU", "SUN", 20, 0, 21, 0, null);
		workSchedule = new WorkSchedule("SU", "SU EMP 1", workDay, null);
		workShedules.add(workSchedule);
		
	
		employee.setEmployeeWorkSchedules(workShedules);
		BigDecimal total = EmployeeIncomeBusiness.getTotalPayment(employee);
		
		System.out.println(total);
		
	}
	
	//@Test
	public void loadEmployee() {
		Employee employee = ReadEmployeesFileBusiness.loadEmployee(null);
		System.out.println(employee.toString());
	}
	
	@Test
	public void loadEmployessFromFile() {
		List<Employee> employees = ReadEmployeesFileBusiness.readEmployeeFile("", "employees.txt");
		System.out.println(employees.toString());
		employees = EmployeeIncomeBusiness.getPaymentForEmployees(employees);
		PrintEmployeeUtil.printEmployeesPaymentConsole(employees);
	}

}
