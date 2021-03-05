package com.acme.employee.hours;

import java.time.LocalTime;

public class WorkScheduleUtil {
	
	public static final WorkDay fillWorkday(String dayCode, String dayDescription, int hourStart, int minuteStart, int hourEnd, int minuteEnd, String description) {
		
		LocalTime localTimeStart = LocalTime.of(hourStart, minuteStart);
		LocalTime localTimeEnd = LocalTime.of(hourEnd, minuteEnd);
		WorkHour workHour = new WorkHour(localTimeStart, localTimeEnd, description);
		
		WorkDay workDay = new WorkDay(dayCode, dayDescription, workHour);
		
		
		return workDay;
	}

}
