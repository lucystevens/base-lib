package uk.co.lukestevens.testing.mocks;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import uk.co.lukestevens.utils.Dates;

public class DateMocker {

	public static void setCurrentDate(LocalDateTime date) {
		try {
			Field f = Dates.class.getDeclaredField("currentDate");
			f.setAccessible(true);
			f.set(null, date);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void removeMockedDate() {
		setCurrentDate(null);
	}

}
