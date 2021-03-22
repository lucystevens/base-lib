package uk.co.lukestevens.testing.mocks

import java.lang.reflect.Field
import java.util.Date
import uk.co.lukestevens.utils.Dates

object DateMocker {
	fun setCurrentDate(date: Date?) {
		val f = Dates::class.java.getDeclaredField("currentDate")
		f.setAccessible(true)
		f.set(null, date)
	}

	fun removeMockedDate() {
		setCurrentDate(null)
	}
}