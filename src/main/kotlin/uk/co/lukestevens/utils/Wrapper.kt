package uk.co.lukestevens.utils

import java.util.Objects

/**
 * A wrapper class for allowing objects to be set within lambda functions
 *
 * @author luke.stevens
 *
 * @param <T> The type of object that this wraps
 */
class Wrapper<T>
/**
 * Creates a wrapper with an initial value
 * @param value The initial value of the wrapped object
 */
constructor(var value: T? = null) {

	/**
	 * @return true if the wrapped instance is null
	 */
	fun isNull(): Boolean {
		return value == null
	}

	/**
	 * @return The wrapped instance
	 */
	fun get(): T? {
		return value
	}

	/**
	 * Set the wrapped instance
	 * @param value
	 */
	fun set(value: T?) {
		this.value = value
	}

	@Override
	override fun toString(): String {
		return value?.toString()?: "null"
	}

	@Override
	override fun hashCode(): Int {
		return value?.hashCode()?: 0
	}

	@Override
	override fun equals(other: Any?): Boolean {
		return Objects.equals(other, value)
	}
}